package com.ithappenstest1303.test1303ithappens.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ithappenstest1303.test1303ithappens.models.Usuario;
import com.ithappenstest1303.test1303ithappens.repository.UsuarioRepository;



@Controller
public class UsuarioController {
	
	@Autowired 	
	private UsuarioRepository ur;
	
	//Retorna lista de usuário
	
	@RequestMapping("/usuarios")
	public ModelAndView listaUsuarios(){
		ModelAndView mv = new ModelAndView("usuarios");
		Iterable<Usuario> usuarios = ur.findAll();
		mv.addObject("usuarios", usuarios);
		return mv;
	}
	
	//Requisição para salvar usuário no banco de dados
	@RequestMapping(value="/cadastrousuario", method = RequestMethod.POST) 
	public String form(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrousuario";
		}
		//Persistindo evento no banco de dados
		ur.save(usuario); //Salva evento no banco de dados
		attributes.addFlashAttribute("mensagem", "Usuario cadastrado com sucesso!");
		return "redirect:/cadastrousuario";
	}
	
	//Requisição para retornar o formulário
	@RequestMapping(value="/cadastrousuario", method = RequestMethod.GET) //Get pois irá retornar o formulário
	public String form(){
		return "cadastrousuario";
	}
	
		
		
		
	/*
	//Retorna lista de eventos
		@RequestMapping("/eventos")
		public ModelAndView listaEventos(){
			//mostra a página que ele vai redenrizar os dados do evento
			ModelAndView mv = new ModelAndView("listaEventos");
			Iterable<Evento> eventos = er.findAll(); //Trás do banco todos os eventos cadastrados
			//Passa lista de eventos para a view
			mv.addObject("eventos", eventos);
			
			return mv;
		}
		*/
}
