package org.capgemini.proyecto2.service;

import java.util.List;
import java.util.Optional;

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

	/**
	 * Actualizar un evento que ya existente en BBDD
	 * 
	 * @param user
	 * @return
	 */
	public Event update(Event user);

	/**
	 * Borrar un evento ya existente en BBDD
	 * 
	 * @param id
	 */
	public void deleteById(int id);

	/**
	 * Buscar un evento ya existente en BBDD
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Event> findById(int id);
}
