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

import com.ithappenstest1303.test1303ithappens.models.Filial;
import com.ithappenstest1303.test1303ithappens.models.Usuario;
import com.ithappenstest1303.test1303ithappens.repository.UsuarioRepository;



@Controller
public class UsuarioController {
	
	@Autowired 	
	private UsuarioRepository ur;
	
	//Retorna lista de usuário
	@RequestMapping("/listaUsuarios")
	public ModelAndView listaUsuarios(){
		ModelAndView mv = new ModelAndView("listaUsuarios");
		Iterable<Usuario> usuarios = ur.findAll();
		mv.addObject("usuarios", usuarios);
		return mv;
	}
	
	//Requisição para salvar usuário no banco de dados
	@RequestMapping(value="/cadastroUsuario", method = RequestMethod.POST) 
	public String form(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastroUsuario";
		}
		//Persistindo evento no banco de dados
		ur.save(usuario); //Salva evento no banco de dados
		attributes.addFlashAttribute("mensagem", "Usuario cadastrado com sucesso!");
		return "redirect:/cadastroUsuario";
	}
	
	//Requisição para retornar o formulário
	@RequestMapping(value="/cadastroUsuario", method = RequestMethod.GET) //Get pois irá retornar o formulário
	public String form(){
		return "cadastroUsuario";
	}
	
		
		
	//Deleta usuario específico
	@GetMapping("/deletausuario/{codigo}")
	public ModelAndView delete(@PathVariable("codigo") Long codigo) {
		Usuario usuario = ur.findByCodigo(codigo);
		ur.delete(usuario);
		ModelAndView modelAndView = new ModelAndView("redirect:/usuarios");
		return modelAndView;
	}
}
