<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html"%>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Error page</title>
</head>
<body>

<div class="container">
		<div class="page-header">
			<h3>Errore nella pagina</h3>
		</div>
		
		
		
		<div class="panel panel-warning">
			<div class="panel-heading">
				<h4>Impossibile caricare la pagina richiesta</h4>
			</div>
			<div class="panel-body">
				
				
				
				<p>Per segnalare un eventuale problema:&nbsp; 
					<a href="mailto:betacom@tin.it">Contattare il supporto tecnico</a>
				</p>
				
				<div class="btn-group">
					<button onclick="window.history.back()" class="btn btn-default">Indietro</button>	
				</div>
				
				<div class="btn-group">
					<button type="button" class="btn btn-default" data-toggle="modal"
							data-target="#myModal">Ulteriori Dettagli</button>
				</div>
				
				<div id="myModal" class="modal fade" role="document">
				  <div class="modal-dialog modal-lg">
				
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				        <h4 class="modal-title">Dettagli Errore</h4>
				      </div>
				      
				      <div class="modal-body">
				      	<h5><%= exception.getClass().getName() %></h5>
						<p>Motivo:&nbsp;<%= exception.getMessage() %></p>
						<p>StackTrace:&nbsp;<% exception.printStackTrace(new PrintWriter(out)); %></p>
				      </div>
				      
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">Annulla</button>
				      </div>
				    </div>
				
				  </div>
				</div>
				
			</div>
		</div>
</div>			
</body>
</html>