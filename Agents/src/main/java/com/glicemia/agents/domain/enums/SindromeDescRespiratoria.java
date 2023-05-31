package com.glicemia.agents.domain.enums;

public enum SindromeDescRespiratoria {

	IGNORADO(1, "Ignorado"), POSSUI(2, "Possui"), NAO(3, "Não tem");

	private Integer codigo;
	private String descricao;

	private SindromeDescRespiratoria() {
		// TODO Auto-generated constructor stub
	}

	private SindromeDescRespiratoria(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static SindromeDescRespiratoria toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (SindromeDescRespiratoria x : SindromeDescRespiratoria.values()) {
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
