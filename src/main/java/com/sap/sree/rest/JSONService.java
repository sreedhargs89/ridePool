package com.sap.sree.rest;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sap.sree.data.Ride;
import com.sap.sree.data.RideResponse;
import com.sap.sree.data.User;
import com.sap.sree.db.persistenceDao;
import com.sun.jersey.api.view.Viewable;

@Path("/api")
public class JSONService {
	
	
	@GET
	@Path("/index")
	public Viewable index(
	    @Context HttpServletRequest request,
	    @Context HttpServletResponse response) throws Exception
	{
	  request.setAttribute("key", "value");
	  return new Viewable("index.jsp", null);
	}	

	@GET
	@Path("/login")
	public Response login(User user) {
		String message ="";
		try {
			User userObj = persistenceDao.getUserById(user.getEmail());
			if(null!= userObj.getName())
			message ="Welcome "+userObj.getName();
			else
				message = "You are not registered please sign up ";
				
		} catch (Exception e) {
		}
		
		
		return Response.status(200).entity(message).build();
	}

	@POST
	@Path("/userlogin")
	public Response userlogin(@FormParam("email") String email,
			@FormParam("password") String password) {
		String message ="";
		try {
			User userObj = persistenceDao.getUserById(email);
			if(null!= userObj.getName())
			message ="Welcome "+userObj.getName();
			else
				message = "You are not registered please sign up ";
				
		} catch (Exception e) {
		}
		
		
		return Response.status(200).entity(message).build();
	}

	@POST
	@Path("/register")
	public Response addUser(
			@FormParam("name") String name,
			@FormParam("gender") String gender, 
			@FormParam("email") String email,
			@FormParam("phone") String phone,
			@FormParam("password") String password ) throws SQLException {
		
		String message = "";
		if(persistenceDao.isUserExist(email)){
			message = "This "+email + "already exist. Click on forgot password for recovery";
		}else{
			User user = new User(name, gender, email, null, phone, password);
			registerUser(user);
			message = "User data added successfully :"+ user;  
		}
		return Response.status(200).entity(message).build();
	}
	
	public Response registerUser(User user) {
		String result = "User created : " + user;
		try {
			
			persistenceDao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(result).build();
	}
	
		
	
	@POST
	@Path("/offerRide")
	@Consumes("application/json")
	public Response offerRide(Ride ride) {
		try {
			persistenceDao.addRide(ride);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(ride).build();
	}
	
	
	@POST
	@Path("/findRide")
	@Consumes("application/json")
	@Produces("application/json")
	public Response findRide(Ride ride) throws Exception {
		List<RideResponse> rideList = persistenceDao.getRideList(ride);
		
		return Response.status(200).entity(rideList).build();
	}
	
	
	
	@Path("/sessionID")
	@GET @Produces(MediaType.TEXT_PLAIN)
	  public String getSessionId( @Context HttpServletRequest request ){
	    return request.getSession(true).getId();
	}
}