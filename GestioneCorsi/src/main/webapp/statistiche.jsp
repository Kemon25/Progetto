<%@page import="it.betacom.businesscomponent.model.Corso"%>
<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
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
		
		<div>
		<% for(Corso c:AdminFacade.getInstance().getCorsoMaxFreq()){%>
		<p>
			Il corso pi&ugrave; frequentato &egrave;: <strong> <%=c.getNomeCorso()%>
			</strong>
		</p>
		<%}%>
		</div>
		
		<div>
		<p>
			Data inizio dell'ultimo corso: <strong> <%=String.format("yyyy-MM-dd",AdminFacade.getInstance().getUltimoCorso()) %>
			</strong>
		</p>
		</div>
		
		</div>
</body>
</html>
<%
}
%>