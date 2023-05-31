package com.glicemia.agents.domain.enums;

public enum TipoDiabete {

	IGNORADO(1, "Ignorado"), CDD(2, "Controle domiciliar dietético"),
	CDHO(3, "Controle domiciliar com hipoglicemiante oral"), CDI(4, "Controle domiciliar com insulina"),
	CDM(5, "Controle domiciliar medicamentoso"), NAO(6, "Não tem");

	private Integer codigo;
	private String descricao;

	private TipoDiabete() {
		// TODO Auto-generated constructor stub
	}

	private TipoDiabete(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static TipoDiabete toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoDiabete x : TipoDiabete.values()) {
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
