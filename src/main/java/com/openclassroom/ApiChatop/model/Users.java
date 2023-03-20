package com.openclassroom.ApiChatop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Date;

@Entity
@Data
@Table(name = "Users")
@AllArgsConstructor
public class Users {
	@Id
	private String id;
	private String email; 	
	private String name; 	
	private String password;
	@Column(name="Date")
	private Date created_at; 	
	private Date updated_at; 	
}
