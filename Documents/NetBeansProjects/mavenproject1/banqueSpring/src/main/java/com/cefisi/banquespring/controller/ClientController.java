/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefisi.banquespring.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import model.Client;
import model.Commercial;
import static model.Compte.getCompte;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jmche
 */
@Controller
public class ClientController {

	@RequestMapping(value = " /client-{noClient}/comptes", method = RequestMethod.GET)
	public String getCompteDuClient(HttpSession session, ModelMap map, @PathVariable(value = "noClient") int noClient) throws SQLException {
		String page = "redirect:/erreur/"; // pessimiste
		if (clientEstAutorise(session, noClient) || commercialEstAutorise(session, noClient)) {
			map.put("noClient", noClient);
			map.put("comptes", getCompte(noClient));
			page = "comptes";
		}
		return page;
	}

	public boolean clientEstAutorise(HttpSession session, int noClient) throws SQLException {
		boolean estAutorise = false;
		Object user = session.getAttribute("client");
		Client client = (Client) user;
		if (client != null) {
			if (client.getNoClient() == noClient) {
				estAutorise = true;
			}
		}
		return estAutorise;
	}

	public boolean commercialEstAutorise(HttpSession session, int noClient) throws SQLException {
		boolean estAutorise = false;
		Object user = session.getAttribute("commercial");
		Commercial commercial = (Commercial) user;
		if (commercial != null) {
			ArrayList<Client> listClient = new ArrayList();
			listClient = commercial.getListClient();
			for (int i = 0; i < listClient.size(); i++) {
				if (listClient.get(i).getNoClient() == noClient) {
					estAutorise = true;
				}
			}
		}
		return estAutorise;
	}
}
