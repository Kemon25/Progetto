<%@page import="it.betacom.businesscomponent.model.Corsista"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="CDN.html" %>
	<meta charset="ISO-8859-1">
	<title>Home</title>
	<link rel="stylesheet" href="css/style.css">
</head>

<body>
<jsp:include page="nav.jsp"/>
<%
	ArrayList<Corsista> corsista = AdminFacade.getInstance().getAllCorsista();
		for(Corsista c : corsista) {
%>

	<table class="table table-striped">
  		<thead>
  			<tr><%= c.getNome() %></tr>
  			<tr><%= c.getCognome() %></tr>
  			<tr><%= c.getPrecedentiFormativi() %></tr>
  		</thead>	
	</table>
<%
		}
%>

</body>
</html>