package com.ithappenstest1303.test1303ithappens.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ithappenstest1303.test1303ithappens.models.Produto;
import com.ithappenstest1303.test1303ithappens.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository pr;
	
	//Retorna lista com todas os produtos
	@RequestMapping("/listagemProdutos")
	public ModelAndView listaProdutosECadastroDeItens(){
		ModelAndView mv = new ModelAndView("listaProdutos");
		Iterable<Produto> produtos = pr.findAll();
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	//Retorna lista com todas os produtos
		@RequestMapping("/cadastroProduto")
		public ModelAndView cadastroProdutoForm(){
			ModelAndView mv = new ModelAndView("cadastroProduto");
			Iterable<Produto> produtos = pr.findAll();
			mv.addObject("produtos", produtos);
			return mv;
		}
	
	//Requisição para salvar produto no banco de dados
	@RequestMapping(value="/cadastroProduto", method = RequestMethod.POST) 
	public String form(@Valid Produto produto, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastroProduto";
		}
		//Persistindo evento no banco de dados
		pr.save(produto); //Salva evento no banco de dados
		attributes.addFlashAttribute("mensagem", "Produto cadastrado com sucesso!");
		return "redirect:/cadastroProduto";
	}
}
