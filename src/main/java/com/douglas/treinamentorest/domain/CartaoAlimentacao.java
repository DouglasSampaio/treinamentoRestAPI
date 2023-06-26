package com.douglas.treinamentorest.domain;

public class CartaoAlimentacao extends Cartao {
	private static final long serialVersionUID = 1L;

	public CartaoAlimentacao(String id, String numero, String dataValidade, int codigoSeguranca, String senha,
			double saldo) {
		super(id, "alimentacao", numero, "", dataValidade, codigoSeguranca, senha, saldo);
	}
}
