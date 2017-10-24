<%-- 
    Document   : comptes
    Created on : 24 oct. 2017, 10:14:19
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
	<body>
		<h1>Hello World!</h1>
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
				<c:forEach items="${comptes}" var="compte">
					<tr>
						<th>${compte.noCompte}</th>
						<th>${compte.solde}</th>
					</tr>
				</c:forEach>
			</tbody>		
		</table>
	</body>
</html>
