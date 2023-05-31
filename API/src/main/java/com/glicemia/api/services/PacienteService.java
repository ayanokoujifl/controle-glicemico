package com.glicemia.api.services;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glicemia.api.domain.Paciente;
import com.glicemia.api.repositories.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repo;

	public List<Paciente> findAll() {
		return repo.findAll();
	}

	public Paciente findById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(Paciente.class.getName(), id));
	}

}
