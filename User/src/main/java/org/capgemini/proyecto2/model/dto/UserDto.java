package org.capgemini.proyecto2.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.capgemini.proyecto2.model.User;
import org.springframework.beans.BeanUtils;

public class UserDto implements Serializable {

	/**
	 * Default serial version
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private Date date;
	
	public UserDto() {
		super();
	}
	
	public static UserDto toDto(User user) {
		UserDto userDto = new UserDto();
		
		//Copia todas las propiedades propias de java, entidades no
		BeanUtils.copyProperties(user, userDto);
		
		return userDto;
	}
	
	public static List<UserDto> toDto(List<User> users) {
		return users.stream().map(e -> toDto(e)).collect(Collectors.toList());
	}
	
	public static User toDao(UserDto userDto) {
		User user = new User();
		
		BeanUtils.copyProperties(userDto, user);
		
		return user;
	}
	
	public static List<User> toDao(List<UserDto> userDto) {
		return userDto.stream().map(e -> toDao(e)).collect(Collectors.toList());
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
	
}
