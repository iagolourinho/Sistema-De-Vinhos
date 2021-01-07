package com.algaworks.PrimeroProjetoSpring.model;

public enum TipoVinho {

	TINTO("Tinto"),
	BRANCO("Branco"),
	ROSER("Roser");
	
	private String tipo;
	
	private TipoVinho(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
	
}
