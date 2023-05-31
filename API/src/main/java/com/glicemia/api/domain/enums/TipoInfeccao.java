package com.glicemia.api.domain.enums;

public enum TipoInfeccao {

	IS(1, "Infecção simples"), SEPSE(2, "Sepse"), IGNORADO(3, "Ignorado"), NAO(4, "Não tem");

	private Integer codigo;
	private String descricao;

	private TipoInfeccao() {
		// TODO Auto-generated constructor stub
	}

	private TipoInfeccao(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static TipoInfeccao toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoInfeccao x : TipoInfeccao.values()) {
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
