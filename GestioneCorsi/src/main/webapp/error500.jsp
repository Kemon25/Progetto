<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/<%=application.getServletContextName()%>/css/style.css">
<title>Error 500</title>
</head>
<body>
<div class="container">
	<div class="page-header">
		<h3>500 Internal Server Error</h3>
	</div>
	<div class="panel panel-warning">
		<header class="panel-heading">
			<h4>Errore interno del server</h4>
		</header>
		<div class="panel-body">
			<p>Torna alla Home</p>
			<p>
	 		<input type="button" class="btn btn-default" 
	 		value="Indietro" onclick="window.history.back()" /> 
	 		<p>
		</div>
	</div>
</div>

</body>
</html>