package com.ecuador.turistico.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecuador.turistico.model.Solicitud;
import com.ecuador.turistico.model.Usuario;
import com.ecuador.turistico.payload.response.MessageResponse;
import com.ecuador.turistico.payload.response.SolResponse;
import com.ecuador.turistico.repository.SolicitudRepository;
import com.ecuador.turistico.repository.UsuarioRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("")
public class SolicitudController {
	
	
	@Autowired
	SolicitudRepository solicitudRepository;
	
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/solicitud")
	public ResponseEntity<List<Solicitud>> getAll() {
		try {
			List<Solicitud> solicitud = new ArrayList<Solicitud>();
			solicitudRepository.findAll().forEach(solicitud::add);
			if (solicitud.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(solicitud, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	@PostMapping("/solicitud")
	public ResponseEntity<Solicitud> solicitud(@RequestBody Solicitud solicitudRequest) {
		try {
			solicitudRequest.setFechaCreacion(new Date());
			return new ResponseEntity<>(solicitudRepository.save(solicitudRequest) , HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/solicitud/{usuarioId}")
	public ResponseEntity<MessageResponse> solicitudxUsuario(@PathVariable("usuarioId") Integer id) {
		MessageResponse mensaje= new MessageResponse();
		try {
			Optional<Usuario> user= usuarioRepository.findById(id);
			if(!user.isEmpty()) {
				List<SolResponse> solicitud =  solicitudRepository.fetchSolicitudByUsuario(user.get()).stream().map(sol-> 
				  new SolResponse(sol.getFechaInicioEvento(), sol.getFechaFinalEvento(), sol.getProducto().getId(), sol.getProducto().getNombre(), sol.getProducto().getDescripcion(), sol.getProducto().getPrecio())
			).collect(Collectors.toList());
				
				if (solicitud.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				mensaje.setRespuestaSol(solicitud);
				return new ResponseEntity<>(mensaje, HttpStatus.OK);
			}else {
				mensaje.setMessage("Usuario no Encontrado");
				return new ResponseEntity<>(mensaje , HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			mensaje.setMessage(e.getCause()+" "+e.getMessage());
			return new ResponseEntity<>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
