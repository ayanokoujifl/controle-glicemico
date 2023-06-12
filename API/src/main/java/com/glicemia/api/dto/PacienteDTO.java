package com.glicemia.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.glicemia.api.domain.Paciente;
import com.glicemia.api.domain.enums.InstabilidadeHemodinamica;
import com.glicemia.api.domain.enums.SindromeDescRespiratoria;
import com.glicemia.api.domain.enums.StatusPaciente;
import com.glicemia.api.domain.enums.TipoCorticoide;
import com.glicemia.api.domain.enums.TipoDiabete;
import com.glicemia.api.domain.enums.TipoInfeccao;
import com.glicemia.api.domain.enums.TipoInsuficienciaRenal;
import com.glicemia.api.domain.enums.TipoInternacao;

public class PacienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long prontuario;
	private String nome;
	private Date dataNascimento;
	private String sexo;
	private Date dataHoraInternacao;
	private TipoInternacao tipoInternacao;
	private Double peso;
	private Double altura;
	private Double imc;
	private TipoDiabete diabetes;
	private TipoInsuficienciaRenal insuficienciaRenal;
	private TipoCorticoide corticoide;
	private TipoInfeccao infeccao;
	private SindromeDescRespiratoria sindromeDescRespiratorio;
	private InstabilidadeHemodinamica instabilidadeHemodinamica;
	private StatusPaciente statusPaciente;
	private List<Date> planoAplicacao = new ArrayList<>();
	private String observacoes;
	private String tratamento;
	private String monitoramento;
	private Date createDate;
	private Date updateDate;

	public PacienteDTO(Paciente paciente) {
		this.prontuario=paciente.getProntuario();
		this.nome = paciente.getNome();
		this.dataNascimento = paciente.getDataNascimento();
		this.sexo = paciente.getSexo();
		this.dataHoraInternacao = paciente.getDataHoraInternacao();
		this.tipoInternacao = paciente.getTipoInternacao();
		this.peso = paciente.getPeso();
		this.altura = paciente.getAltura();
		this.imc = paciente.getImc();
		this.diabetes = paciente.getDiabetes();
		this.insuficienciaRenal = paciente.getInsuficienciaRenal();
		this.corticoide = paciente.getCorticoide();
		this.infeccao = paciente.getInfeccao();
		this.sindromeDescRespiratorio = paciente.getSindromeDescRespiratorio();
		this.instabilidadeHemodinamica = paciente.getInstabilidadeHemodinamica();
		this.statusPaciente = paciente.getStatusPaciente();
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

	public TipoInternacao getTipoInternacao() {
		return tipoInternacao;
	}

	public void setTipoInternacao(TipoInternacao tipoInternacao) {
		this.tipoInternacao = tipoInternacao;
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

	public TipoDiabete getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(TipoDiabete diabetes) {
		this.diabetes = diabetes;
	}

	public TipoInsuficienciaRenal getInsuficienciaRenal() {
		return insuficienciaRenal;
	}

	public void setInsuficienciaRenal(TipoInsuficienciaRenal insuficienciaRenal) {
		this.insuficienciaRenal = insuficienciaRenal;
	}

	public TipoCorticoide getCorticoide() {
		return corticoide;
	}

	public void setCorticoide(TipoCorticoide corticoide) {
		this.corticoide = corticoide;
	}

	public TipoInfeccao getInfeccao() {
		return infeccao;
	}

	public void setInfeccao(TipoInfeccao infeccao) {
		this.infeccao = infeccao;
	}

	public SindromeDescRespiratoria getSindromeDescRespiratorio() {
		return sindromeDescRespiratorio;
	}

	public void setSindromeDescRespiratorio(SindromeDescRespiratoria sindromeDescRespiratorio) {
		this.sindromeDescRespiratorio = sindromeDescRespiratorio;
	}

	public InstabilidadeHemodinamica getInstabilidadeHemodinamica() {
		return instabilidadeHemodinamica;
	}

	public void setInstabilidadeHemodinamica(InstabilidadeHemodinamica instabilidadeHemodinamica) {
		this.instabilidadeHemodinamica = instabilidadeHemodinamica;
	}

	public StatusPaciente getStatusPaciente() {
		return statusPaciente;
	}

	public void setStatusPaciente(StatusPaciente statusPaciente) {
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
