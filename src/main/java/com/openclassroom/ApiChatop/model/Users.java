package com.openclassroom.ApiChatop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
public class Users {
	@Id
	private String id;
	private String email; 	
	private String name; 	
	private String password;
	private Date created_at;
	private Date updated_at;
	public Users(){};
}

