package com.sapient.aem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
	private Integer userId;
	private String userName;
	private String password;
	//private Role role;
	private String role;
	
//	public User(String username, String password, Role role) {
//		super();
//		this.userName = username;
//		this.password = password;
//		//this.role = role;
//	}
	public User(String username, String password,String role) {
	super();
		this.userName = username;
		this.password = password;
		this.role = role;
	}
	
}
