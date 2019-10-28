package com.ithappenstest1303.test1303ithappens.repository;

import org.springframework.data.repository.CrudRepository;

import com.ithappenstest1303.test1303ithappens.models.Produto;


public interface ProdutoRepository extends CrudRepository<Produto, String>{
	
	Produto findByCodigo(long codigo);
	Produto findByDescricao (String descricao);
	Produto findBySequencial(long sequencial);
	
}
