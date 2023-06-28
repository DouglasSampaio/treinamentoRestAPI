package com.douglas.treinamentorest.domain;

public class CartaoRefeicao extends Cartao {
	private static final long serialVersionUID = 1L;

	public CartaoRefeicao(String id, String numero, int codigoSeguranca, String senha,
			double saldo) {
		super(id, numero, codigoSeguranca, senha, saldo);
	}
}
