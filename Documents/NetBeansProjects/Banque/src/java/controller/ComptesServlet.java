package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static model.Compte.getCompte;

@WebServlet(name = "ComptesServlet", urlPatterns = {"/comptes"})
public class ComptesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		String nClient = request.getParameter("noClient");
		request.setAttribute("noClient", nClient);
		String msg;
		try {
			int noClient = Integer.parseInt(nClient);
			request.setAttribute("compte", getCompte(noClient));
			System.out.println(getCompte(noClient));
		} catch (SQLException | NumberFormatException ex) {
			request.setAttribute("msg", "erreur");
		}
		request.getRequestDispatcher("WEB-INF/comptes.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {

	}

}
