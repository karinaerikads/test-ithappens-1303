package com.ithappenstest1303.test1303ithappens.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
public class ItensPedido {

	@Id //É a chave primária
	@NotNull //Não permite que o campo fique vazio
	private long codigo;
	@NotNull //Não permite que o campo fique vazio
	private long quantidade;
	@NotNull //Não permite que o campo fique vazio
	private double valor_unitario;
	
	@ManyToOne //Muitos itens pedidos para um produto
	private Produto produto;
	
	@ManyToOne ////Muitos itens pedidos para um pedido estoque
	private PedidoEstoque pedidoestoque;
	
	

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public PedidoEstoque getPedidoestoque() {
		return pedidoestoque;
	}

	public void setPedidoestoque(PedidoEstoque pedidoestoque) {
		this.pedidoestoque = pedidoestoque;
	}

	public double getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}



	
	
	
}
