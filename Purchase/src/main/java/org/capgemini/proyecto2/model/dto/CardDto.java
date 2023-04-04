package org.capgemini.proyecto2.model.dto;

import java.io.Serializable;

import org.capgemini.proyecto2.model.Card;
import org.springframework.beans.BeanUtils;

public class CardDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombreTitular;
	private long numeroTarjeta;
	private int mesCaducidad;
	private int yearCaducidad;
	private int cvv;
	private String emisor;
	private String concepto;
	private int cantidad;

	public CardDto() {
		super();
	}

	public CardDto(String nombreTitular, long numeroTarjeta, int mesCaducidad, int yearCaducidad, int cvv, String emisor,
			String concepto, int cantidad) {
		super();
		this.nombreTitular = nombreTitular;
		this.numeroTarjeta = numeroTarjeta;
		this.mesCaducidad = mesCaducidad;
		this.yearCaducidad = yearCaducidad;
		this.cvv = cvv;
		this.emisor = emisor;
		this.concepto = concepto;
		this.cantidad = cantidad;
	}
	
	public CardDto toDto(Card card) {
		CardDto cardDto = new CardDto();
		BeanUtils.copyProperties(card, cardDto);
		return cardDto;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public long getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(long numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getMesCaducidad() {
		return mesCaducidad;
	}

	public void setMesCaducidad(int mesCaducidad) {
		this.mesCaducidad = mesCaducidad;
	}

	public int getYearCaducidad() {
		return yearCaducidad;
	}

	public void setYearCaducidad(int yearCaducidad) {
		this.yearCaducidad = yearCaducidad;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Card [nombreTitular=" + nombreTitular + ", numeroTarjeta=" + numeroTarjeta + ", mesCaducidad="
				+ mesCaducidad + ", yearCaducidad=" + yearCaducidad + ", cvv=" + cvv + ", emisor=" + emisor
				+ ", concepto=" + concepto + ", cantidad=" + cantidad + "]";
	}

}
