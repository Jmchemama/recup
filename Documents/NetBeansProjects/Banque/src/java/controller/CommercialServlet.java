package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Client;
import model.Commercial;

@WebServlet(name = "CommerciauxServlet", urlPatterns = {"/commercial"})
public class CommercialServlet extends HttpServlet {

	public boolean userEstAutorise(HttpServletRequest request) {
		boolean estAutorise = false;
		Object session = request.getSession().getAttribute("commercial");
		Commercial user = (Commercial) session;
		String nCommercial = request.getParameter("noCommercial");
		int noCommercial = Integer.parseInt(nCommercial);
		if (user.getNoCommercial() == noCommercial) {
			estAutorise = true;
		}
		return estAutorise;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		if (userEstAutorise(request)) {
			String nCommercial = request.getParameter("noCommercial");
			Commercial user = (Commercial) request.getSession().getAttribute("commercial");
			ArrayList<Client> listClient = new ArrayList();
			try {
				int noCommercial = Integer.parseInt(nCommercial);
				Commercial commercial = Commercial.getCommercial(noCommercial);
				request.setAttribute("listCommerciaux", commercial.getListCommercial());
				request.setAttribute("listClient", commercial.getListClient());
				request.getRequestDispatcher("WEB-INF/commercial.jsp").forward(request, response);
			} catch (SQLException ex) {
				request.getRequestDispatcher("WEB-INF/erreur.jsp").forward(request, response);
			} catch (NumberFormatException ex) {

			}
		} else {
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
