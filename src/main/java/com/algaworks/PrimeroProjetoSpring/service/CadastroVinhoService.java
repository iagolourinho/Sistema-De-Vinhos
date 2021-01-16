package com.algaworks.PrimeroProjetoSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.PrimeroProjetoSpring.model.Vinho;
import com.algaworks.PrimeroProjetoSpring.repository.Vinhos;

@Service
public class CadastroVinhoService {

	@Autowired
	private Vinhos vinhos;
	
	public void salvar(Vinho vinho) {
		//Escrever regras de negocio aqui...
		this.vinhos.save(vinho);
		
	}
	
	public void adicionarFoto(Long codigo,String nome) {
		Vinho vinho = vinhos.findOne(codigo);
		vinho.setFoto(nome);
		vinhos.save(vinho);
	}
}
