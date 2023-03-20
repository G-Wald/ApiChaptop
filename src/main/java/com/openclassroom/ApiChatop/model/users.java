package com.openclassroom.ApiChatop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Date;

import lombok.Getter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
public class users {
	@Id
	private String id;
	private String email; 	
	private String name; 	
	private String password;
	@Column(name="Date")
	private Date created_at; 	
	private Date updated_at; 	
}
