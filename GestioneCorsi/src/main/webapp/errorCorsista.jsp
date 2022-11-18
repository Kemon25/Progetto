<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<%@ include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Error Corsista</title>
</head>
<body  class="index noScrollbar">
	<div class="container">
		<div class="page-header">
			<h3 id="colorLabel">Errore nella validazione</h3>
		</div>
		<div class="panel panel-warning">
			<header class="panel-heading">
				<h4>Errore nel inserimento dati</h4>
			</header>
			<div class="panel-body">
				<p>
					Validazione Corsista non riuscita
				<p align="right">
					<button onclick="window.history.back()" class="btn btn-primary">Indietro</button>
				</p>
			</div>
		</div>
	</div>
</body>
</html>