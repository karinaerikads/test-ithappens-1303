package com.ithappenstest1303.test1303ithappens.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class PedidoEstoque implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	@Id //É a chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	@NotEmpty //Não permite que o campo fique vazio
	private String observacao;
	@NotNull //Não permite que o campo fique vazio
	private int tipo;
	@NotNull //Não permite que o campo fique vazio
	private double valortotal;
	
	//Um pedido_estoque para muitos itens_pedido
	@OneToMany( mappedBy="pedidoestoque", cascade=CascadeType.ALL, orphanRemoval=false)
	private List<ItensPedido> itenspedido;

	@ManyToOne //Muitos pedidos_estoque um usuário
	private Usuario usuario;
	
	@ManyToOne //Muitos pedidos_estoque um cliente
	private Cliente cliente;

	@ManyToOne //Muitos pedidos_estoque uma filia
	private Filial filial;
	
	
	
	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

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

	public List<ItensPedido> getItenspedido() {
		return itenspedido;
	}

	public void setItenspedido(List<ItensPedido> itenspedido) {
		this.itenspedido = itenspedido;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	
}
