package com.br.terceiroTeste.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.terceiroTeste.entities.CandidatoEntity;
import com.br.terceiroTeste.repositories.CandidatoRepository;
import com.br.terceiroTeste.services.CandidatoService;

@RequestMapping("/api/v1/hiring")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CandidatoController {
	
	@Autowired
	private CandidatoService candidatoService;

	@GetMapping
	public List<CandidatoEntity> getAll() {
		return candidatoService.buscaTodosUsuarios();

	}

	@GetMapping("/status/candidate/{codCandidato}")
	public Optional<CandidatoEntity> verificarCandidato(@PathVariable Long codCandidato) {
		return candidatoService.verificarCandidato(codCandidato);
	}

	@GetMapping("/approved")
	public List<CandidatoEntity> listarAprovados() {
		return candidatoService.listarAprovados();
	}

	@PostMapping("/start")
	public void registrarCandidato(@RequestBody CandidatoEntity candidatoEntity) {
		candidatoService.salvaUsuario(candidatoEntity);
	}

	@PostMapping("/approve")
	public void aprovarCandidato(@RequestBody CandidatoEntity candidatoEntity) {
		candidatoService.aprovar(candidatoEntity);
	}

	@PostMapping("/schedule")
	public void marcarEntrevistaComCandidato(@RequestBody CandidatoEntity candidatoEntity) {
		candidatoService.marcarEntrevista(candidatoEntity);
	}

	@PostMapping("/disqualify")
	public void desqualificarCandidato(@RequestBody CandidatoEntity candidatoEntity) {
		candidatoService.desqualificar(candidatoEntity);
	}


}
