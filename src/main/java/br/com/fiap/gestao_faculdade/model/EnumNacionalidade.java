package br.com.fiap.gestao_faculdade.model;

public enum EnumNacionalidade {
	
	BRASILEIRA("Brasileira"), 
	JAPONESA("Japonesa"), 
	ITALIANA("Italiana"),
	COLOMBIANA("Colômbiana"), 
	CHINESA("Chinesa"), 
	MEXICANA("Mexicana"), 
	VENEZUELANA("Venezuelana");
	
	private String descricao;
	
	private EnumNacionalidade(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
