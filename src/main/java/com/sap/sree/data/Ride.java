package com.sap.sree.data;

import java.util.Date;


@SuppressWarnings("javadoc")
enum STATUS {
	ACTIVE, EXPIRED
}; 

public class Ride {
	
	private String from;
	private String to;
	private String via;
	private Date dateTime = new Date(); 
	private String userEmail;
	private String status;
	private Date reqTime;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public Ride(String from, String to, String via, Date dateTime,
			String userEmail, String status) {
		super();
		this.from = from;
		this.to = to;
		this.via = via;
		this.dateTime = dateTime;
		this.userEmail = userEmail;
		this.status = status;
	}
	
	
	/**
	 * Ride request Constructor
	 * @param from  From where person board
	 * @param to destination
	 * @param via Optional route description
	 */
	public Ride(String from, String to, String via) {
		super();
		this.from = from;
		this.to = to;
		this.via = via;
		this.reqTime = new Date();
	}
	
	/**
	 * Default constructor
	 */
	public Ride(){}
	
	@Override
	public String toString() {
		return "Ride Added \n [from=" + from + "\n to=" + to + "\n via=" + via
				+ "\ndateTime=" + dateTime + "]";
	}
	
	
	
		
}
