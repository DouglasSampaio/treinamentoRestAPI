package com.douglas.treinamentorest.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cartao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String numero;
	private int codigoSeguranca;
	private String senha;
	private double saldo;
	private double valor;

	public Cartao() {
	}

	public Cartao(String id, String numero, int codigoSeguranca, String senha) {
		super();
		this.id = id;
		this.numero = numero;
		this.codigoSeguranca = codigoSeguranca;
		this.senha = senha;
		this.saldo = 500;
	}

	public Cartao(String id, String numero, int codigoSeguranca, String senha, double saldo) {
		super();
		this.id = id;
		this.numero = numero;
		this.codigoSeguranca = codigoSeguranca;
		this.senha = senha;
		this.saldo = saldo;
	}

	public Cartao(String numero, String senha) {
		super();
		this.numero = numero;
		this.senha = senha;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartao other = (Cartao) obj;
		return Objects.equals(id, other.id);
	}
}
