package br.com.fiap.gestao_faculdade.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "discente")
public class Discente {

	@Id
	@GeneratedValue
	(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "O RM é um campo obrigatório.")
	@Size(min = 3, max = 20, message = "O RM deve ter, ao menos, 3"
			+ " caracteres e, no máximo, 20.")
	private String rm;
	@ManyToOne
	@JoinColumn(name = "fk_pessoa")
	@Valid
	private Pessoa pessoa;
	@NotEmpty(message = "O atributo e-ma+il é obrigatório.")
	@Size(min = 6, max = 50, message = "O email deve ter, ao menos, 6"
			+ " caracteres e, no máximo, 50.")
	private String emailInstitucional;
	@Enumerated(EnumType.STRING)
	private EnumStatus status;
	@Enumerated(EnumType.STRING)
	private EnumNivel nivel;

	public Discente() {
		
	}
	
	public Discente(Long id, String rm, Pessoa pessoa, String emailInstitucional, EnumStatus status, EnumNivel nivel) {
		super();
		this.id = id;
		this.rm = rm;
		this.pessoa = pessoa;
		this.emailInstitucional = emailInstitucional;
		this.status = status;
		this.nivel = nivel;
	}
	
	public void transferirDiscente(Discente discente) {
		setRm(discente.getRm());
		setEmailInstitucional(discente.getEmailInstitucional());
		setStatus(discente.getStatus());
		setNivel(discente.getNivel());
		setPessoa(discente.getPessoa());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getEmailInstitucional() {
		return emailInstitucional;
	}

	public void setEmailInstitucional(String emailInstitucional) {
		this.emailInstitucional = emailInstitucional;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

	public EnumNivel getNivel() {
		return nivel;
	}

	public void setNivel(EnumNivel nivel) {
		this.nivel = nivel;
	}

}