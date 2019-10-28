package com.ithappenstest1303.test1303ithappens.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;



@Entity
public class Produto implements Serializable {
		

	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	@NotEmpty //Não permite que o campo fique vazio
	private long sequencial;
	@NotEmpty //Não permite que o campo fique vazio
	private String codbarras;
	@NotEmpty //Não permite que o campo fique vazio
	private String descricao;
	
	//Um produto para muitos itens_pedido
	@OneToMany( mappedBy="produto", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<ItensPedido> itenspedido;

	public long getSequencial() {
		return sequencial;
	}

	public void setSequencial(long sequencial) {
		this.sequencial = sequencial;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public List<ItensPedido> getItenspedido() {
		return itenspedido;
	}

	public void setItenspedido(List<ItensPedido> itenspedido) {
		this.itenspedido = itenspedido;
	}

}
