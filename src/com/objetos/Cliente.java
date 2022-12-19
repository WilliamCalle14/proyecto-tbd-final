package com.objetos;

public class Cliente {
	private int ciCliente;
	private String nombreCliente;
	private String direccionCliente;
	private String tipoCliente;
	private String[] telefonos;
	
	public Cliente(int ciCliente, String nombreCliente, String direccionCliente, String tipoCliente,
			String[] telefonos) {
		this.ciCliente = ciCliente;
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.tipoCliente = tipoCliente;
		this.telefonos = telefonos;
	}

	public int getCiCliente() {
		return ciCliente;
	}

	public void setCiCliente(int ciCliente) {
		this.ciCliente = ciCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String[] getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(String[] telefonos) {
		this.telefonos = telefonos;
	}
	
	
}
