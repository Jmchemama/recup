/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Compte;

/**
 *
 * @author jmche
 */
@WebServlet(name = "VirementServlet", urlPatterns = {"/Virement"})
public class VirementServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		String noClient = request.getParameter("noClient");
		if(noClient == null){
			request.setAttribute("msgErreur", "Aucun client de selectionner");
		}
		try {
			int nClient = Integer.parseInt(noClient);
			ArrayList<Compte> listCompte = Compte.getCompte(nClient);
			request.setAttribute("listCompte", listCompte);
		} catch (SQLException ex) {

		} catch (NumberFormatException exc) {

		}
		request.getRequestDispatcher("WEB-INF/virement.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		boolean estOk = false;
		String noClient = request.getParameter("noClient");
		String noCompteDebiteur = request.getParameter("compteDebiteur");
		String noCompteCrediteur = request.getParameter("compteCrediteur");
		String montant = request.getParameter("montant");
		String msg;
		try {
			int compteDebiteur = Integer.parseInt(noCompteDebiteur);
			int compteCrediteur = Integer.parseInt(noCompteCrediteur);
			double montantVirement = Double.parseDouble(montant);
			Compte compte = Compte.getById(compteDebiteur);
			compte.virerSur(compteCrediteur, montantVirement);
			request.setAttribute("msgSucces", "Votre compte "+noCompteDebiteur+" à bien réaliser un virement sur le compte n° "+noCompteCrediteur+" d'un montant de "+montant);
			estOk = true;
		} catch (NumberFormatException ex) {
			request.setAttribute("msgErreur", "Entrer un nombre (ex : 5.2)");
		} catch (SQLException exc) {
			request.setAttribute("msgErreur", "erreur");
		}
		if(estOk){
				response.sendRedirect("comptes?noClient="+noClient);
			}
		else{
			request.getRequestDispatcher("WEB-INF/virement.jsp").forward(request, response);
		}
	}

}
