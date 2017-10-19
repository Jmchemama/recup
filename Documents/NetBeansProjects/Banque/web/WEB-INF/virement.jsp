<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	</head>
	<body class="container">
		<input type="hidden" name="noClient" value="${noClient}"/>
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1 class="text-center" >Espace virement bancaire</h1>
			</div>
		</div>
		<form method="post">

			<fieldset>
				<legend>client n° ${noClient}</legend>
			</fieldset>
			<h1>Faire un virement :</h1>
			<br>
			<br>
			<form>
				<div class="form-group">
					<label>N° du compte débiteur :</label>
					<select class="form-control" id="compteDebiteur" name="compteDebiteur">
						<c:forEach items="${listCompte}" var="compte">
							<option value="${compte.getNoCompte()}">Compte n°${compte.getNoCompte()} || Solde de ${compte.getSolde()}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label>N° du compte créditeur :</label>
					<input type="text" id="compteCréditeur" class="form-control" name="compteCrediteur" aria-describedby="compteHelp" placeholder="Entrer le compte à créditer"/>
					<small id="compteHelp" class="form-text text-muted">Vous devez rentrer un n° de compte</small>
				</div>
				<div class="form-group">
					<label>Montant a transferer</label>
					<input type="text" id="montant" class="form-control" name="montant" aria-describedby="montantHelp" placeholder="Entrer la somme du virement"/>
					<small id="montantHelp" class="form-text text-muted">Vous devez rentrer une somme <= 20€</small>
				</div>
				<button class="btn btn-warning" type="submit">Valider le virement</button>
			</form>
			<br/>
			<c:if test="${msgErreur != null}">
				<div class="alert alert-danger" role="alert">
					${msgErreur}
				</div>
			</c:if>
			<c:if test="${msgSucces != null}">
				<div class="alert alert-success" role="alert">
					${msgSucces}
				</div>
			</c:if>
	</body>
</html>
