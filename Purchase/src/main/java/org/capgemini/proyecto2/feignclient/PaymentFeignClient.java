package org.capgemini.proyecto2.feignclient;

import org.capgemini.proyecto2.model.Card;
import org.capgemini.proyecto2.response.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment", url = "http://proyectorestbanco-env.eba-2xzwedvv.eu-west-3.elasticbeanstalk.com/")
public interface PaymentFeignClient {

	@PostMapping("/pasarela/compra")
	public PaymentResponse payTicket(@RequestBody Card card);

}
