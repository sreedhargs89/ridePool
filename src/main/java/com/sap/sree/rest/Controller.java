package com.sap.sree.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.sap.sree.data.User;

//http://localhost:8080/RESTfulExample/rest/message/hello%20world
@Path("/api")
public class Controller {

	@GET
	@Path("abc/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Restful example : " + msg;

		return Response.status(200).entity(result).build();

	}


	/**
	 * @param user
	 * @return
	 */
	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createUser(User user) {
		String result = "User created : " + user;
		return Response.status(201).entity(result).build();
	}

	

	@GET
	@Path("/get")
	@Produces("application/json")
	public Response getProductInJSON() {
 
		User product = new User();
		product.setName("iPad 3");
 
		return Response.status(201).entity(product).build();
 
	}
	
	
}
