package com.ithappenstest1303.test1303ithappens.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class PedidoEstoque implements Serializable {
	@Id //É a chave primária
	@NotNull //Não permite que o campo fique vazio
	private long codigo;
	@NotEmpty //Não permite que o campo fique vazio
	private String observacao;
	@NotNull //Não permite que o campo fique vazio
	private int tipo;
	@NotNull //Não permite que o campo fique vazio
	private double valortotal;
	
	//Um pedido_estoque para muitos itens_pedido
	@OneToMany( mappedBy="pedidoestoque", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<ItensPedido> itenspedidos;
	/*
	@ManyToOne 
	private Usuario Usuario;
*/



	public int getTipo() {
		return tipo;
	}

	public double getValortotal() {
		return valortotal;
	}

	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<ItensPedido> getItenspedidos() {
		return itenspedidos;
	}

	public void setItenspedidos(List<ItensPedido> itenspedidos) {
		this.itenspedidos = itenspedidos;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	
}
