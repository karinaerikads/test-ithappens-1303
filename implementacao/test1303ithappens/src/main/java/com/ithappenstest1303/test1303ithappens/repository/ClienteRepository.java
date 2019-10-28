package com.ithappenstest1303.test1303ithappens.repository;

import org.springframework.data.repository.CrudRepository;

import com.ithappenstest1303.test1303ithappens.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String>{
	
	Cliente findByCodigo(long codigo);
	
}
