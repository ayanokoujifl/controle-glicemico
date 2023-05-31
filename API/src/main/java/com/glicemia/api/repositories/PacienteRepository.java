package com.glicemia.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glicemia.api.domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
