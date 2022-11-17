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
		<button type="button" class="btn btn-default" data-toggle="modal"
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
			<label class="col-md-2 control-label" style="text-align: left;">Nome corso</label>
			<div class="col-md-9 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-text-width"></i>
					</span> 
					<input type="text" name="nomeCorso" id="nomeCorso"
						placeholder="Nome corso..." class="form-control" required>
				</div>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-2 control-label" style="text-align: left;">Data inizio</label>
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
					startDate : '01/01/1900',
					endDate : '31/12/2050'
					}).on('changeDate');
				});
		</script>
		
		<div class="form-group">
			<label class="col-md-2 control-label" style="text-align: left;">Data fine</label>
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
					startDate : '01/01/1900',
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
					</span> 
					<input type="text" name="costo" id="costo"
						placeholder="Costo..." class="form-control" required>
				</div>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-2 control-label" style="text-align: left;" >Commenti</label>
			<div class="col-md-9 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-option-horizontal"></i>
					</span>
					<textarea rows="6" cols="60" name="commenti" id="commenti"
							class="form-control" style="resize: none;" maxlength="500"></textarea>
				</div>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-2 control-label" style="text-align: left;">Aula</label>
			<div class="col-md-9 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-home"></i>
					</span> 
					<input type="text" name="aula" id="aula"
						placeholder="Aula..." class="form-control" maxlength="4" required>
				</div>
			</div>
		</div>


      </div>
      <div class="modal-footer">
      	<button type="submit" class="btn btn-default">Crea corso</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>    
    </div>
	</form>
  </div>
</div>



</body>
</html>