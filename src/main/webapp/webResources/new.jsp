<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci attore</title>
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
								<input type="submit" value="Inserisci"
									class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>