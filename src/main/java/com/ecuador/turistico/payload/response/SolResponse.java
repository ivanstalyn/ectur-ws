package com.ecuador.turistico.payload.response;

import java.util.Date;

import lombok.Data;

@Data
public class SolResponse {

	private Date fechaInicioEvento;
	private Date fechaFinalEvento;
	private int idProducto;
	private String nombreProducto;
	private String descripcionProducto;
	private Double precioProducto;
	
	public SolResponse(Date fechaInicioEvento, Date fechaFinalEvento, int idProducto, String nombreProducto,
			String descripcionProducto, Double precioProducto) {
		super();
		this.fechaInicioEvento = fechaInicioEvento;
		this.fechaFinalEvento = fechaFinalEvento;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.precioProducto = precioProducto;
	}

	
	
}
