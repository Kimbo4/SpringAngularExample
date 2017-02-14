<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Dettaglio</title>
</head>


<body>
    <div class="generic-container" ng-controller="ActorController as ctrl" data-ng-init="ctrl.details()">
        <div class="panel panel-default">

            <div class="formcontainer">
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.actor.actor_id" name="actor_id" />
                    <div class="container">
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Nome</label>
                                <div class="col-md-7">

                                    <input type="text" ng-model="ctrl.actor.first_name" name="nome" class="username form-control input-sm" placeholder="Inserisci il nome" required ng-minlength="3" />
                                    <div class="has-error" ng-show="myForm.$dirty">
                                        <span ng-show="myForm.first_name.$error.required">This
											is a required field</span> <span ng-show="myForm.first_name.$error.minlength">Minimum
											length required is 3</span> <span ng-show="myForm.first_name.$invalid">This field is
											invalid </span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Cognome</label>
                                <div class="col-md-7">
                                    <input type=text ng-model="ctrl.actor.last_name" name="cognome" class="email form-control input-sm" placeholder="Inserisci il congnome" required />
                                    <div class="has-error" ng-show="myForm.$dirty">
                                        <span ng-show="myForm.last_name.$error.required">
										Campo obbligatorio</span>
                                        <span ng-show="myForm.last_name.$invalid">
										Campo obbligatorio</span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-actions floatRight">

                                <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">
                                Reset Form</button>

                                <input type="submit" value="Modifica" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">

<%--                                 <button type="button" class="btn btn-primary btn-sm" 
                                ng-bootbox-class-name=" col-md-12"
                                ng-bootbox-confirm-action="confirmCallbackMethod(attr1, attr2)"
                                 ng-bootbox-alert="<embed src='webResources/newFilm.jsp' 
                                 />">
                                Assegna film</button> --%>
                                
                                <button class="btn btn-primary btn-sm"  type="button" 
                                ng-click="ctrl.bootbox()"> Assegna film</button>
                                
									
                            </div>
                        </div>
                    </div>

                </form>
            </div>


            <div ng-if="ctrl.actor.film !=[]">
                <div class="tablecontainer">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID.</th>
                                <th>Film</th>
                                <th>Genere</th>
                                <th width="20%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="u in ctrl.actor.film">
                                <td><span ng-bind="u.idFilm"></span></td>
                                <td><span ng-bind="u.filmName"></span></td>
                                <td><span ng-bind="u.genre"></span></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>

</html>