package org.capgemini.proyecto2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.capgemini.proyecto2.model.User;
import org.capgemini.proyecto2.repository.UserRepository;
import org.capgemini.proyecto2.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
    private UserServiceImpl userService;

	private User user;

	@BeforeEach
	public void setup() {
		user = new User(1,"Bruce","Banner","bruce@gmail.com","hulk",null);
	}

	@Test
	public void given_users_list_when_get_all_users_then_return_users_list() {		
		// Given
		User user1 = new User(2,"Tony","Stark","tony@gmail.com","jarvis",null);
		
		Mockito.when(userRepository.findAll()).thenReturn(List.of(user, user1));

		// When
		List<User> userList = userService.findAll();

		// Then
		assertThat(userList).isNotNull();
		assertThat(userList.size()).isEqualTo(2);
		assertThat(userList.get(0).getName()).isEqualTo("Bruce");
		assertThat(userList.get(1).getName()).isEqualTo("Tony");
	}
}
