package com.br.terceiroTeste.entities;

import org.springframework.beans.factory.annotation.Value;

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
	
	@Column(name = "status", nullable = false, columnDefinition = "varchar(255) default 'Recebido'")
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

	
	

//	public void candidatoInfo() {
//
//		System.out.println("\n     "+this.nomeCandidato);
//		System.out.println("**************************************");
//		System.out.println("id: " + this.codCandidato);
//		System.out.println("status: " + this.statusCandidato+"");
//		System.out.println("**************************************\n");
//	}
}
