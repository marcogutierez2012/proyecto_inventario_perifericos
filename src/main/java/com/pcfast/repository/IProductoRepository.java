package com.pcfast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcfast.model.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {

	Producto findByIdProducto(int idProducto);
	
	Producto findByDesProducto(String des);
	
	List<Producto> findByDesProductoContainingOrTipoproductoDesTipoProductoContaining(String des, String tipo);
}
