package com.casadeshow.gft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.casadeshow.gft.model.Eventos;
import com.casadeshow.gft.repository.Casas;
import com.casadeshow.gft.repository.filter.EventoFilter;

@Service
public class EventoService {
	
	@Autowired
	private Casas show;
	
	public void salvar(Eventos eventos ) {
		try {
			show.save(eventos);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido.");
		}
	}

	public void excluir(Long codigo) {
		show.deleteById(codigo);
		
	}

	public List<Eventos> filtrar(EventoFilter filtro){
		String  banda = filtro.getBanda()==null ? "" : filtro.getBanda();
		return show.findByBandaContaining(banda);
		
	}
	
}
