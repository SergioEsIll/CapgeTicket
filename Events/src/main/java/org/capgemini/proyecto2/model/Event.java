package org.capgemini.proyecto2.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "El nombre no puede estar vacío")
	@Size(min = 1, max = 255)
	private String name;
	@NotEmpty(message = "La descripción corta no puede estar vacía")
	@Size(min = 1, max = 255)
	private String shortDescription;
	@NotEmpty(message = "La descripción extendida no puede estar vacía")
	@Size(min = 1, max = 255)
	private String extendedDescription;
	@NotEmpty(message = "La fecha del evento es obligatoria")
	private Date dateEvent;
	@NotEmpty(message = "La duración del evento es obligatoria")
	private Date timeEvent;
	@NotEmpty(message = "El rango de precio es obligatorio")
	@Positive
	private double priceRange;
	@NotEmpty(message = "Las normas del evento no pueden estar vacías")
	@Size(min = 1, max = 255)
	private String rules;
	@NotEmpty(message = "El nombre de la sala no puede estar vacío")
	@Size(min = 1, max = 255)
	private String nameRoom;
	@NotEmpty(message = "La ciudad de la sala no puede estar vacía")
	@Size(min = 1, max = 255)
	private String cityRoom;
	@NotEmpty(message = "La dirección de la sala no puede estar vacía")
	@Size(min = 1, max = 255)
	private String addressRoom;
	@NotEmpty(message = "El tipo de la sala no puede estar vacío")
	@Size(min = 1, max = 255)
	private String roomType;
	@NotEmpty(message = "La capacidad de la sala es obligatoria")
	@Positive
	private int capacityRoom;

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(int id, @NotEmpty(message = "El nombre no puede estar vacío") @Size(min = 1, max = 255) String name,
			@NotEmpty(message = "La descripción corta no puede estar vacía") @Size(min = 1, max = 255) String shortDescription,
			@NotEmpty(message = "La descripción extendida no puede estar vacía") @Size(min = 1, max = 255) String extendedDescription,
			@NotEmpty(message = "La fecha del evento es obligatoria") Date dateEvent,
			@NotEmpty(message = "La duración del evento es obligatoria") Date timeEvent,
			@NotEmpty(message = "El rango de precio es obligatorio") @Positive double priceRange,
			@NotEmpty(message = "Las normas del evento no pueden estar vacías") @Size(min = 1, max = 255) String rules,
			@NotEmpty(message = "El nombre de la sala no puede estar vacío") @Size(min = 1, max = 255) String nameRoom,
			@NotEmpty(message = "La ciudad de la sala no puede estar vacía") @Size(min = 1, max = 255) String cityRoom,
			@NotEmpty(message = "La dirección de la sala no puede estar vacía") @Size(min = 1, max = 255) String addressRoom,
			@NotEmpty(message = "El tipo de la sala no puede estar vacío") @Size(min = 1, max = 255) String roomType,
			@NotEmpty(message = "La capacidad de la sala es obligatoria") @Positive int capacityRoom) {
		super();
		this.id = id;
		this.name = name;
		this.shortDescription = shortDescription;
		this.extendedDescription = extendedDescription;
		this.dateEvent = dateEvent;
		this.timeEvent = timeEvent;
		this.priceRange = priceRange;
		this.rules = rules;
		this.nameRoom = nameRoom;
		this.cityRoom = cityRoom;
		this.addressRoom = addressRoom;
		this.roomType = roomType;
		this.capacityRoom = capacityRoom;
	}

	public Event(@NotEmpty(message = "El nombre no puede estar vacío") @Size(min = 1, max = 255) String name,
			@NotEmpty(message = "La descripción corta no puede estar vacía") @Size(min = 1, max = 255) String shortDescription,
			@NotEmpty(message = "La descripción extendida no puede estar vacía") @Size(min = 1, max = 255) String extendedDescription,
			@NotEmpty(message = "La fecha del evento es obligatoria") Date dateEvent,
			@NotEmpty(message = "La duración del evento es obligatoria") Date timeEvent,
			@NotEmpty(message = "El rango de precio es obligatorio") @Positive double priceRange,
			@NotEmpty(message = "Las normas del evento no pueden estar vacías") @Size(min = 1, max = 255) String rules,
			@NotEmpty(message = "El nombre de la sala no puede estar vacío") @Size(min = 1, max = 255) String nameRoom,
			@NotEmpty(message = "La ciudad de la sala no puede estar vacía") @Size(min = 1, max = 255) String cityRoom,
			@NotEmpty(message = "La dirección de la sala no puede estar vacía") @Size(min = 1, max = 255) String addressRoom,
			@NotEmpty(message = "El tipo de la sala no puede estar vacío") @Size(min = 1, max = 255) String roomType,
			@NotEmpty(message = "La capacidad de la sala es obligatoria") @Positive int capacityRoom) {
		super();
		this.name = name;
		this.shortDescription = shortDescription;
		this.extendedDescription = extendedDescription;
		this.dateEvent = dateEvent;
		this.timeEvent = timeEvent;
		this.priceRange = priceRange;
		this.rules = rules;
		this.nameRoom = nameRoom;
		this.cityRoom = cityRoom;
		this.addressRoom = addressRoom;
		this.roomType = roomType;
		this.capacityRoom = capacityRoom;
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

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", shortDescription=" + shortDescription
				+ ", extendedDescription=" + extendedDescription + ", dateEvent=" + dateEvent + ", timeEvent="
				+ timeEvent + ", priceRange=" + priceRange + ", rules=" + rules + ", nameRoom=" + nameRoom
				+ ", cityRoom=" + cityRoom + ", addressRoom=" + addressRoom + ", roomType=" + roomType
				+ ", capacityRoom=" + capacityRoom + "]";
	}

}
