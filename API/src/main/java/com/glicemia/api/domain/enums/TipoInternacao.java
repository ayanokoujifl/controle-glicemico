package com.glicemia.api.domain.enums;

public enum TipoInternacao {

	CLINICA(1, "Clínica"), URGENCIA(2, "Cirúrgica de urgência"), ELETIVA(3, "Cirúrgica eletiva"),
	SCA(4, "Síndrome coronária aguda"), AVE(5, "Acidente vascular da ponte"), TRAUMA(6, "Trauma ou oncológica");

	private Integer codigo;
	private String tipo;

	private TipoInternacao() {

	}

	private TipoInternacao(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}

	public static TipoInternacao toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoInternacao x : TipoInternacao.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
