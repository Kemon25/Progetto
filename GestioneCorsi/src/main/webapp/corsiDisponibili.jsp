<%@page import="it.betacom.businesscomponent.DocenteBC"%>
<%@page import="it.betacom.businesscomponent.CorsoBC"%>
<%@page import="it.betacom.businesscomponent.model.Corso"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>

<%
	if(session.getAttribute("username") == null) {
		response.sendRedirect("index.jsp");
	} else {
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
	String query = request.getParameter("q");
	CorsoBC corso=new CorsoBC();
	List<Corso> corsi = corso.getCorsiDisponibili();
	DocenteBC d=new DocenteBC();
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina corsi </title>
</head>
<body>

<div class="container">
	<header class="page-header">
		<h3>Corsi disponibili</h3>
	</header>
	
	
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nome Corso</th>
					<th>Docente</th>
					<th>Data Inizio</th>
					<th>Data Fine</th>
					<th>Costo</th>
					<th>Aula</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
					for(Corso c : corsi) {
				%>
				<tr>				
					<td><%= c.getNomeCorso()%></td>
					<td><%= d.getById(c.getIdDocente()).getCognome()%></td>
					<td><%= c.getDataInizio()%></td>
					<td><%= c.getDataFine()%></td>
					<td><%= c.getCosto()%></td>				
					<td><%= c.getAula()%></td>		
					<td><%= String.format("%.2f", c.getCosto()) %> &euro;</td>
					<td>
					<td>
						<form action="/<%= application.getServletContextName() %>/rimuoviCorso?id=<%= c.getIdCorso() %>" method="post">
							<button class="btn btn-danger btn-xs" type="submit">
								<span class="glyphicon glyphicon-trash"></span>
							</button>
						</form>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>
<%
	}
%>