package com.pcfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcfast.model.Comprobante;

public interface IComprobanteRepository extends JpaRepository<Comprobante, Integer> {

	Comprobante findByIdComprobante(int idComprobante);
}
