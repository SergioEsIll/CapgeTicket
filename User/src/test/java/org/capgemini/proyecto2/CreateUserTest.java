package org.capgemini.proyecto2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class CreateUserTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testAddUser() throws Exception {
		// Crear el objeto JSON con la información del usuario
		String jsonUser = "{\"name\":\"John\",\"email\":\"john@example.com\"}";

		// Realizar la petición POST al endpoint /addUser con el objeto JSON como cuerpo
		mockMvc.perform(
				MockMvcRequestBuilders.post("/addUser").contentType(MediaType.APPLICATION_JSON).content(jsonUser))
				// Verificar que la petición ha sido exitosa y que la respuesta tiene el código
				// HTTP 201
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}
}
