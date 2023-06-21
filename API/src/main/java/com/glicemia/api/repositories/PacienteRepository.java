package com.glicemia.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.glicemia.api.domain.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	@Query("select p from Paciente p where lower(p.nome) like lower(concat('%',:nome,'%'))")
	List<Paciente> findByNome(@Param("nome") String nome);

}
