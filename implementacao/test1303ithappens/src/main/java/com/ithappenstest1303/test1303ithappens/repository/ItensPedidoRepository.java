package com.ithappenstest1303.test1303ithappens.repository;

import org.springframework.data.repository.CrudRepository;

import com.ithappenstest1303.test1303ithappens.models.ItensPedido;

public interface ItensPedidoRepository extends CrudRepository<ItensPedido, String>{
	
	ItensPedido findByCodigo(long codigo);

}
