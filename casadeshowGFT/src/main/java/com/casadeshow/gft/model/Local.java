package com.casadeshow.gft.model;

public enum Local {
	
	MORUMBI("Morumbi"),
	SOROCABA("Sorocaba"),
	PAULISTA("Paulista");
	
	private String local;
	
	Local(String local){
		this.local = local;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

}
