package org.capgemini.proyecto2.model.dto;

import java.io.Serializable;

import org.capgemini.proyecto2.model.Ticket;
import org.springframework.beans.BeanUtils;

public class TicketDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double price;

	public TicketDto() {
		super();
	}

	public TicketDto(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public static TicketDto toDto(Ticket ticket) {
		TicketDto ticketDto = new TicketDto();
		BeanUtils.copyProperties(ticket, ticketDto);
		return ticketDto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
