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

	
	public List<Paciente> findByName(String name) {
		return repo.findByNome(name);
	}
		
	public Paciente update(Paciente obj) {
		Paciente newObj = findById(obj.getProntuario());
		updateData(obj, newObj);
		return repo.saveAndFlush(newObj);
	}

	public Paciente save(Paciente obj) {
		return repo.saveAndFlush(obj);
	}
	
	private void updateData(Paciente obj, Paciente newObj) {

		if (obj.getNome() != null) {
			newObj.setNome(obj.getNome());
		}
		if (obj.getAltura() != null) {
			newObj.setAltura(obj.getAltura());
		}
		if (obj.getCorticoide() != null) {
			newObj.setCorticoide(obj.getCorticoide());
		}
		if (obj.getCreateDate() != null) {
			newObj.setCreateDate(obj.getCreateDate());
		}
		if (obj.getDataHoraInternacao() != null) {
			newObj.setDataHoraInternacao(obj.getDataHoraInternacao());
		}
		if (obj.getDataNascimento() != null) {
			newObj.setDataNascimento(obj.getDataNascimento());
		}
		if (obj.getDiabetes() != null) {
			newObj.setDiabetes(obj.getDiabetes());
		}
		if (obj.getImc() != null) {
			newObj.setImc(obj.getImc());
		}
		if (obj.getInfeccao() != null) {
			newObj.setInfeccao(obj.getInfeccao());
		}
		if (obj.getInstabilidadeHemodinamica() != null) {
			newObj.setInstabilidadeHemodinamica(obj.getInstabilidadeHemodinamica());
		}
		if (obj.getInsuficienciaRenal() != null) {
			newObj.setInsuficienciaRenal(obj.getInsuficienciaRenal());
		}
		if (obj.getMonitoramento() != null) {
			newObj.setMonitoramento(obj.getMonitoramento());
		}
		if (obj.getNome() != null) {
			newObj.setNome(obj.getNome());
		}
		if (obj.getObservacoes() != null) {
			newObj.setObservacoes(obj.getObservacoes());
		}
		if (obj.getPeso() != null) {
			newObj.setPeso(obj.getPeso());
		}
		if (obj.getPlanoAplicacao() != null) {
			newObj.setPlanoAplicacao(obj.getPlanoAplicacao());
		}
		if (obj.getSexo() != null) {
			newObj.setSexo(obj.getSexo());
		}
		if (obj.getSindromeDescRespiratorio() != null) {
			newObj.setSindromeDescRespiratorio(obj.getSindromeDescRespiratorio());
		}
		if (obj.getStatusPaciente() != null) {
			newObj.setStatusPaciente(obj.getStatusPaciente());
		}
		if (obj.getTipoInternacao() != null) {
			newObj.setTipoInternacao(obj.getTipoInternacao());
		}
		if (obj.getTratamento() != null) {
			newObj.setTratamento(obj.getTratamento());
		}
		if (obj.getUpdateDate() != null) {
			newObj.setUpdateDate(obj.getUpdateDate());
		}
	}
}
