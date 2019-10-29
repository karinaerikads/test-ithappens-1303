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
public class Filial implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	@NotEmpty //Não permite que o campo fique vazio
	private String nome;
	@NotEmpty //Não permite que o campo fique vazio
	private String estado;
	@NotEmpty //Não permite que o campo fique vazio
	private String cidade;
	@NotEmpty //Não permite que o campo fique vazio
	private String rua;
	@NotEmpty //Não permite que o campo fique vazio
	private String numero;
	@NotEmpty //Não permite que o campo fique vazio
	private String telefone;
	@NotEmpty //Não permite que o campo fique vazio
	private String bairro;
	
	//Uma filial para muitos pedidos_estoques
	@OneToMany( mappedBy="filial", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<PedidoEstoque> pedidoestoque;
	
	
	public List<PedidoEstoque> getPedidoestoque() {
		return pedidoestoque;
	}
	public void setPedidoestoque(List<PedidoEstoque> pedidoestoque) {
		this.pedidoestoque = pedidoestoque;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
