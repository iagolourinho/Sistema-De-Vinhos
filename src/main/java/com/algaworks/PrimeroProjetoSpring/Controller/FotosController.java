package com.algaworks.PrimeroProjetoSpring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.PrimeroProjetoSpring.dto.Foto;
import com.algaworks.PrimeroProjetoSpring.service.CadastroVinhoService;

@RestController
@RequestMapping("/fotos")
public class FotosController {
	
	@Autowired
	private CadastroVinhoService cadastroVinhoService;
	
	@RequestMapping(value = "/{codigo}",method = RequestMethod.POST)
	public Foto upload(@PathVariable Long codigo,
			@RequestParam("files[]") MultipartFile[] files) {
		System.out.println(">>>>>> " +  files[0].getOriginalFilename());
		cadastroVinhoService.adicionarFoto(codigo, files[0].getOriginalFilename());
		return new Foto(files[0].getOriginalFilename());
	}
}
