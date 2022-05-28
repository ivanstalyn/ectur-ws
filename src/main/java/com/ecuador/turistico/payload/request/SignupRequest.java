package com.ecuador.turistico.payload.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;

import com.ecuador.turistico.model.DetalleCatalogo;
import com.ecuador.turistico.model.Empresa;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignupRequest implements Serializable{
	

	    private static final long serialVersionUID = 1L;
	    private String username;
	    @Email
	    private String email;  
	    private String password;
		private String nombres;
		private String apellidos;
		private String identificacion;
		private String telefono;
		private Date fechaNacimiento;
		private DetalleCatalogo rol;
		private DetalleCatalogo genero;
		private Empresa empresa;
		private String foto;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
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
		public Date getFechaNacimiento() {
			return fechaNacimiento;
		}
		public void setFechaNacimiento(Date fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
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
		public String getFoto() {
			return foto;
		}
		public void setFoto(String foto) {
			this.foto = foto;
		}

	
}
