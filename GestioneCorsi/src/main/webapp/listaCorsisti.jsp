<!DOCTYPE html>
<%@page import="it.betacom.businesscomponent.model.Corsista"%>
<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
<%@page import="it.betacom.businesscomponent.model.Corso"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<%@ include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Lista corsisti</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/validazione.js"></script>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<header class="page-header">
			<h3>Corsi presenti</h3>
		</header>


		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Cognome</th>
						<th>Precedenti formativi</th>
					</tr>
				</thead>
				<tbody>
					<%
						String s = String.valueOf(request.getAttribute("idCorsista"));
						ArrayList<Corsista> corsisti  = AdminFacade.getInstance().getAllCorsista();
							for(Corsista c : corsisti){
								if(c.getId() == Long.parseLong(s)){
								%>
					<tr bgcolor="yellow">
						<td><%=c.getNome() %></td>
						<td><%=c.getCognome() %></td>
						<td><%=c.getPrecedentiFormativi()%></td>
					</tr>
					<% 
								}
								%>


					<tr>
						<td><%=c.getNome() %></td>
						<td><%=c.getCognome() %></td>
						<td><%=c.getPrecedentiFormativi()%></td>
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
