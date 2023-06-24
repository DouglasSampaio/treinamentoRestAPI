package com.douglas.treinamentorest.domain;


public class CartaoAlimentacao extends Cartao {
	private static final long serialVersionUID = 1L;
	
	private double saldo;

    public CartaoAlimentacao(String id, String numero, String titular, String dataValidade, int codigoSeguranca, String senha, double saldo) {
        super(id, numero, titular, dataValidade, codigoSeguranca, senha);
        this.saldo = 500.0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void realizarCompra(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Compra realizada com sucesso com o cartão de alimentação " + getNumero());
        } else {
            System.out.println("Saldo insuficiente. Não foi possível realizar a compra.");
        }
    }
}
