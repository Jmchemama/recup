<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Connexion commercial</title>
	</head>
	<body class="container">
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1 class="text-center" >Connexion à votre espace commercial</h1>
			</div>
		</div>
		<br>
		<form method="POST">
			<div class="col-sm-8 col-sm-offset-2">
				<c:if test="${sessionScope['user'] == null}">
					<div class="form-group row">
						<label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-10">
							<input type="text" class="form-control-plaintext"  id="inputLogin" name="login" value="${param['login']}"> ${loginMsg}
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword" class="col-sm-2 col-form-label">Mot de passe</label>
						<div class="col-sm-10">
							<input type="password" class="form-control-plaintext" id="inputPassword"  type="password" name="pwd"> ${pwdMsg}
						</div>
					</div>
					<button class="btn btn-warning" name="action" type="submit">
						CONNEXION ${sessionScope["user"].getLogin()}
					</button>
					${connexionMsg}
				</c:if>
				<c:if test="${sessionScope['user'] != null}">
					<button class="btn btn-warning" name="action" value="deconnecter">
						DECONNEXION ${sessionScope["user"].getLogin()}
					</button>
				</c:if>
			</div>
		</form>
	</body>
</html>
