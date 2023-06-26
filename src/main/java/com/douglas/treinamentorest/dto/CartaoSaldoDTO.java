package com.douglas.treinamentorest.dto;

import com.douglas.treinamentorest.domain.Cartao;

public class CartaoSaldoDTO {
    private double saldo;

    public CartaoSaldoDTO(double saldo) {
        this.saldo = saldo;
    }
    
	public CartaoSaldoDTO(Cartao obj) {
		saldo = obj.getSaldo();

	}

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
