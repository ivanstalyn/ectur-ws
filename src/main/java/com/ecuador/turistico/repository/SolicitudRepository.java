package com.ecuador.turistico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecuador.turistico.model.Solicitud;
import com.ecuador.turistico.model.Usuario;

@Repository
public interface SolicitudRepository  extends JpaRepository<Solicitud, Integer> {

	
	@Query("SELECT r FROM Solicitud r WHERE r.usuario = ?1")
	public List<Solicitud> fetchSolicitudByUsuario(Usuario usuario);
}
