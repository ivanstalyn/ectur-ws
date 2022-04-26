package com.ecuador.turistico.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecuador.turistico.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	
	@Query("select u from User u where u.nombres like '%'+'searchName'+'%' or u.apellidos like '%'+'%searchName%'+'%' or u.identificacion  like '%'+'searchName'+'%'")
	List<User> findUsersBySearchName(@Param("searchName") String searchName);
	
}
	