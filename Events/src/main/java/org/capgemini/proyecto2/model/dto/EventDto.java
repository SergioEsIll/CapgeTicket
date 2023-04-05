package org.capgemini.proyecto2.model.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.capgemini.proyecto2.model.Event;
import org.springframework.beans.BeanUtils;

public class EventDto implements Serializable {

	/**
	 * Default serial version
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String shortDescription;
	private String extendedDescription;
	private Date dateEvent;
	private Date timeEvent;
	private double priceRange;
	private String rules;
	private String nameRoom;
	private String cityRoom;
	private String addressRoom;
	private String roomType;
	private int capacityRoom;

	public EventDto() {
		super();
	}

	public static EventDto toDto(Event event) {
		EventDto eventDto = new EventDto();

		// Copia todas las propiedades propias de java, entidades no
		BeanUtils.copyProperties(event, eventDto);

		return eventDto;
	}

	public static List<EventDto> toDto(List<Event> events) {
		return events.stream().map(e -> toDto(e)).collect(Collectors.toList());
	}

	public static Event toDao(EventDto eventDto) {
		Event event = new Event();

		BeanUtils.copyProperties(eventDto, event);

		return event;
	}

	public static List<Event> toDao(List<EventDto> eventsDto) {
		return eventsDto.stream().map(e -> toDao(e)).collect(Collectors.toList());
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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getExtendedDescription() {
		return extendedDescription;
	}

	public void setExtendedDescription(String extendedDescription) {
		this.extendedDescription = extendedDescription;
	}

	public Date getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}

	public Date getTimeEvent() {
		return timeEvent;
	}

	public void setTimeEvent(Date timeEvent) {
		this.timeEvent = timeEvent;
	}

	public double getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(double priceRange) {
		this.priceRange = priceRange;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public String getNameRoom() {
		return nameRoom;
	}

	public void setNameRoom(String nameRoom) {
		this.nameRoom = nameRoom;
	}

	public String getCityRoom() {
		return cityRoom;
	}

	public void setCityRoom(String cityRoom) {
		this.cityRoom = cityRoom;
	}

	public String getAddressRoom() {
		return addressRoom;
	}

	public void setAddressRoom(String addressRoom) {
		this.addressRoom = addressRoom;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getCapacityRoom() {
		return capacityRoom;
	}

	public void setCapacityRoom(int capacityRoom) {
		this.capacityRoom = capacityRoom;
	}

}
