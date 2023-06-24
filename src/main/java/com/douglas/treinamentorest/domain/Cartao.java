package com.douglas.treinamentorest.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cartao implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigInteger id;
	@Id
	private BigInteger _id;
    private String numero;
    private String titular;
    private String dataValidade;
    private int codigoSeguranca;
    private String senha;
    
    public Cartao() {
    }
    
    public Cartao(BigInteger id, String numero, String titular, String dataValidade, int codigoSeguranca, String senha) {
		super();
		this.id = id;
		this.numero = numero;
		this.titular = titular;
		this.dataValidade = dataValidade;
		this.codigoSeguranca = codigoSeguranca;
		this.senha = senha;
	}
    
    

    public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
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

	public void realizarPagamento(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado com sucesso com o cartão " + numero);
    }
}
