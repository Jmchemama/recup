<%-- 
    Document   : commercial
    Created on : 24 oct. 2017, 10:41:40
    Author     : jmche
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body class="container">
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1 class="text-center" >ESPACE COMMERCIAL</h1>
			</div>
		</div>
		<br>
		<br>
		<h2>Liste de vos Clients :</h2>
		<table class="table table-striped" >
			<thead>
				<tr>	
					<th>Numéros du Client</th>
					<th>nom</th>
					<th>email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clients}" var="client">
					<tr>
						<th>${client.noClient} </th>
						<th>${client.nom}</th>
						<th>${client.email}</th>
						<th><a href="/banqueSpring/client-${client.noClient}/comptes"><button class="btn btn-primary" >Compte</button></a></th>
						<th><a href="creerCompte?noClient=${client.noClient}"><button class="btn btn-warning" >Créer un compte</button></a></th>
					</tr>
				</c:forEach>
			</tbody>		
		</table>
	</body>
</html>
