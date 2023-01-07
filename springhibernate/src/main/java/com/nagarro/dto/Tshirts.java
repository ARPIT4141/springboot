package com.nagarro.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TshirtData")
public class Tshirts {
	@Id
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="colour")
	private String colour;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="size")
	private String size;
	
	@Column(name="price",length=8,precision=2)
	private double price;
	
	@Column(name="rating" , length=8,precision=2)
	private double rating;
	
	@Column(name="availability")
	private String availability;

	public Tshirts() {
		super();
		
	}

	public Tshirts(String id, String name, String colour, String gender, String size, double price, double rating,
			String availability) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.gender = gender;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.availability = availability;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	}
	
	

	
	


