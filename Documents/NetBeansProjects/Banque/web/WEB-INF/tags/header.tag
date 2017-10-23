<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="En-tête des pages"%>

<!DOCTYPE html>
<nav class="navbar navbar-inverse" id="menu">
	<c:if test="${sessionScope['client'] != null}">
		<a class="navbar-brand" href="comptes?noClient=${sessionScope["client"].noClient}">COMPTES</a> 
		<a class="navbar-brand" href="virement">VIREMENT</a> 
	</c:if>
	<c:if test="${sessionScope['commercial'] != null}">
		<a class="navbar-brand" href="commercial">ACCUEIL</a> 
	</c:if>
		<ul class="nav navbar-nav navbar-right">
			<li><a>${applicationScope["nbClients"]} Clients - ${applicationScope["nbCommerciaux"]} Commerciaux</a></li>
			<li><form action="connexion" method="POST"><button class=" btn navbar-btn " name="action" value="deconnecter">DECONNEXION</button></form></li>
		</ul>
</nav>