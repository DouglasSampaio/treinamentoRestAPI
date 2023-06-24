package com.douglas.treinamentorest.dto;

import java.io.Serializable;
import java.math.BigInteger;

import com.douglas.treinamentorest.domain.Cartao;


public class CartaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
    private String numero;
    private String titular;
    private String dataValidade;
    private int codigoSeguranca;
    private String senha;
    
    public CartaoDTO() {
    	
    }
    
    public  CartaoDTO(Cartao obj) {
    	id = obj.getId();
    	titular = obj.getTitular();
    	numero = obj.getNumero();
    	dataValidade = obj.getDataValidade();
    	codigoSeguranca = obj.getCodigoSeguranca();
    	senha = obj.getSenha();
    	
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

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
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
    
    
}
