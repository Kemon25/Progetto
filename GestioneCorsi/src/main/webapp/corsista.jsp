<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="it.betacom.businesscomponent.model.Docente"%>
<%@page import="it.betacom.businesscomponent.model.Corso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
<%@page import="it.betacom.businesscomponent.model.Corsista"%>
<%
	if (session.getAttribute("username") == null)
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
<body class="index">
	<jsp:include page="nav.jsp" />
	<div class="container">
		<header class="page-header">
			<h3 id="colorLabel">Dati del corsista</h3>
		</header>
		<div id="colorLabel">
		<%
			long id = Long.valueOf(request.getParameter("idCorsista"));
			Corsista corsista = new Corsista();
			corsista = AdminFacade.getInstance().getByIdCorsista(id);
		%>
		<p id="colorLabel">
			Nome: 
			<strong> 
				<%=corsista.getNome()%>
			</strong>
		</p>
		<br>
		<p id="colorLabel">
			Cognome: 
			<strong> 
				<%=corsista.getCognome()%>
			</strong>
		</p>
		<br>
		<p id="colorLabel">
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
			<h3 id="colorLabel">Corsi seguiti da <%=corsista.getNome()%></h3>
		</header>
		<div class="table-responsive">
			<table class="table table-hover" id="rigata">
				<thead>
					<tr>
						<th id="colorLabel">Corso</th>
						<th id="colorLabel">Docente</th>
						<th id="colorLabel">Data Inizio</th>
						<th id="colorLabel">Data Fine</th>
						<th id="colorLabel">Costo</th>
						<th id="colorLabel">Commenti</th>
						<th id="colorLabel">Aula</th>
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
							String commenti = new String();
							if(corso.getCommenti()==null)
								commenti="";
							else
								commenti=corso.getCommenti();
					%>
					<tr>
						<td id="colorLabel"><%=corso.getNomeCorso()%></td>
						<td id="colorLabel"><%=docente.getNome()%></td>
						<td id="colorLabel"><%=df.format(corso.getDataInizio())%></td>
						<td id="colorLabel"><%=df.format(corso.getDataFine())%></td>
						<td id="colorLabel"><%=String.format("%.2f", corso.getCosto())%></td>
						<td id="colorLabel"><%=commenti%></td>
						<td id="colorLabel"><%=corso.getAula()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		
		<p align="right">
			<button onclick="window.history.back()" class="btn btn-primary">Indietro</button>
		</p>
		
	</div>
	
</body>
</html>
<%
}
%>