<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca</title>
</head>
<body>

	<div class="generic-container" ng-controller="ActorController as ctrl">
		<div class="panel panel-default">

			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.actor.actor_id" name="actor_id" />
					<div class="container">
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Nome</label>
								<div class="col-md-7">

									<input type="text" ng-model="ctrl.actor.first_name" name="nome"
										class="username form-control input-sm"
										placeholder="Inserisci il nome" required ng-minlength="3" />
									<div class="has-error" ng-show="myForm.$dirty">
										<span ng-show="myForm.first_name.$error.required">This
											is a required field</span> <span
											ng-show="myForm.first_name.$error.minlength">Minimum
											length required is 3</span> <span
											ng-show="myForm.first_name.$invalid">This field is
											invalid </span>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Cognome</label>
								<div class="col-md-7">
									<input type=text ng-model="ctrl.actor.last_name" name="cognome"
										class="email form-control input-sm"
										placeholder="Inserisci il congnome" required />
									<div class="has-error" ng-show="myForm.$dirty">
										<span ng-show="myForm.last_name.$error.required">Campo
											obbligatorio</span> <span ng-show="myForm.last_name.$invalid">Campo
											obbligatorio</span>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-actions floatRight">
								<!--<input type="submit"
								value="{{!ctrl.actor.actor_id ? 'Add' : 'Update'}}"
								class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">-->
								<button type="button" ng-click="ctrl.reset()"
									class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset
									
									
									Form</button>
								<button type="button"
									ng-click="ctrl.fetchAllActors(); ricerca=true"
									class="btn btn-warning btn-sm">Ricerca</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>

		<!-- TABELLA RICERCA -->

		<div class="tablecontainer" ng-show="ricerca">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>ID.</th>
						<th>Nome</th>
						<th>Cognome</th>
						<th width="20%"></th>
					</tr>
				</thead>
				<tbody>
				
				
				
					<tr ng-repeat="u in ctrl.actors">
						<td><span ng-bind="u.actor_id"></span></td>
						<td><span ng-bind="u.first_name"></span></td>
						<td><span ng-bind="u.last_name"></span></td>
						<td>
							<!-- <button ng-click="ctrl.goEdit()">dettaglio</button> -->
							<button type="button" ng-click="ctrl.edit(u.actor_id)"
								class="glyphicon glyphicon-pencil"></button>
							<button type="button" ng-click="ctrl.remove(u.actor_id)"
								class=" glyphicon glyphicon-trash"></button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>