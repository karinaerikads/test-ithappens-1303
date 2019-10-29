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
public class Cliente implements Serializable{

private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	@NotEmpty //Não permite que o campo fique vazio
	private String nome;
	@NotEmpty //Não permite que o campo fique vazio
	private String cnpj;
	@NotEmpty //Não permite que o campo fique vazio
	private String telefone;
	
	//Um cliente para muitos pedidos_estoques
	@OneToMany( mappedBy="cliente", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<PedidoEstoque> pedidoestoque;
		
	
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
