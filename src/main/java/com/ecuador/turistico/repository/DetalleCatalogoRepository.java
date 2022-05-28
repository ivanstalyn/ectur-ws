package com.ecuador.turistico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecuador.turistico.model.DetalleCatalogo;

@Repository
public interface DetalleCatalogoRepository extends JpaRepository<DetalleCatalogo, Integer> {
	
	Optional<DetalleCatalogo> findByNombre(String username);	

	
}
	