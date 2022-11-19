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
<body class="index">
	<jsp:include page="nav.jsp" />
	<div class="container">
		<header class="page-header" id="colorHeader">
			<h3>Statistiche dei Corsi</h3>
		</header>

		<div id="colorLabel">
			<p>
				Numero corsisti totali: <strong> <%=AdminFacade.getInstance().getAllCorsista().size()%>
				</strong>
			</p>
		</div>

<%if(AdminFacade.getInstance().getCorsoMaxFreq().size()>1){ %>

		<h3 id="colorLabel">I corsi pi&ugrave; frequentati sono:</h3>
		<%}else{ %>
		<h3 id="colorLabel">Il corso pi&ugrave; frequentato &egrave;:</h3>
		<%
		}
		%>
		<%
		for (Corso c : AdminFacade.getInstance().getCorsoMaxFreq()) {
		%>
		<div id="colorLabel">

			<h4>
				<%=c.getNomeCorso()%>
			</h4>

		</div>
		<%
		}
		%>
		

		<%
		DateFormat formato = new SimpleDateFormat("dd-MMM-yyyy");
		%>
		<div id="colorLabel">
			<p>
				Da inizio dell'ultimo corso: <strong> <%=formato.format(AdminFacade.getInstance().getUltimoCorso())%>
				</strong>
			</p>
		</div>

		<div id="colorLabel">
			<p>
				Durata media dei corsi: <strong> <%=AdminFacade.getInstance().getMediaCorsi()%>
				</strong>&nbsp;giorni lavorativi
			</p>
		</div>

		<div id="colorLabel">
			<p>
				Fra i vari corsi ci sono: <strong> <%=AdminFacade.getInstance().getNumCommenti()%>
				</strong>&nbsp;commenti
			</p>
		</div>

		<div class="table-responsive">
			<h3 id="colorLabel">Elenco Corsisti</h3>
			<table class="table table-hover" id="rigata">
				<thead>
					<tr>
						<th id="colorLabel">Nome</th>
						<th id="colorLabel">Cognome</th>
						<th id="colorLabel">Precedenti Formativi</th>
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
						<td id="colorLabel"><a
							href="corsista.jsp?idCorsista=<%=c.getId()%>"><%=c.getNome()%></a></td>
						<td id="colorLabel"><%=c.getCognome()%></td>
						<td id="colorLabel"><%=precedenti%></td>
					</tr>
					<%
					}
					%>
				</tbody>

			</table>
		</div>


		<div class="table-responsive">
			<h3 id="colorLabel">Elenco corsi disponibili</h3>
			<table class="table table-hover" id="rigata">
				<thead>
					<tr>
						<th id="colorLabel">Nome</th>
						<th id="colorLabel">Aula</th>

					</tr>
				</thead>
				<tbody>
					<%
					for (Corso c : AdminFacade.getInstance().getCorsiDisponibili()) {
						String precedenti = new String();
					%>
					<tr>
						<td id="colorLabel"><%=c.getNomeCorso()%></td>
						<td id="colorLabel"><%=c.getAula()%></td>
					</tr>
					<%
					}
					%>
				</tbody>

			</table>
		</div>


		<div class="table-responsive">

			<h3 id="colorLabel">Elenco docenti che tengono pi&ugrave; di un
				corso</h3>
			<table class="table table-hover" id="rigata">
				<thead>
					<tr>
						<th id="colorLabel">Nome</th>
						<th id="colorLabel">Cognome</th>
						<th id="colorLabel">Cv</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Docente d : AdminFacade.getInstance().getDocentiMultiCorso()) {
						String precedenti = new String();
					%>
					<tr>
						<td id="colorLabel"><%=d.getNome()%></td>
						<td id="colorLabel"><%=d.getCognome()%></td>
						<td id="colorLabel"><%=d.getCv()%></td>
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