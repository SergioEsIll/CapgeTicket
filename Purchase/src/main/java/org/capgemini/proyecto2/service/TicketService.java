package org.capgemini.proyecto2.service;

import java.util.List;

import org.capgemini.proyecto2.model.Ticket;

public interface TicketService {

	/**
	 * Recupera los registro de los tickets que existan en la bbdd
	 * 
	 * @return listado de tickets
	 */
	public List<Ticket> findAll();

	/**
	 * Guarda un ticket en bbdd
	 * 
	 * @param ticket
	 * @return
	 */
	public Ticket save(Ticket ticket);
}
