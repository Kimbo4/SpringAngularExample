<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Home</title>

<script src="bower_components/angular/angular.js"></script>
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="bower_components/angular-route/angular-route.js"></script>
<script src="bower_components/bootstrap/dist/js/bootbox.min.js"></script>
<script src="bower_components/ngBootbox/dist/ngBootbox.js"></script>

<script src="static/js/app.js"></script>
<script src="static/js/service/user_service.js"></script>
<script src="static/js/controller/user_controller.js"></script>
<script src="static/js/controller/film_controller.js"></script>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="bower_components/bootstrap/dist/css/bootstrap.min.css" />

<!-- Optional theme -->
<link rel="stylesheet"
	href="bower_components/bootstrap/dist/css/bootstrap-theme.min.css" />
</head>


<script>
	
</script>
<body ng-app="myApp" class="ng-cloak">
	<div class="generic-container" ng-controller="ActorController as ctrl">

		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<ul class="nav navbar-nav">
						<li><a href="#/">Home <span class="sr-only">(current)</span></a>
						</li>
						<li><a href="#/ricerca">Ricerca <span class="sr-only">(current)</span></a>
						</li>
						<li><a href="#/new"> Inserisci <span class="sr-only">(current)</span></a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<div ng-view></div>

</body>

</html>