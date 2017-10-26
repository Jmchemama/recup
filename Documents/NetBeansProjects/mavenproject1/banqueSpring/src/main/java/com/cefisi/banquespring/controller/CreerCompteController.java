/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefisi.banquespring.controller;

import java.sql.SQLException;
import javax.validation.Valid;
import model.Commercial;
import model.Compte;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jmche
 */
@Controller
public class CreerCompteController {

	@RequestMapping(value = "/client-{noClient}/creation/compte", method = RequestMethod.GET)
	public String getCreationCompte(ModelMap map, @PathVariable(value = "noClient") int noClient) throws SQLException {
		map.put("compte", new Compte());
		return "creerCompte";
	}

	@RequestMapping(value = "/client-{noClient}/creation/compte", method = RequestMethod.POST)
	public String postCreationCompte(
			  @Valid
			  @ModelAttribute("compte") Compte compte,
			  BindingResult result, ModelMap map, @PathVariable(value = "noClient") int noClient
	) throws SQLException {
		if (!result.hasErrors()) {
			compte.inserer2();
			return "redirect:/client-" + noClient + "/comptes";
		}
		return "creerCompte";
	}

}
