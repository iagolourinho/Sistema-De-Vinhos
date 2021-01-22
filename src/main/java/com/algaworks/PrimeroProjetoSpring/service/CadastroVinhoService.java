package com.algaworks.PrimeroProjetoSpring.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.PrimeroProjetoSpring.model.Vinho;
import com.algaworks.PrimeroProjetoSpring.repository.FotoStorage;
import com.algaworks.PrimeroProjetoSpring.repository.Vinhos;


@Service
public class CadastroVinhoService {

	@Autowired
	private Vinhos vinhos;

	@Autowired
	private FotoStorage fotostorage;
	
	public void salvar(Vinho vinho) {
		//Escrever regras de negocio aqui...
		this.vinhos.save(vinho);
		
	}
	
	public String adicionarFoto(Long codigo, MultipartFile foto) {
		Vinho vinho = vinhos.findOne(codigo);
		String nomeFoto = fotostorage.salvar(foto);
		vinho.setFoto(nomeFoto);
		vinhos.save(vinho);

		return fotostorage.getUrl(nomeFoto);
	}
}
