package br.com.fiap.gestao_faculdade.model;

public enum EnumStatus {
	
	ATIVO("Ativo"),
	FORMADO("Formado"), 
	TRANCADO("Trancado"), 
	CANCELADO("Cancelado"), 
	EM_MOBILIDADE("Em Mobilidade"),
	A_DEFINIR("A definir");
	
	private String descricao;
	
	private EnumStatus(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
