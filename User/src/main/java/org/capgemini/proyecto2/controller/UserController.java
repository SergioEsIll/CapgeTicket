package org.capgemini.proyecto2.controller;

import java.util.List;

import org.capgemini.proyecto2.model.User;
import org.capgemini.proyecto2.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Validated
@RequestMapping("/api/v1/users")
@Tag(name = "user", description = "Users API")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAllUsers() {
		logger.info("*** Devolviendo el listado de usuarios ***");
		return userService.findAll();
	}

}
