package com.openclassroom.ApiChatop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "rentals")
@AllArgsConstructor
public class rentals {
	@Id
	private String id;
	private String name; 
	private int surface;
	private int price;
	private String picture;
	private String descritpion;
	private String owner_id;
	private Date created_at; 	
	private Date updated_at; 
}
