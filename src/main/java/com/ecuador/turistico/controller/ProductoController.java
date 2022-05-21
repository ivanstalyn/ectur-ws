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

import com.ecuador.turistico.model.Producto;
import com.ecuador.turistico.payload.request.PaqueteTurisiticoRequest;
import com.ecuador.turistico.repository.ProductoRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("")
public class ProductoController {
	
	@Autowired
	ProductoRepository productoRepository;

	
	@GetMapping("/producto")
	public ResponseEntity<List<Producto>> getAll() {
		try {
			List<Producto> productos = new ArrayList<Producto>();
			productoRepository.findAll().forEach(productos::add);
			if (productos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(productos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@GetMapping("/producto/{id}")
	public ResponseEntity<Producto> getPaqueteTuristico(@PathVariable("id") int id) {
		Optional<Producto> producto = productoRepository.findById(id);
		if (producto.isPresent()) {
			return new ResponseEntity<>(producto.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}
