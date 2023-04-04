package org.capgemini.proyecto2.service;

import java.util.List;

import org.capgemini.proyecto2.model.User;

public interface UserService {

	/**
	 * Devuelve la lista de usuarios disponible en BBDD
	 * @return
	 */
	public List<User> findAll();
	
	/**
	 * Guarda un usuario en BBDD
	 * @param user
	 * @return
	 */
	public User save(User user);

}
