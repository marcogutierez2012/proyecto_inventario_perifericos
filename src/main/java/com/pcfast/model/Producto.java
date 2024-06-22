package com.pcfast.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_producto")
public class Producto {
	
	@Id
	@Column(name="id_producto")
	private int idProducto;
	
	@ManyToOne
	@JoinColumn(name="idTipoProducto")
	private TipoProducto tipoproducto;
	
	@Column(name="des_producto")
	private String desProducto;
	
	@Column(name="cant_producto")
	private int cantProducto;
	
	@Column(name="pre_producto")
	private double preProducto;

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public TipoProducto getTipoproducto() {
		return tipoproducto;
	}

	public void setTipoproducto(TipoProducto tipoproducto) {
		this.tipoproducto = tipoproducto;
	}

	public String getDesProducto() {
		return desProducto;
	}

	public void setDesProducto(String desProducto) {
		this.desProducto = desProducto;
	}

	public int getCantProducto() {
		return cantProducto;
	}

	public void setCantProducto(int cantProducto) {
		this.cantProducto = cantProducto;
	}

	public double getPreProducto() {
		return preProducto;
	}

	public void setPreProducto(double preProducto) {
		this.preProducto = preProducto;
	}
}
