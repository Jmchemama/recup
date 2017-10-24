/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefisi.banquespring.controller;

import java.sql.SQLException;
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
public class CommercialController {
	@RequestMapping(value = " /commercial-{noCommercial}",method = RequestMethod.GET)
	public String getCommercial(ModelMap map,@PathVariable(value = "noCommercial") int noCommercial) throws SQLException {
		map.put("noCommercial", noCommercial);
		Commercial commercial = Commercial.getCommercial(noCommercial);
		map.put("clients",commercial.getListClient());
		return "commercial";
	}
}
