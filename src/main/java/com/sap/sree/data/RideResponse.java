package com.sap.sree.data;

import java.util.Date;


import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonAutoDetect
public class RideResponse {
	
	private Ride ride;
	private User user;
	
	String name;
	String gender;
	String from;
	String to;
	String via;
	Date dateTime;
	float rating;
	
	public RideResponse(String name, String gender, String from, String to,
			String via, Date dateTime, float rating) {
		super();
		this.name = name;
		this.gender = gender;
		this.from = from;
		this.to = to;
		this.via = via;
		this.dateTime = dateTime;
		this.rating = rating;
	}

	@JsonProperty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@JsonProperty
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@JsonProperty
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@JsonProperty
	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	@JsonProperty
	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@JsonProperty
	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public RideResponse(Ride ride, User user) {
		super();
		this.ride = ride;
		this.user = user;
		
		this.name = user.getName();
		this.gender = user.getGender();
		this.from = ride.getFrom();
		this.to = ride.getTo();
		this.via = ride.getVia();
		this.dateTime = ride.getDateTime();
		this.rating = user.getRating();
		
	}

	
	
	@Override
	public String toString() {
		return "name=" + name + ", gender=" + gender + ", from="
				+ from + ", to=" + to + ", via=" + via + ", dateTime="
				+ dateTime + ", rating=" + rating;
	}
	
}
