<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Error Page</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="container">
		<header class="page-header">
			<h1>Pagina di errore</h1>
		</header>
		<!-- 1 equivale al corso, 2 al corsista -->
		<%
		int errore = Integer.parseInt(request.getParameter("errore"));
		if (errore == 1) {
		%>
		<h2>Impossibile creare il corso!</h2>
		<button onclick="location.href='home.jsp'" class="btn btn-primary">Home</button>
		<%
		} else if (errore == 2) {
		%>
		<h2>Impossibile assegnare un corsista all'interno di un corso!</h2>
		<button onclick="location.href='home.jsp'" class="btn btn-primary">Home</button>
		<%
		}
		%>
	</div>
</body>
</html>