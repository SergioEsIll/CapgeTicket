package org.capgemini.proyecto2.service;

import java.util.List;

import org.capgemini.proyecto2.model.Event;

public interface EventService {

	/**
	 * Recupera los registro de los eventos que existan en la bbdd
	 * 
	 * @return listado de eventos
	 */
	public List<Event> findAll();
	
	/**
	 * Guarda un evento en bbdd
	 * @param event
	 * @return
	 */
	public Event save(Event event);

}
