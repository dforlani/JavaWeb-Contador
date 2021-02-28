package dforlani.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContadorController {

	@GetMapping("/hello")
	public String pessoas(HttpServletRequest req, Model model) {
		Integer contador = 0;

		HttpSession session = req.getSession(true);
		if (session != null) {

			if (!session.isNew()) {
				contador = (Integer) session.getAttribute("contador");
				if (contador == null) {
					contador = 0;
				}
			}
			contador = contador + 1;
			session.setAttribute("contador", contador);
		}

		
		model.addAttribute("contador", contador);

		return "contador/index";
	}
}