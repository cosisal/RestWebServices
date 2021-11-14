package it.prova.mvc.springMvcProva.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InviteController {

	public InviteController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/invitation")
	public ModelAndView getInvitation(@RequestParam(required = false) String name) {
		
		ModelAndView ret = new ModelAndView("invitation");		
		
		if (StringUtils.isBlank(name)) {
			ret.addObject("invito", "Sei uno sconosciuto non sei invitato");	
		}else {
			
			if (name.equalsIgnoreCase("salvo")) {
				ret.addObject("invito", StringUtils.capitalize(name)+" non sei il benvenuto");
			}else {
				ret.addObject("invito", "Benvenuto, ecco il tuo invito, "+StringUtils.capitalize(name));
			}
			
		}
		
//		ret.addObject("invito", "Invito a pranzo");
		
		return ret;
	}

}
