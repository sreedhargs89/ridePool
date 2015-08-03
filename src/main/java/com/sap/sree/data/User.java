package com.sap.sree.data;

import java.util.ArrayList;

import javax.ws.rs.core.Application;

public class User extends Application {
	private String name;
	private String gender;
	private String email;
	private String sap_id;
	private String phone;
	private String password;
	private float rating = 0;
	private ArrayList<String> feedback = new ArrayList<String>();
	
	public User() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSap_id() {
		return sap_id;
	}
	public void setSap_id(String sap_id) {
		this.sap_id = sap_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public ArrayList<String> getFeedback() {
		return feedback;
	}
	public void setFeedback(ArrayList<String> feedback) {
		this.feedback = feedback;
	}
	public User(String name, String gender, String email, String sap_id,
			String phone, String password, float rating,
			ArrayList<String> feedback) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.sap_id = sap_id;
		this.phone = phone;
		this.password = password;
		this.rating = rating;
		this.feedback = feedback;
	}
	public User(String name, String gender, String email, String sap_id,
			String phone, String password) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.sap_id = sap_id;
		this.phone = phone;
		this.password = password;
	}
	
	
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", phone=" + phone
				+ "]";
	}
	
}
