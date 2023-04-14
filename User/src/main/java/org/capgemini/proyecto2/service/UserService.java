package org.capgemini.proyecto2.service;

import java.util.List;
import java.util.Optional;

import org.capgemini.proyecto2.model.User;

public interface UserService {

	/**
	 * Devuelve la lista de usuarios disponible en BBDD
	 * 
	 * @return
	 */
	public List<User> findAll();

	/**
	 * Guarda un usuario en BBDD
	 * 
	 * @param user
	 * @return
	 */
	public User save(User user);

	/**
	 * Actualizar un usuario que ya existente en BBDD
	 * 
	 * @param user
	 * @return
	 */
	public User update(User user);

	/**
	 * Borrar un usuario ya existente en BBDD
	 * 
	 * @param id
	 */
	public void deleteById(int id);

	/**
	 * Buscar un usuario ya existente en BBDD
	 * 
	 * @param id
	 * @return
	 */
	public Optional<User> findById(int id);

}
