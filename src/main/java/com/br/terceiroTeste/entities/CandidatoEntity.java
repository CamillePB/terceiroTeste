package com.br.terceiroTeste.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "candidatos")
public class CandidatoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremento
	private Long codCandidato;
	
	@Column
	private String nome;
	
	@Column
	private String status;

	public Long getCodCandidato() {
		return codCandidato;
	}

	public void setCodCandidato(Long codCandidato) {
		this.codCandidato = codCandidato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void atualizarCandidato(String status) {
		this.setStatus(status);
	}

}
