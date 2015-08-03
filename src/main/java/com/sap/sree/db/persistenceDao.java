package com.sap.sree.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sap.sree.data.Ride;
import com.sap.sree.data.RideResponse;
import com.sap.sree.data.User;

/**
 * @author I310383
 * Persistence DAO class responsible for dealing with the DB
 */
public class persistenceDao {

	/**
	 * Adds user data to DB
	 * @param user
	 * @throws Exception
	 */
	@SuppressWarnings("javadoc")
	public static void addUser(User user) throws Exception {

		Connection conn = dbConnection.getConnection();
		String query = " insert into users (name,gender,email,phone,password)"
				+ " values (?,?,?,?,?)";

		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString(1, user.getName());
		preparedStmt.setString(2, user.getGender());
		preparedStmt.setString(3, user.getEmail());
		preparedStmt.setString(4, user.getPhone());
		preparedStmt.setString(5, user.getPassword());
		preparedStmt.execute();

		conn.close();
	}
	
	/**
	 * Updates ride table
	 * @param user
	 * @throws Exception
	 */
	@SuppressWarnings("javadoc")
	public static void addRide(Ride ride) throws Exception {

		Connection conn = dbConnection.getConnection();
		String query = " insert into ride (lfrom,lto,lvia,dateTime,u_id,status)"
				+ " values (?,?,?,?,?,?)";

		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString(1, ride.getFrom());
		preparedStmt.setString(2, ride.getTo());
		preparedStmt.setString(3, ride.getVia());
		preparedStmt.setString(4, ride.getDateTime().toGMTString());
		preparedStmt.setString(5, ride.getUserEmail());
		preparedStmt.setString(6, "active");
		preparedStmt.execute();
		conn.close();
	}
	
	/**
	 * This is to update the ride once it completed or Ride offerer closes the ride
	 * @param ride
	 * @throws Exception
	 */
	public static void updateRide(Ride ride) throws Exception{
		Connection conn = dbConnection.getConnection();
		String query = " insert into users (lfrom,lto,lvia,dateTime,u_id,status)"
				+ " values (?,?,?,?,?,?)";

		PreparedStatement preparedStmt = conn.prepareStatement(query);
		
		preparedStmt.execute();
		conn.close();
	}
	
	
	/**
	 * Provided from and to this will display all the available rides
	 * @param from
	 * @param to
	 * @return
	 * @throws Exception
	 */
	public static List<RideResponse> getRideList(Ride rideObj) throws Exception{
		Connection conn = dbConnection.getConnection();
		String query = "select * from ride where lfrom='"+rideObj.getFrom()+"' and lto='"+rideObj.getTo()+"'";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		ResultSet rs= preparedStmt.executeQuery();
		
		List<RideResponse> rideResponseList = new ArrayList<RideResponse>();
		
		while(rs.next()){
	      Ride ride = new Ride();
			ride.setFrom(rs.getString("lfrom"));
			ride.setTo(rs.getString("lto"));
			ride.setVia(rs.getString("lvia"));
			ride.setDateTime((new Date(rs.getString("dateTime"))));
			ride.setUserEmail(rs.getString("u_id"));
			ride.setStatus(rs.getString("status"));		
			rideResponseList.add(new RideResponse(ride, getUserById(rs.getString("u_id"))));
		}
		return rideResponseList;
	}
	
	public static User getUserById(String email) throws Exception{
		Connection conn = dbConnection.getConnection();
		String query = "select * from users WHERE email='"+email+"'";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		ResultSet rs= preparedStmt.executeQuery();
		
		User user = new User();
		while(rs.next()){
			user.setEmail(rs.getString("email"));
			user.setName(rs.getString("name"));
			user.setPhone((rs.getString("phone")));
			user.setRating((rs.getFloat("rating")));
			user.setGender(rs.getString("gender"));
		}
		return user;
	}
	
	public static boolean isUserExist(String email) throws SQLException{
		
		Connection conn;
		String query = "select * from users WHERE email='"+email+"'";
		ResultSet rs = null;
		try {
			conn = dbConnection.getConnection();
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			rs= preparedStmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(rs.next())
			return true;
		else
			return false;
		
	}
}
