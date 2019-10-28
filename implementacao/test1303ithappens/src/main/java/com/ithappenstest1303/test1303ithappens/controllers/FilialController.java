package com.ithappenstest1303.test1303ithappens.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ithappenstest1303.test1303ithappens.models.Filial;
import com.ithappenstest1303.test1303ithappens.models.Usuario;
import com.ithappenstest1303.test1303ithappens.repository.FilialRepository;
import com.ithappenstest1303.test1303ithappens.repository.UsuarioRepository;

@Controller
public class FilialController {
	
	@Autowired 	
	private FilialRepository fr;
	
	//Requisição para salvar filial no banco
	@RequestMapping(value="/cadastroFilial", method = RequestMethod.POST) 
	public String form(@Valid Filial filial, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastroFilial";
		}
		//Persistindo evento no banco de dados
		fr.save(filial); //Salva evento no banco de dados
		attributes.addFlashAttribute("mensagem", "Filial cadastrada com sucesso!");
		return "redirect:/cadastroFilial";
	}
	
	//Requisição para retornar o formulário
	@RequestMapping(value="/cadastroFilial", method = RequestMethod.GET) //Get pois irá retornar o formulário
	public String form(){
		return "cadastroFilial";
	}
		
	
}
