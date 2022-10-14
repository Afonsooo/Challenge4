package br.com.fiap.StarIntersection.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.StarIntersection.HttpHandler.HttpHandler;
import br.com.fiap.StarIntersection.model.Email;
import br.com.fiap.StarIntersection.model.Produto;

@Controller
public class EmailController {
	
	@GetMapping("/emails")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("emails/index");

		HttpHandler http = new HttpHandler();

		try {
			String json = http.sendHttpGETRequestEmail("http://localhost:8081/getEmails");

			ObjectMapper mapper = new ObjectMapper(); 

			List<Email> List = new ArrayList<>();

			List = Arrays.asList(mapper.readValue(json, Email[].class));

			for (Email p : List) {
				System.out.println(p.toString());
			}

			modelView.addObject("listarEmails",List);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return modelView;
	}
	
	
}
