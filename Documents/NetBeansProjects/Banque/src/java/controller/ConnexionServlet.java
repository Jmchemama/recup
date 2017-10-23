/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Client;
import model.Commercial;

/**
 *
 * @author jmche
 */
@WebServlet(name = "ConnexionServlet", urlPatterns = {"/connexion"})
public class ConnexionServlet extends HttpServlet {

	private static final String VUE_FORM = "WEB-INF/connexion.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		request.getRequestDispatcher(VUE_FORM).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		boolean estOk = false;
		int idUser = 0;
		String vue = VUE_FORM; // soyons pessimistes :-)
		String userRole = null;
		try {
			// Recuperer la session http
			HttpSession session = request.getSession(true);
			if ("deconnecter".equals(request.getParameter("action"))) {
				// Oublier le user
				session.removeAttribute("user");
				vue = VUE_FORM;
			} else {
				boolean isValid = true;
				String login = request.getParameter("login");
				String pwd = request.getParameter("pwd");
				userRole = request.getParameter("role");

				if (login == null || login.trim().equals("")) {
					isValid = false;
					request.setAttribute("loginMsg", "Email obligatoire");
				}
				if (pwd == null || pwd.trim().equals("")) {
					isValid = false;
					request.setAttribute("pwdMsg", "Mot de passe obligatoire");
				}
				if (isValid) {
					if ("commercial".equals(userRole)) {
						Commercial commercial = Commercial.getByEmailMpd(login, pwd);
						if (commercial != null) {
							session.setAttribute("commercial", commercial);
							vue = "commercial";
							estOk = true;
							idUser = commercial.getNoCommercial();
						}
					}
					if ("client".equals(userRole)) {
						Client client = Client.getByEmailMpd(login, pwd);
						if (client != null) {
							session.setAttribute("client", client);
							vue = "comptes";
							estOk = true;
							idUser = client.getNoClient();
						}
					}
					if (!estOk) {
						request.setAttribute("connexionMsg", "Email ou Mot de passe incorrect");
					}
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnexionServlet.class.getName()).log(Level.SEVERE, null, ex);
			request.setAttribute("connexionMsg", ex.getMessage());
		}

		if (estOk) {
			if ("commercial".equals(userRole)) {
				ajouterNbComerciaux(1);
				response.sendRedirect(vue + "?noCommercial=" + idUser);
			} else {
				ajouterNbClients(1);
				response.sendRedirect(vue + "?noClient=" + idUser);
			}

		} else {
			request.getRequestDispatcher(vue).forward(request, response);
		}

	}
	
	private void ajouterNbClients(int increment) {
		ServletContext context = getServletContext();
		int nbIdentifies = (int) context.getAttribute("nbClients");
		nbIdentifies += increment;
		context.setAttribute("nbClients", nbIdentifies);
		System.out.println("nbClients : " + context.getAttribute("nbClients"));
	}
	
	private void ajouterNbComerciaux(int increment) {
		ServletContext context = getServletContext();
		int nbIdentifies = (int) context.getAttribute("nbCommerciaux");
		nbIdentifies += increment;
		context.setAttribute("nbCommerciaux", nbIdentifies);
		System.out.println("nbCommerciaux : " + context.getAttribute("nbCommerciaux"));
	}
}
