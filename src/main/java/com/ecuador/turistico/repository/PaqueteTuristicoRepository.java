package com.ecuador.turistico.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecuador.turistico.model.PaqueteTuristico;

@Repository
public interface PaqueteTuristicoRepository extends JpaRepository<PaqueteTuristico, Long> {
	
	Optional<PaqueteTuristico> findByNombre(String username);	
	
	//@Query("select u from PaqueteTuristico u where u.nombre like '%'+'searchName'+'%' or u.descripcion like '%'+'%searchName%'+'%'")
	//List<PaqueteTuristico> findPaqueteTuristico(@Param("searchName") String searchName);
	
}
	