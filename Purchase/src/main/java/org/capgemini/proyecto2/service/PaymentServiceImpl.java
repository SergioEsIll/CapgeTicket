package org.capgemini.proyecto2.service;

import org.capgemini.proyecto2.feignclient.PaymentFeignClient;
import org.capgemini.proyecto2.model.Card;
import org.capgemini.proyecto2.response.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentFeignClient paymentFeignClient;

	@Override
	public PaymentResponse payTicket(Card card) {
		return paymentFeignClient.payTicket(card);
	}

}
