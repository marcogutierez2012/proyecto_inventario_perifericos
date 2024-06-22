package com.pcfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcfast.model.TipoProducto;

public interface ITipoComprobanteRepository extends JpaRepository<TipoProducto, Integer> {

}
