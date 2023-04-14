package org.capgemini.proyecto2.controller;

import org.capgemini.proyecto2.model.Card;
import org.capgemini.proyecto2.model.Ticket;
import org.capgemini.proyecto2.response.PaymentResponse;
import org.capgemini.proyecto2.service.PaymentService;
import org.capgemini.proyecto2.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/payments")
@Tag(name = "payments", description = "Payments API")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@Autowired
	TicketService ticketService;
	
	@PostMapping
	@CircuitBreaker(name = "purchaseCB", fallbackMethod = "fallbackPayTicket")
	public ResponseEntity<PaymentResponse> payTicket(@RequestBody Card card) {

		PaymentResponse result = paymentService.payTicket(card);

		result.setTimestamp(null);

		switch (result.getStatus()) {
		case "200.0001": {
			result.setStatus("200");

			Ticket ticket = new Ticket();
			ticket.setName(result.getInfo().getNombreTitular());
			ticket.setPrice(result.getInfo().getCantidad());
			ticketService.save(ticket);

			result.setInfoAdicional(null);

			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		case "400.0001":
		case "400.0002":
		case "400.0003": {
			result.setInfoAdicional(null);
			result.setStatus("400");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		case "500.0001": {
			result.setStatus("500");
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		default:
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	public ResponseEntity<?> fallbackPayTicket(@RequestBody Card card, RuntimeException e){
    	System.out.println("INFO: FallbackpayTickets");
    	return new ResponseEntity<>("Plataforma de pago no disponible, vuelva mas tarde", HttpStatus.OK); 
    }

}
