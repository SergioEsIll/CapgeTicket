package org.capgemini.proyecto2.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		if(userRepository.existsById(user.getId())) {
				return userRepository.save(user);
		}
		return null;
	}

	@Override
	public void deleteById(int id) {
		if(userRepository.existsById(id)) {
			userRepository.deleteById(id);;
		}
	}

	@Override
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}

}
