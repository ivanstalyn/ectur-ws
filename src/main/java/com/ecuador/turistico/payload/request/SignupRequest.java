package com.ecuador.turistico.payload.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ecuador.turistico.model.DetalleCatalogo;
import com.ecuador.turistico.model.Empresa;
import com.ecuador.turistico.model.Solicitud;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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


}
