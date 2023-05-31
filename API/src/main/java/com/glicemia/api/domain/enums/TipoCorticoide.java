package com.glicemia.api.domain.enums;

public enum TipoCorticoide {

	MENOS7(1, "Menos de 7 dias"), MAIS7(2, "Mais de 7 dias"), IGNORADO(3, "Ignorado"), NAO(4, "Não tem");

	private Integer codigo;
	private String descricao;

	private TipoCorticoide() {
		// TODO Auto-generated constructor stub
	}

	private TipoCorticoide(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static TipoCorticoide toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoCorticoide x : TipoCorticoide.values()) {
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
