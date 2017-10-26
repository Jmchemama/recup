package com.cefisi.banquespring.exceptions;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Recupere toutes les exceptions indiquées ici, quel que soit le controleur qui l'a provoqué.
 * @author plasse
 */
@ControllerAdvice  // Précise que les handlers sont valable pour tout controleur
public class GlobalExceptionHandler {

	@ExceptionHandler(SQLException.class)
	public ModelAndView handleError(SQLException exc) {
//    logger.error("Request: " + req.getRequestURL() + " raised " + ex);
		ModelAndView mav = new ModelAndView("erreur");
		mav.addObject("date",
				  new SimpleDateFormat("d/M/Y k:m:s").format(new Date()));
		mav.addObject("exception", exc);
		return mav;
	}

}
