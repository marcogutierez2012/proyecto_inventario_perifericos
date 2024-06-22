package com.pcfast.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_cliente")
public class Cliente {

	@Id
	@Column(name="id_cliente")
	private int idCliente;
	
	@Column(name="nom_cliente")
	private String nomCliente;
	
	@Column(name="doc_cliente")
	private String docCliente;
	
	@Column(name="dir_cliente")
	private String dirCliente;
	
	@Column(name="tel_cliente")
	private String telCliente;
	
	@ManyToOne
	@JoinColumn(name="idTipoCliente")
	private TipoCliente tipocliente;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public String getDocCliente() {
		return docCliente;
	}

	public void setDocCliente(String docCliente) {
		this.docCliente = docCliente;
	}

	public String getDirCliente() {
		return dirCliente;
	}

	public void setDirCliente(String dirCliente) {
		this.dirCliente = dirCliente;
	}

	public String getTelCliente() {
		return telCliente;
	}

	public void setTelCliente(String telCliente) {
		this.telCliente = telCliente;
	}

	public TipoCliente getTipocliente() {
		return tipocliente;
	}

	public void setTipocliente(TipoCliente tipocliente) {
		this.tipocliente = tipocliente;
	}
}
