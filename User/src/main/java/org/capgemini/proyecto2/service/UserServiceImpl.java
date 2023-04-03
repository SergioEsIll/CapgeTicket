package org.capgemini.proyecto2.service;

import java.util.List;

import org.capgemini.proyecto2.model.User;
import org.capgemini.proyecto2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
