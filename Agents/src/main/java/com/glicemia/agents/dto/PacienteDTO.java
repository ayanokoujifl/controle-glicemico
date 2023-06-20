package com.glicemia.agents.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.glicemia.agents.domain.Paciente;

public class PacienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long prontuario;
	private String nome;
	private Date dataNascimento;
	private String sexo;
	private Date dataHoraInternacao;
	private Integer tipoInternacao;
	private Double peso;
	private Double altura;
	private Double imc;
	private Integer diabetes;
	private Integer insuficienciaRenal;
	private Integer corticoide;
	private Integer infeccao;
	private Integer sindromeDescRespiratorio;
	private Integer instabilidadeHemodinamica;
	private Integer statusPaciente;
	private List<Date> planoAplicacao = new ArrayList<>();
	private String observacoes;
	private String tratamento;
	private String monitoramento;
	private Date createDate;
	private Date updateDate;

	public PacienteDTO(Paciente paciente) {
		this.prontuario = paciente.getProntuario();
		this.nome = paciente.getNome();
		this.dataNascimento = paciente.getDataNascimento();
		this.sexo = paciente.getSexo();
		this.dataHoraInternacao = paciente.getDataHoraInternacao();
		this.tipoInternacao = paciente.getTipoInternacao().getCodigo();
		this.peso = paciente.getPeso();
		this.altura = paciente.getAltura();
		this.imc = paciente.getImc();
		this.diabetes = paciente.getDiabetes().getCodigo();
		this.insuficienciaRenal = paciente.getInsuficienciaRenal().getCodigo();
		this.corticoide = paciente.getCorticoide().getCodigo();
		this.infeccao = paciente.getInfeccao().getCodigo();
		this.sindromeDescRespiratorio = paciente.getSindromeDescRespiratorio().getCodigo();
		this.instabilidadeHemodinamica = paciente.getInstabilidadeHemodinamica().getCodigo();
		this.statusPaciente = paciente.getStatusPaciente().getCodigo();
		this.planoAplicacao = paciente.getPlanoAplicacao();
		this.observacoes = paciente.getObservacoes();
		this.tratamento = paciente.getTratamento();
		this.monitoramento = paciente.getMonitoramento();
		this.createDate = paciente.getCreateDate();
		this.updateDate = paciente.getUpdateDate();
	}

	public PacienteDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getProntuario() {
		return prontuario;
	}

	public void setProntuario(Long prontuario) {
		this.prontuario = prontuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataHoraInternacao() {
		return dataHoraInternacao;
	}

	public void setDataHoraInternacao(Date dataHoraInternacao) {
		this.dataHoraInternacao = dataHoraInternacao;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getImc() {
		return imc;
	}

	public void setImc(Double imc) {
		this.imc = imc;
	}

	public Integer getTipoInternacao() {
		return tipoInternacao;
	}

	public void setTipoInternacao(Integer tipoInternacao) {
		this.tipoInternacao = tipoInternacao;
	}

	public Integer getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(Integer diabetes) {
		this.diabetes = diabetes;
	}

	public Integer getInsuficienciaRenal() {
		return insuficienciaRenal;
	}

	public void setInsuficienciaRenal(Integer insuficienciaRenal) {
		this.insuficienciaRenal = insuficienciaRenal;
	}

	public Integer getCorticoide() {
		return corticoide;
	}

	public void setCorticoide(Integer corticoide) {
		this.corticoide = corticoide;
	}

	public Integer getInfeccao() {
		return infeccao;
	}

	public void setInfeccao(Integer infeccao) {
		this.infeccao = infeccao;
	}

	public Integer getSindromeDescRespiratorio() {
		return sindromeDescRespiratorio;
	}

	public void setSindromeDescRespiratorio(Integer sindromeDescRespiratorio) {
		this.sindromeDescRespiratorio = sindromeDescRespiratorio;
	}

	public Integer getInstabilidadeHemodinamica() {
		return instabilidadeHemodinamica;
	}

	public void setInstabilidadeHemodinamica(Integer instabilidadeHemodinamica) {
		this.instabilidadeHemodinamica = instabilidadeHemodinamica;
	}

	public Integer getStatusPaciente() {
		return statusPaciente;
	}

	public void setStatusPaciente(Integer statusPaciente) {
		this.statusPaciente = statusPaciente;
	}

	public List<Date> getPlanoAplicacao() {
		return planoAplicacao;
	}

	public void setPlanoAplicacao(List<Date> planoAplicacao) {
		this.planoAplicacao = planoAplicacao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getTratamento() {
		return tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	public String getMonitoramento() {
		return monitoramento;
	}

	public void setMonitoramento(String monitoramento) {
		this.monitoramento = monitoramento;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
