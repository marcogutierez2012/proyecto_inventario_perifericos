package com.pcfast.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tb_comprobante")
public class Comprobante {
	
	@Id
	@Column(name="id_comprobante")
	private int idComprobante;
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="fec_comprobante")
	private Date fecComprobante;
	
	@Column(name="base_comprobante")
	private double baseComprobante;
	
	@Column(name="igv_comprobante")
	private double igvComprobante;
	
	@Column(name="tot_comprobante")
	private double totComprobante;

	public int getIdComprobante() {
		return idComprobante;
	}

	public void setIdComprobante(int idComprobante) {
		this.idComprobante = idComprobante;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFecComprobante() {
		return fecComprobante;
	}

	public void setFecComprobante(Date fecComprobante) {
		this.fecComprobante = fecComprobante;
	}

	public double getBaseComprobante() {
		return baseComprobante;
	}

	public void setBaseComprobante(double baseComprobante) {
		this.baseComprobante = baseComprobante;
	}

	public double getIgvComprobante() {
		return igvComprobante;
	}

	public void setIgvComprobante(double igvComprobante) {
		this.igvComprobante = igvComprobante;
	}

	public double getTotComprobante() {
		return totComprobante;
	}

	public void setTotComprobante(double totComprobante) {
		this.totComprobante = totComprobante;
	}	
}
