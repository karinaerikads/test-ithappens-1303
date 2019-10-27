package com.ithappenstest1303.test1303ithappens.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class PedidoEstoque implements Serializable {
	@Id //É a chave primária
	@NotEmpty //Não permite que o campo fique vazio
	private long codigo;
	@NotEmpty //Não permite que o campo fique vazio
	private String observação;
	@NotEmpty //Não permite que o campo fique vazio
	private int tipo;
	@NotEmpty //Não permite que o campo fique vazio
	private double valor_total;
	
	//Um pedido_estoque para muitos itens_pedido
	@OneToMany( mappedBy="pedidoestoque", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<ItensPedido> itenspedido;



	public String getObservação() {
		return observação;
	}

	public void setObservação(String observação) {
		this.observação = observação;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}


	
}
