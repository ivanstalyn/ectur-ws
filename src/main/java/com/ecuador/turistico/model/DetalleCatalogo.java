package com.ecuador.turistico.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "detalle_catalogo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DetalleCatalogo implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 45)
	private String nombre;
	
	@OneToMany(cascade = CascadeType.REFRESH,mappedBy = "rol", fetch = FetchType.LAZY)
	@JsonIgnore 
	private List<Usuario>listaUsuariosPorRol = new ArrayList<Usuario>();
	
	@OneToMany(cascade = CascadeType.REFRESH,mappedBy = "genero", fetch = FetchType.LAZY)
	@JsonIgnore 
	private List<Usuario>listaUsuariosPorGenero = new ArrayList<Usuario>();
	
	@OneToMany(cascade = CascadeType.REFRESH,mappedBy = "estado", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Solicitud>listaSolicitudPorEstado = new ArrayList<Solicitud>();
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "catalogo_id")
	@JsonIgnore
	private Catalogo catalogo;



	@Override
	public String toString() {
		return "DetalleCatalogo [id=" + id + ", nombre=" + nombre + ", listaUsuariosPorRol=" + listaUsuariosPorRol
				+ ", listaUsuariosPorGenero=" + listaUsuariosPorGenero + ", listaSolicitudPorEstado="
				+ listaSolicitudPorEstado + ", catalogo=" + catalogo + "]";
	}
	
	
}