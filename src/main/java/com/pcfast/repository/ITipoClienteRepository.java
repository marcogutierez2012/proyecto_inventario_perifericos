package com.pcfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcfast.model.TipoCliente;

public interface ITipoClienteRepository extends JpaRepository<TipoCliente, Integer> {

}
