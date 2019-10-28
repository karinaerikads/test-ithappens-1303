package com.ithappenstest1303.test1303ithappens.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
public class ItensPedido {

	@Id //É a chave primária
	@NotEmpty //Não permite que o campo fique vazio
	private long codigo;
	@NotNull //Não permite que o campo fique vazio
	private long quantidade;
	@NotEmpty //Não permite que o campo fique vazio
	private double valor_unitario;
	
	@ManyToOne //Muitos itens pedidos para um produto
	private Produto produto;
	
	@ManyToOne ////Muitos itens pedidos para um pedido estoque
	private PedidoEstoque pedidoestoque;
	
	

	public double getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}



	
	
	
}
