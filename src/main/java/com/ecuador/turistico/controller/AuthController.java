package com.ecuador.turistico.controller;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecuador.turistico.model.User;
import com.ecuador.turistico.payload.request.SignupRequest;
import com.ecuador.turistico.payload.response.MessageResponse;
//import com.ecuador.turistico.repository.RoleRepository;
import com.ecuador.turistico.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
//	@Autowired
//	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

//	@Autowired
//	RoleRepository roleRepository;

//	@Autowired
//	PasswordEncoder encoder;


	
	@PostConstruct
	void init(){
		//System.out.println("Pasando por el postconstructor del controlador de AUTH");
	}


//	@PostMapping("/signin")
//	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//
//		Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		String jwt = jwtUtils.generateJwtToken(authentication);
//		
//		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
//		
//		List<String> roles = userDetails.getAuthorities().stream()
//				.map(item -> item.getAuthority())
//				.collect(Collectors.toList());
//
//		return ResponseEntity.ok(new JwtResponse(jwt, 
//												 userDetails.getId(), 
//												 userDetails.getUsername(), 
//												 userDetails.getEmail(), 
//												 roles));
//	}
	

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User().setDatosNuevos(	signUpRequest.getNombres(),
				signUpRequest.getApellidos(),
				signUpRequest.getIdentificacion(),
				signUpRequest.getTelefono(),
				signUpRequest.getEmail(),
				null,
//				encoder.encode(signUpRequest.getPassword()),
				signUpRequest.getUsername(), 
			    signUpRequest.getFechaNacimiento());

//		Set<String> strRoles = signUpRequest.getRole();
//		Set<Role> roles = new HashSet<>();
//
//		if (strRoles == null) {
//			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//			roles.add(userRole);
//		} else {
//			strRoles.forEach(role -> {
//				switch (role) {
//				case "admin":
//					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(adminRole);
//
//					break;
//				case "mod":
//					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(modRole);
//
//					break;
//				default:
//					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(userRole);
//				}
//			});
//		}
//
//		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	

	@PutMapping("/actualizarsSignup")
	public ResponseEntity<?> ActualizarRegisterUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (!userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username no exist!"));
		}


		Optional<User> user= userRepository.findByUsername(signUpRequest.getUsername());
		User usuario=null;
		if(user.get() != null) 
		{
			usuario=user.get();
			usuario=usuario.setDatosNuevos(signUpRequest.getNombres(),
				signUpRequest.getApellidos(),
				signUpRequest.getIdentificacion(),
				signUpRequest.getTelefono(),
				signUpRequest.getEmail(),
				null,
				//encoder.encode(signUpRequest.getPassword()),
				signUpRequest.getUsername(), 
			    signUpRequest.getFechaNacimiento());
			userRepository.save(usuario);
			return ResponseEntity.ok(new MessageResponse("User updated successfully!"));
		}
		return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username no exist!"));
	
	}
	

}
