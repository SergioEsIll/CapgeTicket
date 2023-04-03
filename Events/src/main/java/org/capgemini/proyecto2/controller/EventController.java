package org.capgemini.proyecto2.controller;

import java.util.List;

import org.capgemini.proyecto2.model.Event;
import org.capgemini.proyecto2.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

	private static final Logger log = LoggerFactory.getLogger(EventController.class);

	@Autowired
	EventService eventService;

	@GetMapping
	public List<Event> listEvents() {
		return eventService.findAll();
	}

}
