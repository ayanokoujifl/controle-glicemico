package com.glicemia.agents.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.glicemia.agents.domain.enums.InstabilidadeHemodinamica;
import com.glicemia.agents.domain.enums.SindromeDescRespiratoria;
import com.glicemia.agents.domain.enums.StatusPaciente;
import com.glicemia.agents.domain.enums.TipoCorticoide;
import com.glicemia.agents.domain.enums.TipoDiabete;
import com.glicemia.agents.domain.enums.TipoInfeccao;
import com.glicemia.agents.domain.enums.TipoInsuficienciaRenal;
import com.glicemia.agents.domain.enums.TipoInternacao;
import com.glicemia.agents.dto.PacienteDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public Paciente() {
	}

	public Paciente(PacienteDTO obj) {
		prontuario = obj.getProntuario();
		nome = obj.getNome();
		dataNascimento = obj.getDataNascimento();
		sexo = obj.getSexo();
		dataHoraInternacao = obj.getDataHoraInternacao();
		tipoInternacao = TipoInternacao.toEnum(obj.getTipoInternacao());
		peso = obj.getPeso();
		altura = obj.getAltura();
		imc = obj.getImc();
		diabetes = TipoDiabete.toEnum(obj.getDiabetes());
		insuficienciaRenal = TipoInsuficienciaRenal.toEnum(obj.getInsuficienciaRenal());
		corticoide = TipoCorticoide.toEnum(obj.getCorticoide());
		infeccao = TipoInfeccao.toEnum(obj.getInfeccao());
		sindromeDescRespiratorio = SindromeDescRespiratoria.toEnum(obj.getSindromeDescRespiratorio());
		instabilidadeHemodinamica = InstabilidadeHemodinamica.toEnum(obj.getInstabilidadeHemodinamica());
		statusPaciente = StatusPaciente.toEnum(obj.getStatusPaciente());
		planoAplicacao = obj.getPlanoAplicacao();
		observacoes = obj.getObservacoes();
		tratamento = obj.getTratamento();
		monitoramento = obj.getMonitoramento();
		createDate = obj.getCreateDate();
		updateDate = obj.getUpdateDate();

	}

	public Paciente(String nome, Date dataNascimento, String sexo, Integer tipoInternacao, Double peso, Double altura,
			Integer diabetes, Integer insuficienciaRenal, Integer corticoide, Integer infeccao,
			Integer sindromeDescRespiratorio, Integer instabilidadeHemodinamica, Integer statusPaciente,
			List<Date> planoAplicacao, Date createDate) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.tipoInternacao = TipoInternacao.toEnum(tipoInternacao);
		this.peso = peso;
		this.altura = altura;
		this.imc = peso / Math.pow(altura, 2);
		this.diabetes = TipoDiabete.toEnum(diabetes);
		this.insuficienciaRenal = TipoInsuficienciaRenal.toEnum(insuficienciaRenal);
		this.corticoide = TipoCorticoide.toEnum(corticoide);
		this.infeccao = TipoInfeccao.toEnum(infeccao);
		this.sindromeDescRespiratorio = SindromeDescRespiratoria.toEnum(sindromeDescRespiratorio);
		this.instabilidadeHemodinamica = InstabilidadeHemodinamica.toEnum(instabilidadeHemodinamica);
		this.statusPaciente = StatusPaciente.toEnum(statusPaciente);
		this.planoAplicacao = planoAplicacao;
		this.createDate = createDate;
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
}
