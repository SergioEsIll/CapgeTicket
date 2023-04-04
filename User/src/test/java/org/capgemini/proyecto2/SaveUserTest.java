package org.capgemini.proyecto2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.capgemini.proyecto2.model.User;
import org.capgemini.proyecto2.repository.UserRepository;
import org.capgemini.proyecto2.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SaveUserTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@Test
	void saveUser_validUser_savesUserToRepository() {
		// Configuración del repositorio mockeado
		User user = new User(1, "Bruce", "Banner", "bruce@gmail.com", "hulk", null);
		Mockito.when(userRepository.save(user)).thenReturn(user);

		// Llamada al método que se está probando
		User result = userService.save(user);

		// Verificación del resultado
		assertNotNull(result);
		assertEquals("testuser", result.getName());
		Mockito.verify(userRepository, Mockito.times(1)).save(user);
	}

}
