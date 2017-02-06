<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Attori</title>
<style>
.username.ng-valid {
	background-color: lightgreen;
}

.username.ng-dirty.ng-invalid-required {
	background-color: red;
}

.username.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
	<div class="generic-container" ng-controller="ActorController as ctrl">
		<div class="panel panel-default">
		
			<div class="panel-heading">
				<span class="lead">Registrazione</span>
			</div>
			
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.actor.actor_id" name="actor_id" />
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
							<input type="submit"
								value="{{!ctrl.actor.actor_id ? 'Add' : 'Update'}}"
								class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							<button type="button" ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset
								Form</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">Lista degli attori</span>
			</div>
			<div class="tablecontainer">
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
								<button ng-click="ctrl.goEdit()">dettaglio</button>

								<button type="button" ng-click="ctrl.edit(u.actor_id)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" ng-click="ctrl.remove(u.actor_id)"
									class="btn btn-danger custdom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/user_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/user_controller.js' />"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>

</body>
</html>