<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html"%>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="/<%=application.getServletContextName()%>/css/style.css">
<title>Error page</title>
</head>
<body>

<div class="container">
		<div class="page-header">
			<h3>Errore nella pagina</h3>
		</div>
		<div class="panel panel-warning">
			<header class="panel-heading">
				<h4>Impossibile caricare la pagina richiesta</h4>
			</header>
<div class="panel-body">
				<p>
					Per segnalare un eventuale problema:&nbsp; <a
						href="mailto:betacom@tin.it">Contattare il supporto tecnico</a>
				<p>
					<input type="button" class="btn btn-default" value="Indietro"
						onclick="window.history.back()" />
				<p>
			</div>
			</div>
			</div>
			
</body>
</html>