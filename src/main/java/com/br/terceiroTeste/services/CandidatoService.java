package com.br.terceiroTeste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.br.terceiroTeste.entities.CandidatoEntity;
import com.br.terceiroTeste.repositories.CandidatoRepository;

@Service
public class CandidatoService {
	String status;

	public String aprovado() {
		return status = "Aprovado";
	}

	public String qualificado() {
		return status = "Qualificado";
	}
	
	public String recebido() {
		return status = "Recebido";
	}


	@Autowired
	private CandidatoRepository candidatoRepository;

	public List<CandidatoEntity> buscaTodosUsuarios(){
		return candidatoRepository.findAll();
	}

	public Optional<CandidatoEntity> verificarCandidato(@PathVariable Long codCandidato){
		return candidatoRepository.findById(codCandidato);
	}

	public List<CandidatoEntity> listarAprovados() {
		return candidatoRepository.findByStatus("Aprovado");
	}
	
	public void salvaUsuario(CandidatoEntity candidatoEntity) {
		candidatoEntity.setStatus(recebido());
		candidatoRepository.save(candidatoEntity);
	}

	public void aprovar(@RequestBody CandidatoEntity candidatoEntity) {
		if (candidatoRepository.existsById(candidatoEntity.getCodCandidato())) {
			candidatoEntity.setStatus(aprovado());
			candidatoRepository.save(candidatoEntity);
		}
	}

	public void marcarEntrevista(@RequestBody CandidatoEntity candidatoEntity) {
		if (candidatoRepository.existsById(candidatoEntity.getCodCandidato())) {
			candidatoEntity.setStatus(qualificado());
			candidatoRepository.save(candidatoEntity);
		}

	}

	public void desqualificar(@RequestBody CandidatoEntity candidatoEntity) {
		if (candidatoRepository.existsById(candidatoEntity.getCodCandidato())) {
			candidatoRepository.delete(candidatoEntity);
		}

	}


}
