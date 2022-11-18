<%@page import="it.betacom.businesscomponent.model.Docente"%>
<%@page import="it.betacom.businesscomponent.model.Corsista"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="it.betacom.businesscomponent.model.Corso"%>
<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
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
<title>Statistiche</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<header class="page-header">
			<h3>Statistiche dei Corsi</h3>
		</header>


		<div>
			<p>
				Numero corsisti totali: <strong> <%=AdminFacade.getInstance().getAllCorsista().size()%>
				</strong>
			</p>
		</div>


		<%
		for (Corso c : AdminFacade.getInstance().getCorsoMaxFreq()) {
		%>
		<div>

			<p>
				Il corso pi&ugrave; frequentato &egrave;: <strong> <%=c.getNomeCorso()%>
				</strong>
			</p>

		</div>
		<%
		}
		%>

		<%
		DateFormat formato = new SimpleDateFormat("dd-MMM-yyyy");
		%>
		<div>
			<p>
				Da inizio dell'ultimo corso: <strong> <%=formato.format(AdminFacade.getInstance().getUltimoCorso())%>
				</strong>
			</p>
		</div>

		<div>
			<p>
				Durata media dei corsi: <strong> <%=AdminFacade.getInstance().getMediaCorsi()%>
				</strong>&nbsp;giorni
			</p>
		</div>

		<div>
			<p>
				Fra i vari corsi ci sono: <strong> <%=AdminFacade.getInstance().getNumCommenti()%>
				</strong>&nbsp;commenti
			</p>
		</div>

		<div class="table-responsive">
			<h3>Elenco Corsisti</h3>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Cognome</th>
						<th>Precedenti Formativi</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Corsista c : AdminFacade.getInstance().getAllCorsista()) {
						String precedenti = new String();
						if (c.getPrecedentiFormativi() == 0)
							precedenti = "No";
						else
							precedenti = "Si";
					%>
					<tr>
						<td><a href="corsista.jsp?idCorsista=<%=c.getId()%>"><%=c.getNome()%></a></td>
						<td><%=c.getCognome()%></td>
						<td><%=precedenti%></td>
					</tr>
					<%
					}
					%>
				</tbody>

			</table>
		</div>


		<div class="table-responsive">
			<h3>Elenco corsi disponibili</h3>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Aula</th>

					</tr>
				</thead>
				<tbody>
					<%
					for (Corso c : AdminFacade.getInstance().getCorsiDisponibili()) {
						String precedenti = new String();
					%>
					<tr>
						<td><%=c.getNomeCorso()%></td>
						<td><%=c.getAula()%></td>
					</tr>
					<%
					}
					%>
				</tbody>

			</table>
		</div>


		<div class="table-responsive">

			<h3>Elenco docenti che tengono pi&ugrave; di un corso</h3>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Cognome</th>
						<th>Cv</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Docente d : AdminFacade.getInstance().getDocentiMultiCorso()) {
						String precedenti = new String();
					%>
					<tr>
						<td><%=d.getNome()%></td>
						<td><%=d.getCognome()%></td>
						<td><%=d.getCv()%></td>
					</tr>
					<%
					}
					%>
				</tbody>

			</table>
		</div>
	</div>
	
	<p align="right">
			<button onclick="window.history.back()" class="btn btn-primary">Indietro</button>
	</p>
	
</body>
</html>

<%
}
%>