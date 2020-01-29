package com.casadeshow.gft.model;

public enum Genero {
	
	ROCK("Rock"),
	POP("Pop"),
	RAP("Rap");
	
	private String genero;

	Genero(String genero) {
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	
	

}
