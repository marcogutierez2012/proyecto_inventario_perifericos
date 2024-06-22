package com.pcfast.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_tipo_cliente")
public class TipoCliente {

	@Id
	@Column(name="id_tipo_cliente")
	private int idTipoCliente;
	
	@Column(name="des_tipo_cliente")
	private String desTipoCliente;

	public int getIdTipoCliente() {
		return idTipoCliente;
	}

	public void setIdTipoCliente(int idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}

	public String getDesTipoCliente() {
		return desTipoCliente;
	}

	public void setDesTipoCliente(String desTipoCliente) {
		this.desTipoCliente = desTipoCliente;
	}
}
