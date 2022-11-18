<%@page import="it.betacom.businesscomponent.model.Corso"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>

<%
	if(session.getAttribute("username") == null) {
		response.sendRedirect("index.jsp");
	} else {	
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
	DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);

	List<Corso> corsi = AdminFacade.getInstance().getCorsiDisponibili();
	
%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Elimina corsi </title>
	<link rel="stylesheet" href="css/style.css">

</head>
<body class="index">
<jsp:include page="nav.jsp"/>
<div class="container">
	<header class="page-header">
		<h3 id="colorLabel">Corsi disponibili</h3>
	</header>
	
	
	<div class="table-responsive">
		<table class="table table-hover">
		
			<thead>
				<tr>
					<th id="colorLabel">Nome Corso</th>
					<th id="colorLabel">Docente</th>
					<th id="colorLabel">Data Inizio</th>
					<th id="colorLabel">Data Fine</th>
					<th id="colorLabel">Costo</th>
					<th id="colorLabel">Aula</th>
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
					<td id="colorLabel"><%= c.getNomeCorso()%></td>
					<td id="colorLabel"><%= AdminFacade.getInstance().getById(c.getIdDocente()).getCognome() %></td>
					
					<td id="colorLabel"><%= df.format(c.getDataInizio()) %></td>
					<td id="colorLabel"><%= df.format(c.getDataFine()) %></td>
					
					<td id="colorLabel"><%= String.format("%.2f", c.getCosto()) %> &euro;</td>
					<td id="colorLabel"><%= c.getAula()%></td>
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
		<p align="right">
			<button onclick="window.history.back()" class="btn btn-primary">Indietro</button>
		</p>
	</div>
</div>
		
</body>
</html>
<%
	}
%>