package com.douglas.treinamentorest.dto;

public class TransacaoDTO extends CartaoDTO{
	private static final long serialVersionUID = 1L;

	private String senha;

	private double valor;
	
	private int codigoSeguranca;

	public TransacaoDTO() {
	}

	public TransacaoDTO(String senha, double valor, int codigoSeguranca) {
		this.senha = senha;
		this.valor = valor;
		this.codigoSeguranca = codigoSeguranca;
	}

	public String getSenha() {

		return senha;
	}

	public void setSenha(String senha) {

		this.senha = senha;
	}

	public double getValor() {

		return valor;
	}

	public void setValor(double valor) {

		this.valor = valor;
	}

	public int getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(int codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	
	

}
