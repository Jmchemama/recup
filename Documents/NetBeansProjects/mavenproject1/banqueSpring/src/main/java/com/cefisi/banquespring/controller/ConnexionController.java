/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefisi.banquespring.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.FormParam;
import model.Client;
import model.Commercial;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jmche
 */
@Controller
public class ConnexionController {

	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
	public String getConnexion(ModelMap map, @FormParam("role") String role) throws SQLException {
		map.put("user", new User());
		return "connexion";
	}

	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
	public String postConnexion(HttpSession session,
			  @Valid
			  @ModelAttribute("user") User user,
			  BindingResult result, ModelMap map) throws SQLException {
		boolean estOk = false;
		String redirect = null;
		String messageErreur = null;
		if (!result.hasErrors()) {
			if ("Client".equals(user.getRole())) {
				Client client = Client.getByEmailMpd(user.getEmail(), user.getMdp());
				if (client != null) {
					client.setRole("Client");
					estOk = true;
					redirect = "redirect:client-" + client.getNoClient() + "/comptes";
					session.setAttribute("client", client);
				}
			}
			if ("Commercial".equals(user.getRole())) {
				Commercial commercial = Commercial.getByEmailMpd(user.getEmail(), user.getMdp());
				if (commercial != null) {
					commercial.setRole("Commercial");
					estOk = true;
					redirect = "redirect:commercial-" + commercial.getNoCommercial();
					session.setAttribute("commercial", commercial);
				}
			}
		}
		if (estOk) {
			return redirect;
		} else {
			messageErreur ="Veuillez rentrer un email et mot de passe correct";
			map.put("messageErreur",messageErreur);
			return "connexion";
		}
	}

	/*@ModelAttribute("role")
	public Map<Integer, String> role() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Client");
		map.put(2, "Commercial");
		return map;
	}*/
}
