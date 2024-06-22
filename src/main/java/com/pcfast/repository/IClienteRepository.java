package com.pcfast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcfast.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

	Cliente findByIdCliente(int idCliente);
	
	Cliente findByDocCliente(String doc);
	
	List<Cliente> findByNomClienteContainingOrDocClienteContaining(String nom, String doc);
	
}
