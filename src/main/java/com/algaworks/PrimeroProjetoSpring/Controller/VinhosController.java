package com.algaworks.PrimeroProjetoSpring.Controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.algaworks.PrimeroProjetoSpring.model.TipoVinho;
import com.algaworks.PrimeroProjetoSpring.model.Vinho;
import com.algaworks.PrimeroProjetoSpring.repository.FotoStorage;
import com.algaworks.PrimeroProjetoSpring.repository.Vinhos;
import com.algaworks.PrimeroProjetoSpring.service.CadastroVinhoService;


@Controller
@RequestMapping("/vinhos")
public class VinhosController {
	
	@Autowired
	private Vinhos vinhos;
	
	@Autowired
	private CadastroVinhoService cadastroVinhoService;
	
	@Autowired(required = false)
	private FotoStorage fotostorage;

	@RequestMapping
	public ModelAndView pesquisa() {
		ModelAndView mv = new ModelAndView("/vinho/PesquisaVinhos");
		List<Vinho> todosVinhos = vinhos.findAll();
		mv.addObject("vinhos",todosVinhos);
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(Vinho vinho) {
		ModelAndView mv = new ModelAndView("/vinho/CadastroVinhos");
		mv.addObject("tipos", TipoVinho.values());
		return mv;
	}
	
	@RequestMapping(value = "/novo",method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Vinho vinho, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(vinho);
		}
		cadastroVinhoService.salvar(vinho);
		attributes.addFlashAttribute("mensagem", "Vinho salvo com sucesso!");
	return new ModelAndView("redirect:/vinhos/novo");
	}
	
	@RequestMapping("/{codigo}")
	public ModelAndView visualizar(@PathVariable("codigo") Vinho vinho) {
		ModelAndView mv = new ModelAndView("/vinho/visualizacaoVinho");
		//Vinho vinho = vinhos.findOne(codigo);
		
		if (vinho.temFoto()) {
			vinho.setUrl(fotostorage.getUrl(vinho.getFoto()));
		}
		
		
		mv.addObject("vinho", vinho);
		return mv;
	}
}
