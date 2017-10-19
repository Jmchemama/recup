<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<title>Créer un compte pour le client ${noClient}</title>
	</head>
	<body class="container">
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1 class="text-center" >Espace création de compte</h1>
			</div>
		</div>
		<form method="post">
			<input type="hidden" name="noClient" value="${noClient}"/>
			<fieldset>
				<legend>Créer un compte pour le client ${noClient}</legend>
			</fieldset>
			<label>
				montant initial
				<input type="text" name="valeur" />
			</label>
			<button class="btn btn-warning" type="submit">Créer le compte</button>
		</form>
		<br/>
		<c:if test="${msgErreur != null}">
			<span class="text-danger">${msgErreur}</span>
		</c:if>
		<c:if test="${msgSucces != null}">
			<span class="text-success">${msgSucces}</span>
		</c:if>
	</body>
</html>
