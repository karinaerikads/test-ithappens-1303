package com.ithappenstest1303.test1303ithappens.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ithappenstest1303.test1303ithappens.models.Cliente;
import com.ithappenstest1303.test1303ithappens.models.Usuario;
import com.ithappenstest1303.test1303ithappens.repository.ClienteRepository;

@Controller
public class ClienteController {
	@Autowired 
	private ClienteRepository cr;
	
	//Requisição para salvar dados do cliente no banco
	@RequestMapping(value="/cadastroCliente", method = RequestMethod.POST) 
	public String form(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastroCliente";
		}
		//Persistindo evento no banco de dados
		cr.save(cliente); //Salva evento no banco de dados
		attributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso!");
		return "redirect:/cadastroCliente";
	}
	
	//Requisição para retornar formulário de cadastro do cliente
	@RequestMapping(value="/cadastroCliente", method = RequestMethod.GET) //Get pois irá retornar o formulário
	public String form(){
		return "cadastroCliente";
	}
	
	//Requisição para mostrar toda lista de clientes
	@RequestMapping("/listaClientes")
	public ModelAndView listaClientes(){
		ModelAndView mv = new ModelAndView("listaClientes");
		Iterable<Cliente> clientes = cr.findAll();
		mv.addObject("clientes", clientes);
		return mv;
	}
}
