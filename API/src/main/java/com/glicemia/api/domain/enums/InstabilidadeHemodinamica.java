package com.glicemia.api.domain.enums;

public enum InstabilidadeHemodinamica {

	CSDV(1, "Controlado sem drogas vasoativas"), CCD(2, "Controlado com drogas vasoativas"),
	DAD(3, "Descontrolado apesar das drogas"), IGNORADO(4, "Ignorado"), NAO(5, "Nao tem");

	private Integer codigo;
	private String descricao;

	private InstabilidadeHemodinamica() {
		// TODO Auto-generated constructor stub
	}

	private InstabilidadeHemodinamica(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static InstabilidadeHemodinamica toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (InstabilidadeHemodinamica x : InstabilidadeHemodinamica.values()) {
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
