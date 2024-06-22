package com.pcfast.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_tipo_comprobante")
public class TipoComprobante {

	@Id
	@Column(name="id_tipo_comprobante")
	private int idTipoComprobante;
	
	@Column(name="des_tipo_comprobante")
	private String desTipoComprobante;

	public int getIdTipoComprobante() {
		return idTipoComprobante;
	}

	public void setIdTipoComprobante(int idTipoComprobante) {
		this.idTipoComprobante = idTipoComprobante;
	}

	public String getDesTipoComprobante() {
		return desTipoComprobante;
	}

	public void setDesTipoComprobante(String desTipoComprobante) {
		this.desTipoComprobante = desTipoComprobante;
	}
}
