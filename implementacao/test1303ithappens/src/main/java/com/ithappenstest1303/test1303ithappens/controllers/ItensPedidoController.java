package com.ithappenstest1303.test1303ithappens.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.ithappenstest1303.test1303ithappens.models.ItensPedido;
import com.ithappenstest1303.test1303ithappens.models.PedidoEstoque;
import com.ithappenstest1303.test1303ithappens.models.Produto;
import com.ithappenstest1303.test1303ithappens.repository.ItensPedidoRepository;
import com.ithappenstest1303.test1303ithappens.repository.PedidoEstoqueRepository;
import com.ithappenstest1303.test1303ithappens.repository.ProdutoRepository;

@Controller
public class ItensPedidoController {
	@Autowired 
	private ItensPedidoRepository ipr;
	@Autowired
	private PedidoEstoqueRepository per;
	@Autowired
	private ProdutoRepository pr;
	
	
	
	//Retorna lista com todas os produtos e formulário de cadastro dos itens do pedido
	@RequestMapping("/cadastroitenspedido/{codigopedido}/{codigoproduto}")
	public ModelAndView listaProdutosECadastroDeItens(){
		ModelAndView mv = new ModelAndView("cadastroItensPedido");
		Iterable<Produto> produtos = pr.findAll();
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@RequestMapping(value="/cadastroitenspedido/{codigopedido}/{codigoproduto}", method=RequestMethod.POST)
	public String salvaItensPedido(@PathVariable("codigopedido") long codigopedido, @PathVariable("codigoproduto") long codigoproduto, @Valid ItensPedido itenspedido , BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastroitenspedido/{codigopedido}/{codigoproduto}";
		}
		
		PedidoEstoque pedidoestoque = per.findByCodigo(codigopedido);
		itenspedido.setPedidoestoque(pedidoestoque);
		
		Produto produto = pr.findByCodigo(codigoproduto);
		itenspedido.setProduto(produto);
			
		
		ipr.save(itenspedido);
		attributes.addFlashAttribute("mensagem", "Itens do pedido adicionado com sucesso!");
		return "redirect:/cadastroitenspedido/{codigopedido}/{codigoproduto}";
			
			
		}
}
