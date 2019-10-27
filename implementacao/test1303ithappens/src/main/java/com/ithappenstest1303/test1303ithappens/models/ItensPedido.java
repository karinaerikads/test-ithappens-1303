package com.ithappenstest1303.test1303ithappens.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class ItensPedido {

	@Id //É a chave primária
	@NotEmpty //Não permite que o campo fique vazio
	private long codigo;
	@NotEmpty //Não permite que o campo fique vazio
	private int quantidade;
	@NotEmpty //Não permite que o campo fique vazio
	private double valor_unitario;
	
	@ManyToOne //Muitos itens pedidos para um produto
	private Produto produto;
	
	@ManyToOne
	private PedidoEstoque pedidoestoque;
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}



	
	
	
}
