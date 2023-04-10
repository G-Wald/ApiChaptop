package com.openclassroom.ApiChatop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
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
