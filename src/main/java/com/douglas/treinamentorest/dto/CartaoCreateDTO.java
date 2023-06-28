package com.douglas.treinamentorest.dto;

import java.io.Serializable;

public class CartaoCreateDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String numero;
	private String senha;

	public CartaoCreateDTO(String numero, String senha) {
		this.numero = numero;
		this.senha = senha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
