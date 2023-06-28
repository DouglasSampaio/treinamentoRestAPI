package com.douglas.treinamentorest.dto;

import java.io.Serializable;

import com.douglas.treinamentorest.domain.Cartao;

public class CartaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String numero;
	private int codigoSeguranca;
	private String senha;
	private double saldo;

	public CartaoDTO() {

	}

	public CartaoDTO(Cartao obj) {
		id = obj.getId();
		numero = obj.getNumero();
		codigoSeguranca = obj.getCodigoSeguranca();
		senha = obj.getSenha();
		saldo = obj.getSaldo();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(int codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
