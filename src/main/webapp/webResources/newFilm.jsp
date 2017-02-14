<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="../bower_components/angular/angular.js"></script>
<script src="../bower_components/jquery/dist/jquery.min.js"></script>
<script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="../bower_components/angular-route/angular-route.js"></script>
<script src="../bower_components/bootstrap/dist/js/bootbox.min.js"></script>
<script src="../bower_components/ngBootbox/dist/ngBootbox.js"></script>

<script src="../static/js/app.js"></script>
<script src="../static/js/service/user_service.js"></script>
<script src="../static/js/controller/user_controller.js"></script>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="../bower_components/bootstrap/dist/css/bootstrap.min.css" />

<!-- Optional theme -->
<link rel="stylesheet"
	href="../bower_components/bootstrap/dist/css/bootstrap-theme.min.css" />

<title></title>
</head>

<body>
	<div ng-controller="ActorController as ctrl">
		<form ng-submit="ctrl.submit()" name="myForm">
			<div class="container">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable" for="file">Titolo</label>
						<div class="col-md-7">
							<input type="text" ng-model="ctrl.film.filmName" name="titolo"
								placeholder="Titolo film" required ng-minlength="3"
								class="input-md" />
						</div>

					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable" for="file">Genere</label>
						<div class="col-md-7">
							<input type="text" ng-model="ctrl.film.genre" name="genere"
								placeholder="Genere" required ng-minlength="3" class="input-md" />
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>

</html>