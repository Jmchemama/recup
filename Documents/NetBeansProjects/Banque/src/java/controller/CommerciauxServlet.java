package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Client;
import model.Commercial;

@WebServlet(name = "CommerciauxServlet", urlPatterns = {"/commercial"})
public class CommerciauxServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		String nCommercial = request.getParameter("noCommercial");
		ArrayList<Client> listClient = new ArrayList();
		try {
			int noCommercial = Integer.parseInt(nCommercial);
			Commercial commercial = Commercial.getCommercial(noCommercial);
			request.setAttribute("listCommerciaux", commercial.getListCommercial());
			request.setAttribute("listClient", commercial.getListClient());
		} catch (SQLException ex) {

		} catch (NumberFormatException ex) {

		}
		request.getRequestDispatcher("WEB-INF/commercial.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
	}

}
