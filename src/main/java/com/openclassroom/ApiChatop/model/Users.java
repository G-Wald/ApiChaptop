package com.openclassroom.ApiChatop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

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

	/*
	implements UserDetails
	authorities.add(new SimpleGrantedAuthority("USER"));
	public String getUsername(){
		return this.name;
	}
	public String getPassword(){
		return this.password;
	}
	public boolean isAccountNonExpired(){
		return true;
	}
	public boolean isAccountNonLocked(){
		return true;
	}

	public boolean isCredentialsNonExpired(){
		return true;
	};

	public boolean isEnabled(){
		return true;
	};
	private final Set<GrantedAuthority> authorities = new HashSet<>();

	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}*/
}
