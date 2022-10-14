package br.com.fiap.StarIntersection.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.StarIntersection.Dto.ProdutoDto;
import br.com.fiap.StarIntersection.HttpHandler.HttpHandler;
import br.com.fiap.StarIntersection.model.Produto;

@Controller
public class ProdutoController {

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/produtos/criar")
	public ModelAndView criar(ProdutoDto produtoDto) {
		ModelAndView modelView = new ModelAndView("produtos/criar");
		return modelView;
	}

	@PostMapping("produtos")
	public ModelAndView salvar(@Valid ProdutoDto produto, BindingResult bindingResult) {
		try {
			if (bindingResult.hasErrors()) {
				return new ModelAndView("produtos/criar");
			}

			ObjectMapper mapper = new ObjectMapper();
			Produto produtoEntity = modelMapper.map(produto, Produto.class);
			produtoEntity.setActive(true);

			String jsonInString = mapper.writeValueAsString(produtoEntity);
			System.out.println(produtoEntity.toString());

			HttpHandler http = new HttpHandler();

			http.executePost("http://localhost:3000/products", jsonInString);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/produtos");
	}

	@GetMapping("/produtos")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("produtos/index");

		HttpHandler http = new HttpHandler();

		try {
			String json = http.sendHttpGETRequest("http://localhost:3000/products");

			ObjectMapper mapper = new ObjectMapper();

			List<Produto> ProdutoList = new ArrayList<>();

			ProdutoList = Arrays.asList(mapper.readValue(json, Produto[].class));

			for (Produto p : ProdutoList) {
				System.out.println(p.toString());
			}

			modelView.addObject("listarProdutos", ProdutoList);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return modelView;
	}

}
