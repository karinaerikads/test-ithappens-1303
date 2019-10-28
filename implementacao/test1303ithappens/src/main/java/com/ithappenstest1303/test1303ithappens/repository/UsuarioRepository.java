package com.ithappenstest1303.test1303ithappens.repository;

import org.springframework.data.repository.CrudRepository;


import com.ithappenstest1303.test1303ithappens.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	
	Usuario findByCodigo(long codigo);
	
}