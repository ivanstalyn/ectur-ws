package com.ecuador.turistico.model;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "usuario",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") 
	})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Usuario implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	@NotNull
	@Size(max = 20)
	@Column(name = "nombres")
	private String nombres;
	
	@NotNull
	@Size(max = 20)
	@Column(name = "apellidos")
	private String apellidos;
	
	@Size(max = 10)
	@Column(name = "identificacion")
	private String identificacion;
	
	@Size(max = 10)
	@Column(name = "telefono")
	private String telefono;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "email")
	private String email;
	
	@Column(name = "foto")
	private String foto;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "org.hibernate.type.ImageType")
	private byte[] image;
	
	@NotNull
	@Size(max = 120)
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Size(max = 20)
	@Column(name = "username")
	private String username;
	
	@Column(name = "fec_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@NotNull
	@Column(name = "fec_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_id")
	@JsonIgnore
	private DetalleCatalogo rol;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(name = "genero_id")
	@JsonIgnore
	private DetalleCatalogo genero;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(name = "empresa_id")
	@JsonIgnore
	private Empresa empresa;
	
	@OneToMany(cascade = CascadeType.DETACH,mappedBy = "usuario", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Solicitud>listaSolicitudes = new ArrayList<Solicitud>();

	public Usuario setDatosNuevos(String nombres2, String apellidos2, String identificacion2, String telefono2,
			String email2, String password2, String username2, Date fechaNacimiento2, LocalDateTime localDateTime, DetalleCatalogo rol, DetalleCatalogo genero, Empresa empresa, String foto) {
		this.nombres=nombres2;
		this.apellidos=apellidos2;
		this.identificacion=identificacion2;
		this.telefono=telefono2;
		this.email= email2;
		this.password=password2;
		this.username= username2;
		this.fechaNacimiento=fechaNacimiento2;
		this.fechaCreacion= new Date();
		this.rol=rol;
		this.genero= genero;
		this.empresa= empresa;
		this.image=foto!=null ? foto.getBytes(): null;
		return this;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		if (foto== null || foto.isEmpty())
			return "http://ectur.php.ec/imagenes/usuarios/user.png";
		else
			return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public DetalleCatalogo getRol() {
		return rol;
	}

	public void setRol(DetalleCatalogo rol) {
		this.rol = rol;
	}

	public DetalleCatalogo getGenero() {
		return genero;
	}

	public void setGenero(DetalleCatalogo genero) {
		this.genero = genero;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Solicitud> getListaSolicitudes() {
		return listaSolicitudes;
	}

	public void setListaSolicitudes(List<Solicitud> listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}

	
}
