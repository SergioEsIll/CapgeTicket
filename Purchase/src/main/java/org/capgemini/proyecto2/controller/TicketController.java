package org.capgemini.proyecto2.controller;

import java.util.List;

import org.capgemini.proyecto2.model.Ticket;
import org.capgemini.proyecto2.model.dto.TicketDto;
import org.capgemini.proyecto2.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

	private static final Logger logger = LoggerFactory.getLogger(TicketController.class);

	@Autowired
	TicketService serviceTicket;

	@Operation(summary = "Devuelve el listado tickets", description = "Muestra el listado completo de tickets", tags = {
			"ticket" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Listado de tickets mostrado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Ticket.class)) }),
			@ApiResponse(responseCode = "400", description = "Listado de tickets no encontrado", content = @Content), })
	@GetMapping
	public List<TicketDto> listTickets() {
		logger.info("*** Devolviendo el listado de tickets ***");
		return TicketDto.toDto(serviceTicket.findAll());
	}

	@Operation(summary = "Añadir nuevo ticket", description = "Añadir nuevo ticket")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Ticket creado correctamente"),
			@ApiResponse(responseCode = "400", description = "Entrada no válida"),
			@ApiResponse(responseCode = "409", description = "El ticket ya existe") })
	@PostMapping
	public TicketDto addTicket(@RequestBody Ticket ticket) {
		logger.info("*** Creando el ticket " + ticket.getId() + " ***");
		return TicketDto.toDto(serviceTicket.save(ticket));
	}
}
