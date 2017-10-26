<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
		<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
		<title>Connexion</title>
	</head>
	<body class="container">
		<div class="jumbotron jumbotron-white">
			<div class="container">
				<h2 class="text-center" >Banque Bohlwinkel</h2>
			</div>
		</div>
		<c:if test="${messageErreur != null}">
			<div class="alert alert-info col-sm-4 col-sm-offset-4 col-xs-8 col-xs-offset-2">
				<p class="text-center"><strong>Info!</strong> ${messageErreur}</p>
			</div>
		</c:if>
		<div class="col-sm-4 col-sm-offset-4 col-xs-8 col-xs-offset-2">
			<div class="demo-card-wide mdl-card mdl-shadow--2dp">
				<div class="mdl-card__title">
					<h2 class="mdl-card__title-text ">Connexion</h2>
				</div>
				<span><form:errors path="mdp" cssClass="erreur"/></span>
				<div class="mdl-card__supporting-text">
					<form:form id="connexion" method="post" modelAttribute="user">
						<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
							<form:input  class="mdl-textfield__input" type="text" path="email" />
							<form:errors path="email" cssClass="erreur"/>
							<label class="mdl-textfield__label" for="email">Email</label>
						</div>
						<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
							<form:input  type="password" class="mdl-textfield__input" path="mdp"/>
							<label class="mdl-textfield__label" for="mdp">Mot de passe</label>
							<form:errors path="mdp" cssClass="erreur"/>					
						</div>
						<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-1">
							<form:radiobutton id="option-1" class="mdl-radio__button" path="role" value="Client" checked="true"/> 
							<span class="mdl-radio__label">Client</span>
						</label>
						<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-2">
							<form:radiobutton id="option-2" class="mdl-radio__button" path="role" value="Commercial" />
							<span class="mdl-radio__label">Commercial</span>
						</label>
					</form:form>
				</div>
				<div class="mdl-card__actions mdl-card--border">
					<button form="connexion" type="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored">
						Connexion
					</button>
				</div>
				<div class="mdl-card__menu">
					<button id="demo-show-toast" class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect" type="button"><i class="material-icons">help</i></button>
					<div id="demo-toast-example" class="mdl-js-snackbar mdl-snackbar">
						<div class="mdl-snackbar__text"></div>
						<button class="mdl-snackbar__action" type="button"></button>
					</div>
					<script>
						(function () {
							'use strict';
							var snackbarContainer = document.querySelector('#demo-toast-example');
							var showToastButton = document.querySelector('#demo-show-toast');
							showToastButton.addEventListener('click', function () {
								'use strict';
								var data = {timeout: 2000, message: 'Vos identifiant et Mot de passe '};
								snackbarContainer.MaterialSnackbar.showSnackbar(data);
							});
						}());
					</script>
				</div>
			</div>
		</div>
	</body>
</html>

