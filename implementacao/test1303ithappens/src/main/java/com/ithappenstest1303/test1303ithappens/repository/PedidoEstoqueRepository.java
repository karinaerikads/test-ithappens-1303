package com.ithappenstest1303.test1303ithappens.repository;

import org.springframework.data.repository.CrudRepository;

import com.ithappenstest1303.test1303ithappens.models.PedidoEstoque;


public interface PedidoEstoqueRepository extends CrudRepository<PedidoEstoque, String>{
	
	PedidoEstoque findByCodigo(long codigo);
}
