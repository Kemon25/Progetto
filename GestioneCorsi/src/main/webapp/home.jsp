<%@page import="it.betacom.businesscomponent.model.Corso"%>
<%@page import="it.betacom.businesscomponent.model.Corsista"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
if (session.getAttribute("username") == null) {
	response.sendRedirect("index.jsp");
} else {
%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html"%>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body class="home index">
	<jsp:include page="nav.jsp" />
<div class="container">
	<div class="table-responsive">
	<h1 class="Elenco">Elenco dei Corsisti</h1>
		<table class="table table-hover" id="rigata">
			<thead>			
				<tr>
					<th id="colorLabel">Nome</th>
					<th id="colorLabel">Cognome</th>
					<th id="colorLabel">Precedenti formativi</th>
				</tr>

			</thead>
			<tbody>
				<%
				ArrayList<Corsista> corsista = AdminFacade.getInstance().getAllCorsista();
				for (Corsista c : corsista) {
					String precedenti = null;
					if (c.getPrecedentiFormativi() == 0) {
						precedenti = "No";
					} else {
						precedenti = "Si";
					}
				%>
				<tr>
					<td id="colorLabel"><%=c.getNome()%></td>
					<td id="colorLabel"><%=c.getCognome()%></td>
					<td id="colorLabel"><%=precedenti%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>

	<div class="btn-group">
		<button type="button" class="btn btn-1" data-toggle="modal"
			data-target="#myModal">Creazione corsista</button>
	</div>

	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<form action="<%=application.getContextPath()%>/controlloCorsista"
				method="post" class="form-horizontal" id="userForm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only"></span>
						</button>
						<h4 class="modal-title">Inserisci i dati del nuovo corsista</h4>
					</div>
					<div class="modal-body">

						<div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left;">Nome</label>
							<div class="col-md-8 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="glyphicon glyphicon-user"></i>
									</span> <input type="text" name="nomeCorsista" id="nomeCorsista"
										placeholder="(max 30 caratteri, solo lettere)" class="form-control" required>
								</div>
							</div>

						</div>

						<div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left;">Cognome</label>
							<div class="col-md-8 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="glyphicon glyphicon-user"></i>
									</span> <input type="text" name="cognomeCorsista" id="cognomeCorsista"
										placeholder="(max 30 caratteri, solo lettere)" class="form-control" required>
								</div>
							</div>

						</div>

						<div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left;">Precedenti formativi</label>
							<div class="col-md-8">
								<div class="input-group">
									<input type="radio" name="PrecedentiFormativi"
									id="precedentiFormativi" value=1> Si <input
									type="radio" name="PrecedentiFormativi"
									id="precedentiFormativi" value=0> No
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label" style="text-align: left;">Corso</label>
							<div class="col-md-8 inputGroupContainer">
								<div class="input-group">

									<div class="btn-group">
										<button type="button" class="btn btn-default dropdown-toggle"
											data-toggle="dropdown">
											scegli il corso a cui iscrivere il corsista <span class="caret"></span>
										</button>
										<ul class="dropdown-menu" role="menu">
											<%
												int i = 0;
											for (Corso c : AdminFacade.getInstance().getCorsiIscrivibili()) {
												++i;
											%>
											<li><input type="checkbox" name="idCorso<%=i%>"
												id="idCorso<%=i%>" value=<%=c.getIdCorso()%>>&nbsp;<%=c.getNomeCorso()%></li>
											<%
											}
											%>
										</ul>
									</div>
								</div>
							</div>

						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-default">Crea
								corsista</button>
							<button type="submit" class="btn btn-default"
								data-dismiss="modal">Annulla</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

	<jsp:include page="modalControlloCorso.jsp" />
		
	<div class="btn-group">
		<form action="statistiche.jsp">
			<button type="submit" class="btn btn-3">Mostra statistiche</button>
		</form>
	</div>

	<div class="btn-group">
		<form action="corsiDisponibili.jsp">
			<button type="submit" class="btn btn-4">Elimina un corso</button>
		</form>
	</div>
</div>
</body>
</html>
<%
}
%>