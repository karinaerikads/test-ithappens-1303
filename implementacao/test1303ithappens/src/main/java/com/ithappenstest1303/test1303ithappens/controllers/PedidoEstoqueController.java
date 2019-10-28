package com.ithappenstest1303.test1303ithappens.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class PedidoEstoqueController {
	
	//Criar uma injeção de independência, ou seja, sempre que precisar usar a interface, então será criado uma nova instância
	@Autowired 	
	private ProdutoRepository pr;
	private ItensPedidoRepository ipr;
	private PedidoEstoqueRepository per;

	//Requisição para retornar o formulário
	@RequestMapping(value="/pedidoEstoque", method = RequestMethod.GET) //Get pois irá retornar o formulário
	public String form(){
		return "funcionalidades/pedidoEstoque";
	}
	
	//Requisição para retornar o formulário com lista de pedidos
	/*
	@RequestMapping(value="/listaDePedidos", method = RequestMethod.GET) //Get pois irá retornar o formulário
	public String formListaPedidos(){
		return "funcionalidades/listaPedidos";
	}*/
	
	//Retorna lista de pedidos
	
		@RequestMapping("/listaDePedidos")
		public ModelAndView listaPedidos(){
			//mostra a página que ele vai redenrizar os dados do pedido
			ModelAndView mv = new ModelAndView("listaPedidos");
			Iterable<PedidoEstoque> pedidoestoques = per.findAll(); //Trás do banco todos os pedidos cadastrados
			//Passa lista de pedidos para a view
			mv.addObject("pedidoestoques", pedidoestoques);
			
			return mv;
		}
	

	
	
	
	
	//Busca produto por sequencial
	@RequestMapping(value="/pedidoEstoque/{sequencial}", method=RequestMethod.GET)
	public ModelAndView buscarProduto(@PathVariable("sequencial") long sequencial) {
		Produto produto = pr.findBySequencial(sequencial);
		ModelAndView mv = new ModelAndView("funcionalidades/pedidoEstoque");
		mv.addObject("produto", produto);
		return mv;
	}
	
	
	/*
	@RequestMapping(value="/pedidoEstoque/{codigoproduto}/{codpedido}", method=RequestMethod.POST)
	public String detalhesEventoPost (@PathVariable("codigoprod") long codigoprod, @PathVariable("codpedido") long codpedido, @Valid ItensPedido itensPedido, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/pedidoEstoque";
		}
		
		PedidoEstoque pedidoEstoque = per.findByCodigo(codpedido);
		Produto produto = pr.findByCodigo(codigoprod);
		itensPedido.setPedidoestoque(pedidoEstoque);
		itensPedido.setProduto(produto);
		
		ipr.save(itensPedido);

		attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!");
		return "redirect:/{codigo}";

	}*/
	
	
	
	//Requisição para salvar os dados do pedido no banco de dados
		@RequestMapping(value="/pedidoEstoque", method = RequestMethod.POST) 
		public String form(@Valid ItensPedido itensPedido, PedidoEstoque pedidoEstoque, BindingResult result, RedirectAttributes attributes){
			if(result.hasErrors()){
				attributes.addFlashAttribute("mensagem", "Verifique os campos!");
				return "redirect:/pedidoEstoque";
			}
			//Persistindo no banco de dados
			
			ipr.save(itensPedido);
			//per.save(pedidoEstoque);
			attributes.addFlashAttribute("mensagem", "Pedido cadastrado com sucesso!");
			return "redirect:/cadastrarEvento";
		}
	
	//Busca produto por descricao
	/*
	@RequestMapping(value="/pedidoEstoque/{descricao}", method=RequestMethod.GET)
	public ModelAndView buscarProduto(@PathVariable("descricao") long descricao) {
		Produto produto = pr.findByDescricao(descricao);
		ModelAndView mv = new ModelAndView("funcionalidades/pedidoEstoque");
		mv.addObject("produto", produto);
		return mv;

	}*/
	
	//Busca produto por código de barras
	/*
	@RequestMapping(value="/pedidoEstoque/{cod_barras}", method=RequestMethod.GET)
	public ModelAndView buscarProduto(@PathVariable("descricao") String descricao) {
		Produto produto = pr.findByDescricao(descricao);
		ModelAndView mv = new ModelAndView("funcionalidades/pedidoEstoque");
		mv.addObject("produto", produto);
		return mv;

	}*/
	
		
}
