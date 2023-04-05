package org.capgemini.proyecto2.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Card {

	@NotNull @NotEmpty(message = "El nombre de titular no puede estar vacío")
	@Size(min = 3, max = 40)
	private String nombreTitular;
	
	@NotNull @NotEmpty(message = "El formato para Visa es: 4aaa-bbbb-cccc-dddd / 4aaabbbbccccdddd /n"
			+ "El formato para Mastercard es: 5xaa-bbbb-cccc-dddd / 5xaabbbbccccdddd   donde x es un valor entre 1-5")
	@Size(min = 16, max = 16)
	@Positive
	private long numeroTarjeta;
	
	@NotNull @NotEmpty(message = "¡El mes no puede tener un '0' delante! y tiene que estar entre 1 y 12")
	@Size(min = 1, max = 2) @Min(1) @Max(12)
	private int mesCaducidad;
	
	@NotNull @NotEmpty(message = "¡El año no puede ser del pasado!")
	@Size(min = 4, max = 4) @Min(2023) @Max(2099)
	private int yearCaducidad;
	
	@NotNull @NotEmpty(message = "¡El CVV lo conforman 3 ó 4 dígitos!")
	@Size(min = 3, max = 4) @Min(2023) @Max(2099)
	private int cvv;
	
	
	private String emisor;
	private String concepto;
	
	@Positive @Max(10)
	private int cantidad;

	public Card() {
		super();
	}

	public Card(String nombreTitular, long numeroTarjeta, int mesCaducidad, int yearCaducidad, int cvv, String emisor,
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
