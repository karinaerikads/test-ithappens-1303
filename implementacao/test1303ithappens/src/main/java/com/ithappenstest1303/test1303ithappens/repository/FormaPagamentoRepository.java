package com.ithappenstest1303.test1303ithappens.repository;

import org.springframework.data.repository.CrudRepository;

import com.ithappenstest1303.test1303ithappens.models.FormaPagamento;

public interface FormaPagamentoRepository extends CrudRepository<FormaPagamento, String>{
	FormaPagamento findByCodigo(long codigo);
}
