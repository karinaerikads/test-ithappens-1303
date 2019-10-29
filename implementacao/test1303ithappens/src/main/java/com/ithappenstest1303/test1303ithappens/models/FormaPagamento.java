package com.ithappenstest1303.test1303ithappens.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
public class FormaPagamento {
	private static final long serialVersionUID = 1L; 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	@NotEmpty //Não permite que o campo fique vazio
	private String tipo;
	
	
	
	//Um cliente para muitos pedidos_estoques
	@OneToMany( mappedBy="formapagamento", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<PedidoEstoque> pedidoestoque;
	
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<PedidoEstoque> getPedidoestoque() {
		return pedidoestoque;
	}

	public void setPedidoestoque(List<PedidoEstoque> pedidoestoque) {
		this.pedidoestoque = pedidoestoque;
	}

	
	
	
	

}
