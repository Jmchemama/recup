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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Commercial;

/**
 *
 * @author jmche
 */
@WebServlet(name = "ConnexionCommercialServlet", urlPatterns = {"/ConnexionCommercialServlet"})
public class ConnexionCommercialServlet extends HttpServlet {
	
	private static final String VUE_FORM = "WEB-INF/connexion.jsp";
	private static final String VUE_OK = "commercial";
	boolean estOk = false;
	int noCommercial = 0;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		request.getRequestDispatcher(VUE_FORM).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		String vue = VUE_FORM; // soyons pessimistes :-)
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
				if (login == null || login.trim().equals("")) {
					isValid = false;
					request.setAttribute("loginMsg", "Email obligatoire");
				}
				if (pwd == null || pwd.trim().equals("")) {
					isValid = false;
					request.setAttribute("pwdMsg", "Mot de passe obligatoire");
				}
				if (isValid) {
					Commercial user = Commercial.getByEmailMpd(login, pwd);
					if (user != null) {
						//Ajouter le user à la session
						session.setAttribute("user", user);
						vue = VUE_OK;
						estOk=true;
						noCommercial=user.getNoCommercial();
					} else {
						request.setAttribute("connexionMsg", "Email ou Mot de passe incorrect");
					}
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnexionCommercialServlet.class.getName()).log(Level.SEVERE, null, ex);
			request.setAttribute("connexionMsg", ex.getMessage());
		}
		if(estOk){
			response.sendRedirect(vue+"?noCommercial="+noCommercial);
		}
		else{
			request.getRequestDispatcher(vue).forward(request, response);
		}
		
	}
}

