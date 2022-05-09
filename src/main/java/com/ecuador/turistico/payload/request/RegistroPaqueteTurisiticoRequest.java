package com.ecuador.turistico.payload.request;

import java.io.Serializable;
import java.util.Date;

import com.ecuador.turistico.model.PaqueteTuristico;
import com.ecuador.turistico.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistroPaqueteTurisiticoRequest implements Serializable{
	

	    private static final long serialVersionUID = 1L;
	    private long id;
	    private User usuario;
	    private PaqueteTuristico paqueteTuristico;  
		private Date fechaInicio;
		private Date fechaFin;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public User getUsuario() {
			return usuario;
		}
		public void setUsuario(User usuario) {
			this.usuario = usuario;
		}
		public PaqueteTuristico getPaqueteTuristico() {
			return paqueteTuristico;
		}
		public void setPaqueteTuristico(PaqueteTuristico paqueteTuristico) {
			this.paqueteTuristico = paqueteTuristico;
		}
		public Date getFechaInicio() {
			return fechaInicio;
		}
		public void setFechaInicio(Date fechaInicio) {
			this.fechaInicio = fechaInicio;
		}
		public Date getFechaFin() {
			return fechaFin;
		}
		public void setFechaFin(Date fechaFin) {
			this.fechaFin = fechaFin;
		}
}
