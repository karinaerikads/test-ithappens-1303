package com.ithappenstest1303.test1303ithappens.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ithappenstest1303.test1303ithappens.models.Cliente;
import com.ithappenstest1303.test1303ithappens.models.ItensPedido;
import com.ithappenstest1303.test1303ithappens.models.PedidoEstoque;
import com.ithappenstest1303.test1303ithappens.models.Produto;
import com.ithappenstest1303.test1303ithappens.models.Usuario;
import com.ithappenstest1303.test1303ithappens.repository.ClienteRepository;
import com.ithappenstest1303.test1303ithappens.repository.ItensPedidoRepository;
import com.ithappenstest1303.test1303ithappens.repository.PedidoEstoqueRepository;
import com.ithappenstest1303.test1303ithappens.repository.ProdutoRepository;
import com.ithappenstest1303.test1303ithappens.repository.UsuarioRepository;

@Controller
public class PedidoEstoqueController {
	
	//Criar uma injeção de independência, ou seja, sempre que precisar usar a interface, então será criado uma nova instância
	@Autowired 	
	private ProdutoRepository pr;
	@Autowired 
	private ItensPedidoRepository ipr;
	@Autowired 
	private PedidoEstoqueRepository per;
	@Autowired 
	private UsuarioRepository ur;
	@Autowired
	private ClienteRepository cr;

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
	
	@RequestMapping("/listaPedidos")
	public ModelAndView listaPedidos(){
		//mostra a página que ele vai redenrizar os dados do pedido
		ModelAndView mv = new ModelAndView("listaPedidos");
		Iterable<PedidoEstoque> pedidoestoque = per.findAll(); //Trás do banco todos os pedidos cadastrados
		//Passa lista de pedidos para a view
		mv.addObject("pedidoestoque", pedidoestoque);
			
		return mv;
	}
	
	//Retorna formulário para preencher informações do pedido
	/*
	@RequestMapping(value="/cadastroPedido", method = RequestMethod.GET) 
	public String formCadastroPedido(){
		return "cadastroPedido";
	}*/
	
	//Requisição para salva informações do pedido no banco de dados
	/*@RequestMapping(value="/cadastroPedido", method = RequestMethod.POST) 
	public String cadastroPedido(@Valid PedidoEstoque pedidoestoque, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastroPedido";
		}
		
		per.save(pedidoestoque); 
		attributes.addFlashAttribute("mensagem", "Filial cadastrada com sucesso!");
		return "redirect:/cadastroFilial";
	}*/
	
	//Salva as informações de um cadastro pedido_estoque
	@GetMapping("/cadastroPedido/{codigo}")
	public String cadastroPedido(@PathVariable("codigo") Long codigo, @Valid PedidoEstoque pedidoestoque,  BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/usuarios";

			//return "redirect:/cadastroPedido/{codigo}";
		}
		Usuario usuario = ur.findByCodigo(codigo);
		pedidoestoque.setUsuario(usuario);
		per.save(pedidoestoque);
		attributes.addFlashAttribute("mensagem", "Pedido adicionado com sucesso!");
		return "redirect:/listaClientes";
		
	}
	
	
	//Mostra lista de clientes e embaixo terá o cadastro do pedido
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView escolheCliente (@PathVariable("codigo") long codigo){
		ModelAndView mv = new ModelAndView("listaClientes");
		Iterable<Cliente> clientes = cr.findAll();
		mv.addObject("clientes", clientes);
		return mv;
		

	}
	

	
	//vai salvar o cadastro do pedido
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public String salvaPedidoEstoque(@PathVariable("codigo") long codigo, @Valid PedidoEstoque pedidoestoque,  BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{codigo}";
		}
		Usuario usuario = ur.findByCodigo(codigo);
		pedidoestoque.setUsuario(usuario);
		per.save(pedidoestoque);
		
		attributes.addFlashAttribute("mensagem", "Pedido Estoque adicionado com sucesso!");
		return "redirect:/{codigo}";
	}
	
	
	//Busca produto por sequencial
	@RequestMapping(value="/pedidoEstoque/{sequencial}", method=RequestMethod.GET)
	public ModelAndView buscarProduto(@PathVariable("sequencial") long sequencial) {
		Produto produto = pr.findBySequencial(sequencial);
		ModelAndView mv = new ModelAndView("funcionalidades/pedidoEstoque");
		mv.addObject("produto", produto);
		return mv;
	}
	
	
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
	
		
}
