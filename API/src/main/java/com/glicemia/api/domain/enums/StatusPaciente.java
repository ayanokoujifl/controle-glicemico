package com.glicemia.api.domain.enums;

public enum StatusPaciente {

	INTERNADO(1, "Internado"), ALTA(2, "Alta");

	private Integer codigo;
	private String descricao;

	private StatusPaciente() {
	}

	private StatusPaciente(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public static StatusPaciente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (StatusPaciente x : StatusPaciente.values()) {
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
