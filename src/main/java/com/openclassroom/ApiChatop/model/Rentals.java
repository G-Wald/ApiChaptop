package com.openclassroom.ApiChatop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Data
@Table(name = "rentals")
@AllArgsConstructor
public class Rentals {
	@Id
	private int id;
	private String name; 
	private int surface;
	private int price;
	private String picture;
	private String description;
	private String owner_id;
	private Date created_at; 	
	private Date updated_at;

	public Rentals(){};
}
