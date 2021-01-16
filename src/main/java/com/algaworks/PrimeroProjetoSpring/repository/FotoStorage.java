package com.algaworks.PrimeroProjetoSpring.repository;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {

	public String salvar(MultipartFile foto);
	
	public String getUrl(String nomeFoto);
}
