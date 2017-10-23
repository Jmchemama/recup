package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Client;
import model.Commercial;
import static model.Compte.getCompte;

@WebServlet(name = "ComptesServlet", urlPatterns = {"/comptes"})
public class ComptesServlet extends HttpServlet {

	public boolean commercialEstAutorise(HttpServletRequest request) throws SQLException {
		boolean estAutorise = false;
		Object session = request.getSession().getAttribute("commercial");
		Commercial user = (Commercial) session;
		if (user != null) {
			String nClient = request.getParameter("noClient");
			int noClient = Integer.parseInt(nClient);
			ArrayList<Client> listClient = new ArrayList();
			listClient = user.getListClient();
			for (int i = 0; i < listClient.size(); i++) {
				if (listClient.get(i).getNoClient() == noClient) {
					estAutorise = true;
				}
			}
		}
		return estAutorise;
	}

	public boolean clientEstAutorise(HttpServletRequest request) {
		boolean estAutorise = false;
		Object session = request.getSession().getAttribute("client");
		Client user = (Client) session;
		if (user != null) {
			String nClient = request.getParameter("noClient");
			int noClient = Integer.parseInt(nClient);
			if (user.getNoClient() == noClient) {
				estAutorise = true;
			}
		}
		return estAutorise;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		try {
			if (clientEstAutorise(request) || commercialEstAutorise(request)) {
				String nClient = request.getParameter("noClient");
				request.setAttribute("noClient", nClient);
				int noClient = Integer.parseInt(nClient);
				request.setAttribute("compte", getCompte(noClient));
				System.out.println(getCompte(noClient));
				request.getRequestDispatcher("WEB-INF/comptes.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("WEB-INF/erreur.jsp").forward(request, response);
			}
		} catch (SQLException ex) {
			request.getRequestDispatcher("WEB-INF/erreur.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if ("deconnecter".equals(request.getParameter("action"))) {
			// Oublier le user
			session.removeAttribute("commercial");
			response.sendRedirect("connexion");
		}
	}

}
