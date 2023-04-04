package org.capgemini.proyecto2.service;

import org.capgemini.proyecto2.model.Card;
import org.capgemini.proyecto2.response.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

	public PaymentResponse payTicket(Card card);

}
