<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
<%@page import="it.betacom.businesscomponent.model.Docente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modal Controllo Corsista</title>
</head>
<body>


	<div class="btn-group">
		<button type="button" class="btn btn-2" data-toggle="modal"
			data-target="#myModal2">Creazione corso</button>
	</div>

	<div id="myModal2" class="modal fade" role="dialog">
		<div class="modal-dialog modal-lg">
			<form action="<%=application.getContextPath()%>/controlloCorso"
				method="post" class="form-horizontal" id="userForm">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Creazione Corso</h4>
					</div>
					<div class="modal-body">
						

						
						<div class="form-group">
							<label class="col-md-2 control-label" style=" text-align: left;">Docente</label>
							<div class="col-md-9 inputGroupContainer">
								<div class="input-group">

									<div class="btn-group">
										<button type="button" class="btn btn-default dropdown-toggle"
											data-toggle="dropdown">
											scegli i docenti per il corso <span class="caret"></span>
										</button>
										<ul class="dropdown-menu" role="menu">
											<%
								for (Docente d : AdminFacade.getInstance().getAll()) {
								%>
								<li><input type="radio" name="idDocente"
									id="idDocente" value=<%=d.getId()%> required="required">&nbsp;<%=d.getNome()%></li>
								<%
								}
								%>
										</ul>
									</div>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-2 control-label" style="text-align: left;">Nome
								corso</label>
							<div class="col-md-9 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="glyphicon glyphicon-text-width"></i>
									</span> <input type="text" name="nomeCorso" id="nomeCorso"
										placeholder="Max 30 caratteri, solo lettere" class="form-control" required>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label" style="text-align: left;">Data
								inizio</label>
							<div class="col-md-9 inputGroupContainer">
								<div class="input-group date" id="dp">
									<span class="input-group-addon"> <i
										class="glyphicon glyphicon-calendar"></i>
									</span> <input type="text" name="dataInizio" id="dataInizio"
										placeholder="DD/MM/YYYY" class="form-control">
								</div>
							</div>
						</div>
						<script>
						$(function() {
							$('#dp').datepicker({
								format : 'dd/mm/yyyy',
								autoclose : true,
								startDate : '+1d',
								endDate : '31/12/2050'
							}).on('changeDate');
						});
						</script>

						<div class="form-group">
							<label class="col-md-2 control-label" style="text-align: left;">Data
								fine</label>
							<div class="col-md-9 inputGroupContainer">
								<div class="input-group date" id="dp1">
									<span class="input-group-addon"> <i
										class="glyphicon glyphicon-calendar"></i>
									</span> <input type="text" name="dataFine" id="dataFine"
										placeholder="DD/MM/YYYY" class="form-control">
								</div>
							</div>
						</div>
						<script>
							
							$(function() {
								$('#dp1').datepicker({
									format : 'dd/mm/yyyy',
									autoclose : true,
									startDate : '+3d',
									endDate : '31/12/2050'
								}).on('changeDate');
							});
						</script>

						<div class="form-group">
							<label class="col-md-2 control-label" style="text-align: left;">Costo</label>
							<div class="col-md-9 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="glyphicon glyphicon-yen"></i>
									</span> <input type="text" name="costo" id="costo"
										placeholder="Max 999999.99" class="form-control" required>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label" style="text-align: left;">Commenti</label>
							<div class="col-md-9 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="glyphicon glyphicon-option-horizontal"></i>
									</span>
									<textarea rows="6" cols="60" name="commenti" id="commenti"
										placeholder="(max 200 caratteri)" class="form-control" style="resize: none;" maxlength="200"></textarea>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-2 control-label" style="text-align: left;">Aula</label>
							<div class="col-md-9 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="glyphicon glyphicon-home"></i>
									</span> <input type="text" name="aula" id="aula" placeholder="(no caratteri speciali, max 4 caratteri)"
										class="form-control" maxlength="4" required>
								</div>
							</div>
						</div>


					
					<div class="modal-footer">
						<button type="submit" class="btn btn-default">Crea corso</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Annulla</button>
					</div>
					</div>
				</div>
			</form>	
		</div>
	</div>
</body>
</html>