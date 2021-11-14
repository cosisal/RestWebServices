package it.prova.mvc.springMvcProva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping(value = "/hello")
	public ModelAndView hello(@RequestParam(required = false, defaultValue = "World") String name) {
		ModelAndView ret = new ModelAndView("home");
		if (name.equals("World")) {
			ret = new ModelAndView("test");
		}
		// Adds an objet to be used in home.jsp
		ret.addObject("name", name);
		return ret;
	}
}
