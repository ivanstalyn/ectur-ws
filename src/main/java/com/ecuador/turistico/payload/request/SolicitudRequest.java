package com.ecuador.turistico.payload.request;

import java.io.Serializable;
import java.util.Date;

import com.ecuador.turistico.model.DetalleCatalogo;
import com.ecuador.turistico.model.Producto;
import com.ecuador.turistico.model.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SolicitudRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -655333745792620017L;

	private String mensaje;
	
	private Date fechaInicioEvento;
	
	private Date fechaFinalEvento;
	
	private Date fechaCreacion;
	
	private Date fechaActualizacion;
	
	private DetalleCatalogo estado;
	
	private Usuario usuario;

	private Producto producto;
		
}
