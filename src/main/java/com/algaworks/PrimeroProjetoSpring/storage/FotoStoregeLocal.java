package com.algaworks.PrimeroProjetoSpring.storage;


import static java.nio.file.FileSystems.getDefault;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.PrimeroProjetoSpring.repository.FotoReader;
import com.algaworks.PrimeroProjetoSpring.repository.FotoStorage;

@Profile("storage-local")
@Component
public class FotoStoregeLocal implements FotoStorage,FotoReader{

	private Path local;
	
	public FotoStoregeLocal() {
		this.local = getDefault().getPath(System.getenv("HOME"), ".winefotos");
		
		try {
			Files.createDirectories(this.local);
		} catch (IOException e) {
			throw new RuntimeException("Erro criando pasta para salvar foto", e);
		}
	}
	
	@Override
	public String salvar(MultipartFile foto) {
		String nomeFoto = foto.getOriginalFilename();
		try {
			foto.transferTo(new File(
					this.local.toAbsolutePath().toString() + getDefault().getSeparator() + nomeFoto));
		} catch (IOException e) {
			throw new RuntimeException("Erro salvando a foto", e);
		}

		return nomeFoto;
	}

	@Override
	public String getUrl(String nomeFoto) {
		return "http://localhost:8080/fotos/" + nomeFoto;
	}

	@Override
	public byte[] recuperar(String nome) {
		try {
			return Files.readAllBytes(this.local.resolve(nome));
		} catch (IOException e) {
			throw new RuntimeException("Erro recuperando a foto", e);
		}

	}
	

}
