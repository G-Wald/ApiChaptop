package com.openclassroom.ApiChatop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "messages")
@AllArgsConstructor
public class messages {
	@Id
 	private String id;
	private String rental_id; 	
	private String user_id; 	
	private String message;	
	private Date created_at; 	
	private Date updated_at; 
}
