package br.com.fiap.StarIntersection.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.StarIntersection.HttpHandler.HttpHandler;
import br.com.fiap.StarIntersection.model.Produto;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(HttpServletRequest request) {
		request.setAttribute("nomeUsuario", "Gabriel Afonso");
		
		return "home";
	}

	@GetMapping("/sobre")
	public String sobre(HttpServletRequest request) {

		return "/sobre/index";
	}

}
