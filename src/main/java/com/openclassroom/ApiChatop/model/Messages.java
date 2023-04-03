package com.openclassroom.ApiChatop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "messages")
@AllArgsConstructor
public class Messages {
	@Id
 	private int id;
	private String rental_id; 	
	private String user_id; 	
	private String message;	
	private Date created_at; 	
	private Date updated_at;

	public Messages(){};
}
