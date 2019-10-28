package com.ithappenstest1303.test1303ithappens.repository;

import org.springframework.data.repository.CrudRepository;

import com.ithappenstest1303.test1303ithappens.models.Filial;

public interface FilialRepository extends CrudRepository<Filial, String>{
	
	Filial findByCodigo(long codigo);
	
}
