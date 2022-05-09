package com.ecuador.turistico.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecuador.turistico.model.PaqueteTuristico;
import com.ecuador.turistico.payload.request.PaqueteTurisiticoRequest;
import com.ecuador.turistico.payload.request.RegistroPaqueteTurisiticoRequest;
import com.ecuador.turistico.repository.PaqueteTuristicoRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class PaqueteTuristicoController {
	
	@Autowired
	PaqueteTuristicoRepository paqueteTuristicoRepository;

	
	@GetMapping("/paqueteTuristico")
	public ResponseEntity<List<PaqueteTuristico>> getAll() {
		try {
			List<PaqueteTuristico> empresas = new ArrayList<PaqueteTuristico>();
			paqueteTuristicoRepository.findAll().forEach(empresas::add);
			if (empresas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(empresas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@GetMapping("/paqueteTuristico/{id}")
	public ResponseEntity<PaqueteTuristico> getPaqueteTuristico(@PathVariable("id") long id) {
		Optional<PaqueteTuristico> empresaData = paqueteTuristicoRepository.findById(id);
		if (empresaData.isPresent()) {
			return new ResponseEntity<>(empresaData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/paqueteTuristico")
	public ResponseEntity<PaqueteTuristico> createPaqueteTuristico(@RequestBody PaqueteTurisiticoRequest paqueteTurisiticoRequest) {
		try {
			PaqueteTuristico paquete = paqueteTuristicoRepository.save(new PaqueteTuristico(paqueteTurisiticoRequest.getNombre(),
					paqueteTurisiticoRequest.getDescripcion(), Double.valueOf(paqueteTurisiticoRequest.getCosto()),paqueteTurisiticoRequest.getEstado(), paqueteTurisiticoRequest.getFoto(), paqueteTurisiticoRequest.getFechaInicio(), paqueteTurisiticoRequest.getFechaFin()) );
			return new ResponseEntity<>(paquete, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/paqueteTuristico/{id}")
	public ResponseEntity<PaqueteTuristico> updatePaqueteTuristico(@PathVariable("id") long id, @RequestBody PaqueteTurisiticoRequest paqueteTurisiticoRequest) {
		Optional<PaqueteTuristico> paqueteTuristico = paqueteTuristicoRepository.findById(id);

		if (paqueteTuristico.isPresent()) {
			PaqueteTuristico _paqueteTuristico = paqueteTuristico.get();
			_paqueteTuristico.setNombre(paqueteTurisiticoRequest.getNombre());
		    _paqueteTuristico.setDescripcion(paqueteTurisiticoRequest.getDescripcion());
		    _paqueteTuristico.setCosto(paqueteTurisiticoRequest.getCosto());
		    _paqueteTuristico.setImage(paqueteTurisiticoRequest.getFoto().getBytes());
		    _paqueteTuristico.setEstado(paqueteTurisiticoRequest.getEstado());
			return new ResponseEntity<>(paqueteTuristicoRepository.save(_paqueteTuristico), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/paqueteTuristico/{id}")
	public ResponseEntity<HttpStatus> deleteEmpresa(@PathVariable("id") long id) {
		try {
			paqueteTuristicoRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	@PostMapping("/registroPaqueteTuristico")
	public ResponseEntity<PaqueteTuristico> registroPaqueteTuristico(@RequestBody RegistroPaqueteTurisiticoRequest paqueteTurisiticoRequest) {
		try {
			//PaqueteTuristico paquete = paqueteTuristicoRepository.save(new PaqueteTuristico(paqueteTurisiticoRequest.getNombre(),
			//		paqueteTurisiticoRequest.getDescripcion(), Double.valueOf(paqueteTurisiticoRequest.getCosto()),paqueteTurisiticoRequest.getEstado(), paqueteTurisiticoRequest.getFoto(), paqueteTurisiticoRequest.getFechaInicio(), paqueteTurisiticoRequest.getFechaFin()) );
			return new ResponseEntity<>(null , HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	


}
