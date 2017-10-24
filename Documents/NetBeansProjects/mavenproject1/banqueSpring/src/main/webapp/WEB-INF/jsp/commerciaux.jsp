<%-- 
    Document   : commerciaux
    Created on : 24 oct. 2017, 10:44:00
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
				<h1 class="text-center" >LISTE DES COMMERCIAUX</h1>
			</div>
		</div>
		<br>
		<br>
		<h2>Liste des commerciaux :</h2>
		<table class="table table-striped" >
			<thead>
				<tr>	
					<th>Numéros du commercial</th>
					<th>nom</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${commerciaux}" var="commercial">
				<tr>
					<th>${commercial.getNoCommercial()} </th>
					<th>${commercial.getNom()}</th>
					<th><button  class="btn btn-primary" >Envoyer un mail</button></th>
				</tr>
			</c:forEach>
		</tbody>		
	</table>
</body>
</html>
