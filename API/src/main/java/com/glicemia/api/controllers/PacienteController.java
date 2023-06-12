package com.glicemia.api.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.glicemia.api.domain.Paciente;
import com.glicemia.api.dto.PacienteDTO;
import com.glicemia.api.services.PacienteService;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {

	@Autowired
	private PacienteService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<PacienteDTO> findByProntuario(@PathVariable Long id) {
		PacienteDTO objDto = new PacienteDTO(service.findById(id));
		return ResponseEntity.ok().body(objDto);
	}

	@GetMapping
	public ResponseEntity<List<PacienteDTO>> findAll() {
		List<Paciente> list = service.findAll();
		List<PacienteDTO> listDto = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Paciente obj, @PathVariable Long id) {
		obj.setProntuario(id);
		service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<Paciente> save(@RequestBody Paciente obj) {
		obj.setProntuario(null);
		service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getProntuario())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

}
