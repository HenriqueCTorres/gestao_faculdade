package br.com.fiap.gestao_faculdade.model;

public enum EnumNivel {
	
	TECNOLOGO("Tecnólogo"),
	BACHARELADO("Bacharelado"), 
	MESTRADO("Mestrado"),
	DOUTORADO("Doutorado"), 
	MBA("MBA"), 
	ESPECIALIZACAO("Especialização"),
	A_DEFINIR("A Definir");
	
	private String descricao;
	
	private EnumNivel(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
