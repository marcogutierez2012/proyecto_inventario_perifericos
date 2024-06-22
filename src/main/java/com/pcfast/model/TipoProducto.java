package com.pcfast.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_tipo_producto")
public class TipoProducto {

	@Id
	@Column(name="id_tipo_producto")
	private int idTipoProducto;
	
	@Column(name="des_tipo_producto")
	private String desTipoProducto;

	public int getIdTipoProducto() {
		return idTipoProducto;
	}

	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	public String getDesTipoProducto() {
		return desTipoProducto;
	}

	public void setDesTipoProducto(String desTipoProducto) {
		this.desTipoProducto = desTipoProducto;
	}
}
