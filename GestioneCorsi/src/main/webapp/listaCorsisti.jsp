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
						String id = String.valueOf(request.getAttribute("idCorsista"));
						ArrayList<Corsista> corsisti  = AdminFacade.getInstance().getAllCorsista();
						Corsista corsista = AdminFacade.getInstance().getByIdCorsista(Long.parseLong(id));
					%>
						<tr bgcolor="yellow">
							<td><%=corsista.getNome() %></td>
							<td><%=corsista.getCognome() %></td>
							<td><%=corsista.getPrecedentiFormativi()%></td>
						</tr>
					<%
						for(Corsista c : corsisti){
							if(c.getId() != Long.parseLong(id)){
					%>
						<tr>
							<td><%=c.getNome() %></td>
							<td><%=c.getCognome() %></td>
							<td><%=c.getPrecedentiFormativi()%></td>
						</tr>
					<% 
								}
						}
					%>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
