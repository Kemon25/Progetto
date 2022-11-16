<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="it.betacom.businesscomponent.model.Docente"%>
<%@page import="it.betacom.businesscomponent.model.Corso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
<%@page import="it.betacom.businesscomponent.model.Corsista"%>
<%
	if (session.getAttribute("username") != null)
		response.sendRedirect("index.jsp");
	else {
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Dati Corsista</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<header class="page-header">
			<h3>Dati del corsista</h3>
		</header>
		<div>
		<%
			long id = Long.valueOf(request.getParameter("idCorsista"));
			Corsista corsista = new Corsista();
			corsista = AdminFacade.getInstance().getByIdCorsista(id);
		%>
		<p>
			Nome: 
			<strong> 
				<%=corsista.getNome()%>
			</strong>
		</p>
		<br>
		<p>
			Cognome: 
			<strong> 
				<%=corsista.getCognome()%>
			</strong>
		</p>
		<br>
		<p>
			Precedenti formativi: 
			<strong>
			<%
				String precFormativi = "";
				int swap = corsista.getPrecedentiFormativi();
				if(swap == 1){
					precFormativi = "si";
				} else if (swap == 0) {
					precFormativi = "no";
				} else {
					precFormativi = "error";
				}
			%>
			<%=precFormativi%>
			</strong>
		</p>
		</div>
		
		<header class="page-header">
			<h3>Corsi tenuti da <%=corsista.getNome()%></h3>
		</header>
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Corso</th>
						<th>Docente</th>
						<th>Data Inizio</th>
						<th>Data Fine</th>
						<th>Costo</th>
						<th>Commenti</th>
						<th>Aula</th>
					</tr>
				</thead>
				<tbody>
					<%
						DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
						ArrayList<Corso> corsi = new ArrayList<Corso>();
						corsi = AdminFacade.getInstance().getCorsoByIdCorsista(id);
						Docente docente = new Docente();
						for(Corso corso : corsi){
							docente = AdminFacade.getInstance().getById(corso.getIdDocente());
					%>
					<tr>
						<td><%=corso.getNomeCorso()%></td>
						<td><%=docente.getNome()%></td>
						<td><%=df.format(corso.getDataInizio())%></td>
						<td><%=df.format(corso.getDataFine())%></td>
						<td><%=String.format("%.2f", corso.getCosto())%></td>
						<td><%=corso.getCommenti()%></td>
						<td><%=corso.getAula()%></td>
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