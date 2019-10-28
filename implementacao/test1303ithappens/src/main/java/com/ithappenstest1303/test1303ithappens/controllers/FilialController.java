package com.ithappenstest1303.test1303ithappens.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ithappenstest1303.test1303ithappens.models.Filial;
import com.ithappenstest1303.test1303ithappens.repository.FilialRepository;

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
	
	//Retorna lista com todas as filiais
	@RequestMapping("/listaFiliais")
	public ModelAndView listaFiliais(){
		ModelAndView mv = new ModelAndView("listaFiliais");
		Iterable<Filial> filiais = fr.findAll();
		mv.addObject("filiais", filiais);
		return mv;
	}
	
	
	//Deleta uma filial específica
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		Filial filial = fr.findByCodigo(id);
		fr.delete(filial);
		ModelAndView modelAndView = new ModelAndView("redirect:/listaFiliais");
		
		
		return modelAndView;
	}
	
}
