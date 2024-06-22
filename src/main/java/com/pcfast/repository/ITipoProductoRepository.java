package com.pcfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcfast.model.TipoProducto;

public interface ITipoProductoRepository extends JpaRepository<TipoProducto, Integer> {

}
