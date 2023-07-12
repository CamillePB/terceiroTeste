package com.br.terceiroTeste.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.br.terceiroTeste.entities.CandidatoEntity;


public interface CandidatoRepository extends JpaRepository<CandidatoEntity, Long>{

	List<CandidatoEntity> findByStatus(String Status);
	
	List<CandidatoEntity> findByNome(String Nome);
	 

	
}
