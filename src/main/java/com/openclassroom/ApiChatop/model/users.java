package com.openclassroom.ApiChatop.model;

import lombok.Data;
import java.sql.Date;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Table(name = "users")
public class users {

	private String id;
	private String email; 	
	private String name; 	
	private String password;	
	private Date created_at; 	
	private Date updated_at; 	
}
