package com.slack.entity;

public class User {
	private int id;
	private String username;
	private String email;
	private String password;

	public User(int id, String login, String email, String password) {
		super();
		this.id = id;
		this.username = login;
		this.email = email;
		this.password = password;
	}
	
	public User(String login, String email, String password) {
		super();
		this.username = login;
		this.email = email;
		this.password = password;
	}	

	public User(String login, String email) {
		super();
		this.username = login;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String login) {
		this.username = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
