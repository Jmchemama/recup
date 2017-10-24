/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefisi.banquespring.controller;

import java.sql.SQLException;
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

	@RequestMapping(value = " /client-{noClient}/comptes",method = RequestMethod.GET)
	public String getCompteDuClient(ModelMap map,@PathVariable(value = "noClient") int noClient) throws SQLException {
		map.put("noClient", noClient);
		map.put("comptes", getCompte(noClient));
		return "comptes";
	}
}
