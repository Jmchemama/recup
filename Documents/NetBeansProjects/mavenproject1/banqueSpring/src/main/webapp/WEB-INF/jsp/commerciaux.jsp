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
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
		<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body class="container">
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h2 class="text-center" >Banque Bohlwinkel</h2>
			</div>
		</div>
		<br>
		<br>
		<div class="col-sm-2 col-sm-offset-5 col-xs-8 col-xs-offset-2">
			<span class="mdl-chip mdl-chip--contact">
				<span class="mdl-chip__contact mdl-color--blue-900 mdl-color-text--white"><i class="material-icons">group</i></span>
				<span class="mdl-chip__text">Liste des commerciaux</span>
			</span>
		</div>
		<br>
		<br>
		<div class="col-sm-4 col-sm-offset-4 col-xs-8 col-xs-offset-2">
			<table  class="mdl-data-table mdl-js-data-table  mdl-shadow--2dp" >
				<thead>
					<tr>	
						<th class="mdl-data-table__cell--non-numeric">N°</th>
						<th>Nom</th>
						<th>Mail</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${commerciaux}" var="commercial">
						<tr>
							<td class="mdl-data-table__cell--non-numeric">${commercial.getNoCommercial()} </td>
							<td>${commercial.getNom()}</td>
							<td><button  class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored" >Envoyer un mail</button></td>
						</tr>
					</c:forEach>
				</tbody>		
			</table>
		</div>
	</body>
</html>
