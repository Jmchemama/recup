<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
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
				<h1 class="text-center" >CREATION COMPTE</h1>
			</div>
		</div>
	<form:form method="post" modelAttribute="compte">
		<form:input type="hidden" path="noClient" value="${noClient}"/>
		<form:errors path="noClient" cssClass="erreur"/>
		<br/>
		Montant initial : <form:input path="solde"/>
		<form:errors path="solde" cssClass="erreur"/>
		<button class="btn btn-warning" type="submit">Créer</button>
	</form:form>
</body>
</html>

