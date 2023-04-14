package org.capgemini.proyecto2.controller;

import java.util.List;
import java.util.Optional;

import org.capgemini.proyecto2.model.Event;
import org.capgemini.proyecto2.model.dto.EventDto;
import org.capgemini.proyecto2.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/events")
@Tag(name = "event", description = "Events API")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {

	private static final Logger logger = LoggerFactory.getLogger(EventController.class);

	@Autowired
	EventService eventService;

	@Operation(summary = "Devuelve el listado eventos", description = "Muestra el listado completo de eventos", tags = {
			"event" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Listado de usuarios mostrado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			@ApiResponse(responseCode = "400", description = "Listado de eventos no encontrado", content = @Content), })
	@GetMapping
	public List<EventDto> listEvents() {
		logger.info("*** Devolviendo el listado de eventos ***");
		return EventDto.toDto(eventService.findAll());
	}

	@Operation(summary = "Añadir nuevo evento", description = "Añadir nuevo evento")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Evento creado correctamente"),
			@ApiResponse(responseCode = "400", description = "Entrada no válida"),
			@ApiResponse(responseCode = "409", description = "El evento ya existe") })
	@PostMapping
	public EventDto addEvent(@RequestBody Event event) {
		logger.info("*** Creando el evento " + event.getId() + " ***");
		return EventDto.toDto(eventService.save(event));
	}
	
	@PutMapping
	public EventDto updateEvent(@RequestBody Event event) {
		logger.info("*** Modificando el evento " + event.getId() + " ***");
		return EventDto.toDto(eventService.update(event));
	}
	
	@DeleteMapping("/{id}")
	public void deleteEvent(@RequestParam int id) {
		logger.info("*** Borrando el evento " + id + " ***");
		eventService.deleteById(id);
		logger.info("*** Uusuario " + id + " Borrado ***");
	}
	
	@GetMapping("/{id}")
	public Optional<EventDto> getEvent(@RequestParam int id) {
		logger.info("*** Buscando el evento " + id + " ***");
		return Optional.ofNullable(EventDto.toDto((eventService.findById(id)).get()));
	}

}
