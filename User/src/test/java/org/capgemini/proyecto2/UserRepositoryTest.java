package org.capgemini.proyecto2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.capgemini.proyecto2.model.User;
import org.capgemini.proyecto2.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void should_find_users_if_repository_is_not_empty() {
		List<User> users = userRepository.findAll();
		assertThat(users).isNotNull();
		assertThat(users).isNotEmpty();
	}
	
}
