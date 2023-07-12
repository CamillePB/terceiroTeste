package com.br.terceiroTeste.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.terceiroTeste.entities.CandidatoEntity;
import com.br.terceiroTeste.repositories.CandidatoRepository;

@RequestMapping("/api/v1/hiring")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CandidatoController {
//	private ArrayList<CandidatoEntity> Candidatos = new ArrayList<CandidatoEntity>();
//	int codCandidato;
	String status;

	public String aprovado() {
		return status = "Aprovado";
	}

	public String qualificado() {
		return status = "Qualificado";
	}

	@Autowired
	private CandidatoRepository candidatoRepository;

	@GetMapping
	public List<CandidatoEntity> getAll() {
		return candidatoRepository.findAll();

	}

	@GetMapping("/status/candidate/{codCandidato}")
	public Optional<CandidatoEntity> verificarCandidato(@PathVariable Long codCandidato) {
		return candidatoRepository.findById(codCandidato);
	}

	@GetMapping("/approved")
	public List<CandidatoEntity> listarAprovados() {
		return candidatoRepository.findByStatus("Aprovado");
	}

	@PostMapping
	public void registrarCandidato(@RequestBody CandidatoEntity candidatoEntity) {
		String status = "Recebido";
		candidatoEntity.setStatus(status);
		candidatoRepository.save(candidatoEntity);
	}

	@PostMapping("/approve")
	public void aprovarCandidatos(@RequestBody CandidatoEntity candidatoEntity) {
		if (candidatoRepository.existsById(candidatoEntity.getCodCandidato())) {
			candidatoEntity.setStatus(aprovado());
			candidatoEntity.getNome();
			candidatoRepository.save(candidatoEntity);
		}
	}

	@PutMapping("/schedule")
	public Optional<CandidatoEntity> marcarEntrevistaComCandidato(@RequestBody CandidatoEntity candidatoEntity) {
		if (candidatoRepository.existsById(candidatoEntity.getCodCandidato())) {
			candidatoEntity.setStatus(qualificado());
			candidatoEntity.getNome();
			candidatoRepository.save(candidatoEntity);
		}
		
		return candidatoRepository.findById(candidatoEntity.getCodCandidato());

	}

	@PostMapping("/disqualify")
	public void apagaUsuarios(@RequestBody CandidatoEntity candidatoEntity) {
		if (candidatoRepository.existsById(candidatoEntity.getCodCandidato())) {
			candidatoRepository.delete(candidatoEntity);
		}

	}

////		ArrayList<CandidatoEntity> Candidatos = new ArrayList<CandidatoEntity>();
////		candidatoRepository.findAll();
//		//candidatoRepository.deleteById(codCandidato);
//	}

//	public int gerarNumero() {
//		return ++codCandidato;// incrementando um numero a cada registro
//	}
//
//	public String qualificado() {
//		return statusCandidato = "Qualificado";
//	}
//
//	public String aprovado() {
//		return statusCandidato = "Aprovado";
//	}
//
//	
//	public void listarTodosAprovados() {// listar todos os candidatos aprovados
////
////		for (var candidato : Candidatos) {
////			if (candidato.getStatusCandidato() == "Aprovado")
////				candidato.candidatoInfo();
////		}
//
//	}
//
//	
//	public void atualizarCandidato(int codCandidato, String statusCandidato) {// editar por status
//		var candidato = buscarId(codCandidato);
//
//		if (candidato != null) {
//			candidato.atualizarCandidato(statusCandidato);
//		}
//	}
//
//	
//	public void listarPorId(int codCandidato) {// listar candidato por id
//		var candidato = buscarId(codCandidato);
//
////		if (candidato != null)
////			candidato.candidatoInfo();
////		else
////			System.out.println("Candidato não foi encontrada");
//	}
//
//	
////	public void registrarCandidato(CandidatoEntity candidatoEntity) {
////		Candidatos.add(candidatoEntity);
////		System.out.println("A inscrição de: " + candidatoEntity.getNomeCandidato() + " foi criada.\n");
////	}
//
//	
//	public void desclassificarCandidato(int codCandidato) {// exclui candidato por id
//		var candidato = buscarId(codCandidato);
//
//		if (candidato != null) {
//			if (Candidatos.remove(candidato))
//				System.out.println("Candidato foi desclassificado\n");
//			else
//				System.out.println("A conta não foi encontrada");
//		}
//	}
//
//	
//	public CandidatoEntity buscarId(int codCandidato) {
//		for (var candidato : Candidatos) {
//			if (candidato.getCodCandidato() == codCandidato)
//				return candidato;
//		}
//
//		return null;
//	}
}
