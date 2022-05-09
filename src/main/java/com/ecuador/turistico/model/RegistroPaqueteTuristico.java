package com.ecuador.turistico.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "registro_paquete_turistico")
public class RegistroPaqueteTuristico {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@NotNull
	@Column(name = "fec_inicio")
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	
	
	@NotNull
	@Column(name = "fec_fin")
	@Temporal(TemporalType.DATE)
	private Date fechaFin;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private User usuario;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="paqueteTuristico_id")
	private PaqueteTuristico paqueteTuristico;
	
	
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
