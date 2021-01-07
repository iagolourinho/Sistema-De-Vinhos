package com.algaworks.PrimeroProjetoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.PrimeroProjetoSpring.model.Vinho;

public interface Vinhos extends JpaRepository<Vinho, Long>{
	
}
