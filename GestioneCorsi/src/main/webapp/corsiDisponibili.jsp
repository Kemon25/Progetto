<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
<%@page import="it.betacom.businesscomponent.DocenteBC"%>
<%@page import="it.betacom.businesscomponent.CorsoBC"%>
<%@page import="it.betacom.businesscomponent.model.Corso"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>

<%
/*
	if(session.getAttribute("username") == null) {
		response.sendRedirect("index.jsp");
	} else {
	*/	
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
<body>
<jsp:include page="nav.jsp"/>
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
					<td><%= AdminFacade.getInstance().getById(c.getIdDocente()).getCognome() %></td>
					
					<td><%= df.format(c.getDataInizio()) %></td>
					<td><%= df.format(c.getDataFine()) %></td>
					
					<td><%= String.format("%.2f", c.getCosto()) %> &euro;</td>
					<td><%= c.getAula()%></td>
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
/*
	}
*/
%>