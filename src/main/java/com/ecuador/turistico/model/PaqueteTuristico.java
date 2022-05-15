package com.ecuador.turistico.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "paquete_turistico")
public class PaqueteTuristico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	@Column(name = "nombre")
	private String nombre;
	
	@NotBlank
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "costo")
	private Double costo;
	
	@NotBlank
	@Column(name = "estado")
	private String estado;
	

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] image;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "paqueteTuristico", orphanRemoval = true)
	private List<RegistroPaqueteTuristico> registroPaquetesTuristicos = new ArrayList<>();
	

	public PaqueteTuristico( String nombre,  String descripcion,  Double costo,
			 String estado, String foto,  Date fechaInicio,  Date fechaFin) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costo = costo;
		this.estado = estado;
		this.image=foto.getBytes();
	}

	public PaqueteTuristico() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
