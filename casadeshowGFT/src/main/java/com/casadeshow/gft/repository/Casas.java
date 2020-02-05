package com.casadeshow.gft.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casadeshow.gft.model.Eventos;

public interface Casas extends JpaRepository<Eventos, Long> {
	
	public List<Eventos> findByBandaContaining(String banda);

	

}
