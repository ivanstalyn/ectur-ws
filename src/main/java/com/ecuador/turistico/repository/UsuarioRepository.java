package com.ecuador.turistico.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecuador.turistico.model.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario> findByUsername(String username);
	
	Optional<Usuario> findByUsernameAndPassword(String username, String password);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	
	@Query("select u from Usuario u where u.nombres like '%'+'searchName'+'%' or u.apellidos like '%'+'%searchName%'+'%' or u.identificacion  like '%'+'searchName'+'%'")
	List<Usuario> findUsersBySearchName(@Param("searchName") String searchName);
	
}
	