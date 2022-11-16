<%@page import="it.betacom.businesscomponent.model.Corsista"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<jsp:include page="nav.jsp" />
	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Cognome</th>
					<th>Precedenti formativi</th>
				</tr>

			</thead>
			<tbody>
				<%
				ArrayList<Corsista> corsista = AdminFacade.getInstance().getAllCorsista();
				for (Corsista c : corsista) {
				%>
				<tr>
					<td><%=c.getNome()%></td>
					<td><%=c.getCognome()%></td>
					<td><%=c.getPrecedentiFormativi()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	
	<div class="btn-group">
		<form action="/statistiche.jsp">
			<button type="submit" class="btn btn-default">Creazione corsista</button>
		</form>
	</div>
	
	<div class="btn-group">
		<a href="statistiche.jsp">Ciao</a>
	</div>
	
	<div class="btn-group">
		<form action="statistiche.jsp">
			<button type="submit" class="btn btn-default">Creazione corsista</button>
		</form>
	</div>
	
</body>
</html>