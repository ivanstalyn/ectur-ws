package com.ecuador.turistico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecuador.turistico.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	Optional<Producto> findByNombre(String username);	
	
	//@Query("select u from PaqueteTuristico u where u.nombre like '%'+'searchName'+'%' or u.descripcion like '%'+'%searchName%'+'%'")
	//List<PaqueteTuristico> findPaqueteTuristico(@Param("searchName") String searchName);
	
}
	