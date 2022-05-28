package com.ecuador.turistico.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsuarionamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecuador.turistico.model.Empresa;
import com.ecuador.turistico.model.Usuario;
import com.ecuador.turistico.payload.request.LoginRequest;
import com.ecuador.turistico.payload.request.SignupRequest;
import com.ecuador.turistico.payload.response.MessageResponse;
import com.ecuador.turistico.repository.DetalleCatalogoRepository;
//import com.ecuador.turistico.repository.RoleRepository;
import com.ecuador.turistico.repository.UsuarioRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@Autowired
	DetalleCatalogoRepository detalleCatalogoRepository;

	@PostConstruct
	void init() {
		// System.out.println("Pasando por el postconstructor del controlador de AUTH");
	}

	@GetMapping("/usuario/{userId}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable("userId") Integer userId) {
		Optional<Usuario> usuario = usuarioRepository.findById(userId);
		if (usuario.isPresent()) {
			return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/signin")
	public ResponseEntity<Usuario> signinUsuario(@Valid @RequestBody LoginRequest loginRequest) {

		Optional<Usuario> usuario = usuarioRepository.findByUsernameAndPassword(loginRequest.getUsername(),
				loginRequest.getPassword());
		if (usuario.isPresent()) {
			usuario.get().setPassword(null);
			usuario.get().setFoto(usuario.get().getImage() != null ? "http://ectur.php.ec/imagenes/usuarios/"+usuario.get().getId()+""+".jpg" : null);
			usuario.get().setImage(null);
			return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUsuario(@Valid @RequestBody SignupRequest signUpRequest) {
		
		//Empresa ;1
		//Rol 2
		//Genero Envia
		if (usuarioRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Usuarioname is already taken!"));
		}

		if (usuarioRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new usuario's account
		Usuario usuario = new Usuario().setDatosNuevos(signUpRequest.getNombres(), signUpRequest.getApellidos(),
				signUpRequest.getIdentificacion(), signUpRequest.getTelefono(), signUpRequest.getEmail(),
				signUpRequest.getPassword(), signUpRequest.getUsername(), signUpRequest.getFechaNacimiento(),
				LocalDateTime.now(), signUpRequest.getRol(), signUpRequest.getGenero(), signUpRequest.getEmpresa(),
				signUpRequest.getFoto());
		try {
			usuarioRepository.save(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage() + " " + e.getCause(), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(new MessageResponse("Usuario registered successfully!"));
	}

	@PutMapping("/actualizarUsuario/{userId}")
	public ResponseEntity<?> ActualizarRegisterUsuario(@Valid @RequestBody SignupRequest signUpRequest,
			@PathVariable("userId") Integer userId) {
		if (!usuarioRepository.existsById(userId)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: User no exist!"));
		}

		Optional<Usuario> usuario = usuarioRepository.findById(userId);
		Usuario usuario2 = null;
		if (usuario.get() != null) {
			usuario2 = usuario.get();
			usuario2.setApellidos(signUpRequest.getApellidos());
			usuario2.setPassword(signUpRequest.getPassword());
			usuario2.setFechaNacimiento(signUpRequest.getFechaNacimiento());
			usuario2.setIdentificacion(signUpRequest.getIdentificacion());
			usuario2.setTelefono(signUpRequest.getTelefono());
			usuario2.setNombres(signUpRequest.getNombres());
			usuario2.setUsername(signUpRequest.getUsername());
			usuario2.setEmail(signUpRequest.getEmail());
			usuario2.setEmpresa(signUpRequest.getEmpresa());
			usuario2.setGenero(signUpRequest.getGenero());
			usuario2.setRol(signUpRequest.getRol());
			usuario2.setImage(signUpRequest.getFoto() != null ? signUpRequest.getFoto().getBytes() : null);
			try {
				usuarioRepository.save(usuario2);
				usuario.get().setFoto(signUpRequest.getFoto() != null ? "http://ectur.php.ec/imagenes/usuarios/"+usuario2.getId()+""+".jpg" : null);
				usuario2.setImage(null);
				return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(e.getMessage() + " " + e.getCause(), HttpStatus.BAD_REQUEST);

			}

		}
		return ResponseEntity.badRequest().body(new MessageResponse("Error: Usuarioname no exist!"));

	}

}
