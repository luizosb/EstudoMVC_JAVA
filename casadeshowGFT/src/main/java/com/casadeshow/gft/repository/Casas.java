package com.casadeshow.gft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casadeshow.gft.model.Eventos;

public interface Casas extends JpaRepository<Eventos, Long> {

}
