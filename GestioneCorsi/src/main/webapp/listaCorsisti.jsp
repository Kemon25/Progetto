<!DOCTYPE html>
<%@page import="it.betacom.businesscomponent.model.Corsista"%>
<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
<%@page import="it.betacom.businesscomponent.model.Corso"%>
<%@page import="java.util.ArrayList"%>
<%
if (session.getAttribute("username") == null) {
	response.sendRedirect("index.jsp");
} else {
%>
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
			<h3>Lista corsisti</h3>
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
						String id = String.valueOf(request.getParameter("idCorsista"));
						ArrayList<Corsista> corsisti  = AdminFacade.getInstance().getAllCorsista();
						Corsista corsista = AdminFacade.getInstance().getByIdCorsista(Long.parseLong(id));
						String precedenti = new String();
						if (corsista.getPrecedentiFormativi() == 0)
							precedenti = "No";
						else
							precedenti = "Si";
					%>
						<tr bgcolor="yellow">
							<td><%=corsista.getNome() %></td>
							<td><%=corsista.getCognome() %></td>
							<td><%=precedenti%></td>
						</tr>
					<%
						for(Corsista c : corsisti){
							if(c.getId() != Long.parseLong(id)){
								if (c.getPrecedentiFormativi() == 0)
									precedenti = "No";
								else
									precedenti = "Si";
					%>
						<tr>
							<td><%=c.getNome() %></td>
							<td><%=c.getCognome() %></td>
							<td><%=precedenti%></td>
						</tr>
					<% 
								}
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
