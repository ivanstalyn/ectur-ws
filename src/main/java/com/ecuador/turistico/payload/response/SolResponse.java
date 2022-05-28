package com.ecuador.turistico.payload.response;

import java.util.Date;

import lombok.Data;


public class SolResponse {

	private Date fechaInicioEvento;
	private Date fechaFinalEvento;
	private int idProducto;
	private String nombreProducto;
	private String descripcionProducto;
	private Double precioProducto;
	private String message;
	
	public SolResponse(Date fechaInicioEvento, Date fechaFinalEvento, int idProducto, String nombreProducto,
			String descripcionProducto, Double precioProducto, String message) {
		super();
		this.fechaInicioEvento = fechaInicioEvento;
		this.fechaFinalEvento = fechaFinalEvento;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.precioProducto = precioProducto;
		this.message= message;
	}

	public Date getFechaInicioEvento() {
		return fechaInicioEvento;
	}

	public void setFechaInicioEvento(Date fechaInicioEvento) {
		this.fechaInicioEvento = fechaInicioEvento;
	}

	public Date getFechaFinalEvento() {
		return fechaFinalEvento;
	}

	public void setFechaFinalEvento(Date fechaFinalEvento) {
		this.fechaFinalEvento = fechaFinalEvento;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public Double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
