package com.ithappenstest1303.test1303ithappens.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ithappenstest1303.test1303ithappens.models.Produto;
import com.ithappenstest1303.test1303ithappens.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository pr;
	
	//Retorna lista com todas os produtos
	@RequestMapping("/listaProdutos")
	public ModelAndView listaProdutosECadastroDeItens(){
		ModelAndView mv = new ModelAndView("cadastroItensPedido");
		Iterable<Produto> produtos = pr.findAll();
		mv.addObject("produtos", produtos);
		return mv;
	}
}
