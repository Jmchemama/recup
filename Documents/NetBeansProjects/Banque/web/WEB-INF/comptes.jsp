<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<title>Liste des comptes du client ${noClient}</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body class="container">
		<input type="hidden" name="noClient" value="${noClient}"/>
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1 class="text-center" >Espace liste des comptes</h1>
			</div>
		</div>
		<h2 class="text-center">Comptes du client ${noClient}</h2>
		<br>
		<br>
		<table class="table table-striped" >
			<thead>
				<tr>	
					<th>Numéros du compte</th>
					<th>Solde du compte</th>
				</tr>
			</thead>
				<tbody>
					<c:forEach items="${compte}" var="compte">
					<tr>
						<th>${compte.noCompte} </th>
						<th>${compte.solde}</th>
					</tr>
					</c:forEach>
				</tbody>		
		</table>
		<br>
		<br>
		<a href="creerCompte?noClient=${noClient}"><button class="btn btn-warning" >Créer un compte</button></a>
		<a href="Virement?noClient=${noClient}"><button class="btn btn-warning" >Virement</button></a>
		<c:if test="${msg!= null}">
			<span class="text-danger">${msg}</span>
		</c:if>
	</body>
</html>
