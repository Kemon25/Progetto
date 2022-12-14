<%@page import="java.util.Random"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<% 
Random rand = new Random();
Random rand2 = new Random();
int num = rand2.nextInt(3) + 1;
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html"%>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Error page</title>
</head>
<body class="index">

<div class="container">
		<div class="page-header">
			<h3 id="colorLabel">Non sei stato fortunato</h3>
		</div>
		
		
		
		<div class="panel panel-warning">
			<div class="panel-heading">
				<h4 >Ecco un meme per rallegrarti</h4>
			</div>
			<div class="panel-body">
			<%
				if(num == 1){
			%>
				<p >
					<img src="img/<%= rand.nextInt(14) + 1 %>.png" alt="meme" height="400" width="auto">
				</p>
			<%
				}else if (num == 2){
			%>
				<p>
					<img src="gif/<%= rand.nextInt(6) + 1 %>.gif" alt="meme" height="400" width="auto">
				</p>
			<%
				}else if (num == 3){
			%>
				<p>
					<img src="img/<%= rand.nextInt(12) + 1 %>.png" alt="meme" height="400" width="auto">
				</p>
			<%
				}
			%>
				<div class="btn-group">
					<button onclick="window.history.back()" class="btn btn-default">Indietro</button>	
				</div>
				
				<div class="btn-group">
					<button type="button" class="btn btn-default" data-toggle="modal"
							data-target="#myModal">Dettagli Errore</button>
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