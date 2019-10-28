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
public class Usuario  implements Serializable{
private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	@NotEmpty //Não permite que o campo fique vazio
	private String email;
	@NotEmpty //Não permite que o campo fique vazio
	private String nome;
	@NotEmpty //Não permite que o campo fique vazio
	private String cpf;
	
	//Um usuário para muitos pedido_estoque
	/*@OneToMany( mappedBy="usuario", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<PedidoEstoque> pedidoestoque;*/
}
