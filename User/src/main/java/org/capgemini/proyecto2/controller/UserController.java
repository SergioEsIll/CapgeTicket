package org.capgemini.proyecto2.controller;

import java.util.List;
import java.util.Optional;

import org.capgemini.proyecto2.model.User;
import org.capgemini.proyecto2.model.dto.UserDto;
import org.capgemini.proyecto2.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Validated
@RequestMapping("/api/v1/users")
@Tag(name = "user", description = "Users API")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Operation(summary = "Devuelve el listado usuarios", description = "Muestra el listado completo de usuarios", tags = {
			"user" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Listado de usuarios mostrado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) }),
			@ApiResponse(responseCode = "400", description = "Listado de usuarios no encontrado", content = @Content), })
	@GetMapping
	public List<UserDto> getAllUsers() {
		logger.info("*** Devolviendo el listado de usuarios ***");
		return UserDto.toDto(userService.findAll());
	}

	@Operation(summary = "Añadir nuevo usuario", description = "Añadir nuevo usuario")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Usuario creado correctamente"),
			@ApiResponse(responseCode = "400", description = "Entrada no válida"),
			@ApiResponse(responseCode = "409", description = "El usuario ya existe") })
	@PostMapping
	public UserDto addUser(@RequestBody User user) {
		logger.info("*** Creando el usuario " + user.getId() + " ***");
		return UserDto.toDto(userService.save(user));
	}
	
	@PutMapping
	public UserDto updateUser(@RequestBody User user) {
		logger.info("*** Modificando el usuario " + user.getId() + " ***");
		return UserDto.toDto(userService.update(user));
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		logger.info("*** Borrando el usuario " + id + " ***");
		userService.deleteById(id);
		logger.info("*** Uusuario " + id + " Borrado ***");
	}
	
	@GetMapping("/{id}")
	public Optional<UserDto> getUser(@PathVariable int id) {
		logger.info("*** Buscando el usuario " + id + " ***");
		return Optional.ofNullable(UserDto.toDto((userService.findById(id)).get()));
	}

}
