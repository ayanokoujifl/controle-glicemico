package com.glicemia.agents.domain.enums;

public enum TipoInsuficienciaRenal {

	CD(1, "Crônica dialítica"), CND(2, "Crônica não dialítica"), AD(3, "Aguda dialítica"),
	AND(4, "Aguda não dialítica"), IGNORADO(5, "Ignorado"), NAO(6, "Não tem");

	private Integer codigo;
	private String descricao;

	private TipoInsuficienciaRenal() {
		// TODO Auto-generated constructor stub
	}

	private TipoInsuficienciaRenal(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static TipoInsuficienciaRenal toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoInsuficienciaRenal x : TipoInsuficienciaRenal.values()) {
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
