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
import com.ithappenstest1303.test1303ithappens.models.Filial;
import com.ithappenstest1303.test1303ithappens.models.ItensPedido;
import com.ithappenstest1303.test1303ithappens.models.PedidoEstoque;
import com.ithappenstest1303.test1303ithappens.models.Produto;
import com.ithappenstest1303.test1303ithappens.models.Usuario;
import com.ithappenstest1303.test1303ithappens.repository.ClienteRepository;
import com.ithappenstest1303.test1303ithappens.repository.FilialRepository;
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
	@Autowired
	private FilialRepository fr;

	//Retorna lista com todas as pedidos
	@RequestMapping("/listaPedidos")
	public ModelAndView listaPedidossemcadastro(){
		ModelAndView mv = new ModelAndView("listaPedidos");
		Iterable<PedidoEstoque> pedidoestoques = per.findAll();
		mv.addObject("pedidoestoques", pedidoestoques);
		return mv;
	}
	
	//Retorna lista com todas as pedidos e formulário de cadastro das informações do pedido
	@RequestMapping("/cadastroPedido/{codigousuario}/{codigocliente}/{codigofilial}")
	public ModelAndView listaPedidos(){
		ModelAndView mv = new ModelAndView("cadastroPedido");
		Iterable<PedidoEstoque> pedidoestoques = per.findAll();
		mv.addObject("pedidoestoques", pedidoestoques);
		return mv;
	}
		
	//Mostra lista de clientes e embaixo terá o cadastro do pedido
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView escolheCliente (@PathVariable("codigo") long codigo){
		ModelAndView mv = new ModelAndView("listaClientes");
		Iterable<Cliente> clientes = cr.findAll();
		mv.addObject("clientes", clientes);
		return mv;
	}
	
	@RequestMapping(value="cadastroPedido/{codigousuario}/{codigocliente}/{codigofilial}", method=RequestMethod.POST)
	public String salvaPedidoEstoque(@PathVariable("codigousuario") long codigousuario, @PathVariable("codigocliente") long codigocliente, @PathVariable("codigofilial") long codigofilial, @Valid PedidoEstoque pedidoestoque, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastroPedido/{codigousuario}/{codigocliente}/{codigofilial}";
		}
			
		Usuario usuario = ur.findByCodigo(codigousuario);
		pedidoestoque.setUsuario(usuario);
			
		Cliente cliente = cr.findByCodigo(codigocliente);
		pedidoestoque.setCliente(cliente);
		
		Filial filial = fr.findByCodigo(codigofilial);
		pedidoestoque.setFilial(filial);
		
		per.save(pedidoestoque);
		attributes.addFlashAttribute("mensagem", "Pedido Estoque adicionado com sucesso!");
		return "redirect:/cadastroPedido/{codigousuario}/{codigocliente}/{codigofilial}";
			
			
		}

		
	//Busca produto por sequencial
	@RequestMapping(value="/pedidoEstoque/{sequencial}", method=RequestMethod.GET)
	public ModelAndView buscarProduto(@PathVariable("sequencial") long sequencial) {
		Produto produto = pr.findBySequencial(sequencial);
		ModelAndView mv = new ModelAndView("funcionalidades/pedidoEstoque");
		mv.addObject("produto", produto);
		return mv;
	}
			
}