package org.capgemini.proyecto2.controller;

import java.util.List;

import org.capgemini.proyecto2.model.Event;
import org.capgemini.proyecto2.model.dto.EventDto;
import org.capgemini.proyecto2.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/events")
@Tag(name = "events", description = "Events API")
public class EventController {

	private static final Logger logger = LoggerFactory.getLogger(EventController.class);

	@Autowired
	EventService eventService;

	@GetMapping
	public List<EventDto> listEvents() {
		logger.info("*** Devolviendo el listado de eventos ***");
		return EventDto.toDto(eventService.findAll());
	}
	
	@PostMapping
	public EventDto addEvent(@RequestBody Event event) {
		logger.info("*** Creando el evento " + event.getId() + " ***");
		return EventDto.toDto(eventService.save(event));
	}

}
