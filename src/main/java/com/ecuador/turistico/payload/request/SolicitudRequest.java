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

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public DetalleCatalogo getEstado() {
		return estado;
	}

	public void setEstado(DetalleCatalogo estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
		
}
