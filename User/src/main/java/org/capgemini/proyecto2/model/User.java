package org.capgemini.proyecto2.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "El nombre no puede estar vacío")
	@Size(min = 1, max = 255)
	private String name;
	@NotEmpty(message = "El apellido no puede estar vacío")
	@Size(min = 1, max = 255)
	private String surname;
	@NotEmpty(message = "El email no puede estar vacío")
	@Size(min = 1, max = 255)
	private String email;
	@NotEmpty(message = "la constraseña no puede estar vacía")
	@Size(min = 1, max = 255)
	private String password;
	@NotEmpty(message = "La fecha no puede estar vacía")
	private Date date;

	public User() {
		super();
	}

	public User(int id, String name, String surname, String email, String password, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.date = date;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", password="
				+ password + ", date=" + date + "]";
	}

}
