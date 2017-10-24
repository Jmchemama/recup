/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefisi.banquespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jmche
 */
@Controller
public class BonjourController {

	@RequestMapping(value = "/bonjour", method = RequestMethod.GET)
	public String doGet(ModelMap map, @RequestParam(value="numero", required = true) int numero) {
		// Ajout des données dans le modèle
		map.put("nom", "Numéro " + numero);
		// Passer la main à la JSP
		return "bonjour";
	}

}
