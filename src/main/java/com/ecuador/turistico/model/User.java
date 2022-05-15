package com.ecuador.turistico.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") 
	})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "foto")
	private String foto;
	
	@Size(max = 20)
	@Column(name = "nombres")
	private String nombres;
	
	@Size(max = 20)
	@Column(name = "apellidos")
	private String apellidos;
	
	@Size(max = 10)
	@Column(name = "identificacion")
	private String identificacion;
	
	@Size(max = 10)
	@Column(name = "telefono")
	private String telefono;
	
	@NotBlank
	@Size(max = 50)
	@Column(name = "email")
	private String email;
	
	@NotBlank
	@Size(max = 120)
	@Column(name = "password")
	private String password;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Column(name = "fec_nac")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "usuario", orphanRemoval = true)
	private List<RegistroPaqueteTuristico> registroPaquetesTuristicos = new ArrayList<>();
	
	

	
	@Transient
	private Set<String> role;
	
	public User setDatosNuevos(String nombres,  String apellidos, String identificacion,
			 String telefono, String email,
			 String password, String username,
			 Date fechaNacimiento) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.identificacion = identificacion;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.username = username;
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}

	public User(String nombres, String apellidos, String email, String password, String username) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.username = username;
	}
	
	public User() {
	}
	
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<RegistroPaqueteTuristico> getRegistroPaquetesTuristicos() {
		return registroPaquetesTuristicos;
	}

	public void setRegistroPaquetesTuristicos(List<RegistroPaqueteTuristico> registroPaquetesTuristicos) {
		this.registroPaquetesTuristicos = registroPaquetesTuristicos;
	}
	
}
