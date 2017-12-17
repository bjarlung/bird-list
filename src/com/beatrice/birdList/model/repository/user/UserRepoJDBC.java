package com.beatrice.birdList.model.repository.user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beatrice.birdList.model.beans.User;
import com.beatrice.birdList.model.database.JDBCUtil;

/**
 * Implements UserRepository interface.
 * Handles communication with mySQL database
 * @author Beatrice
 * @since 1.0
 *
 */
public class UserRepoJDBC implements UserRepository, Serializable {
	/**
	 * serial version number for serialization
	 */
	private static final long serialVersionUID = 4178708225716614174L;
	private Connection connection = JDBCUtil.getInstance().getConnection();
	private static final String LOG_IN_QUERY = "SELECT user_id, fname, lname FROM users WHERE username=? AND password=?";
	private static final String NEW_USER_QUERY = "INSERT INTO users(username, password, fname, lname) VALUES(?, ?, ?, ?)";

	/**
	 * Get data from user in database, passing in username and password
	 */
	@Override
	public User getUser(String username, String password) {
		System.out.println("Getting user from JDBC database");
		User user = null;
		try (
				PreparedStatement prepStatement = connection.prepareStatement(LOG_IN_QUERY);
				){	
			System.out.println("In try. UserRepo getUser.");
			prepStatement.setString(1, username);
			prepStatement.setString(2, password);
			ResultSet resultSet = prepStatement.executeQuery();
			if(resultSet.next()) {
				System.out.println("UserRepo, getUser. if-result has next");
				resultSet.first();
				System.out.println("");
				user = new User();
				user.setFirstName(resultSet.getString("fname"));
				user.setLastName(resultSet.getString("lname"));
				user.setUsername(username);
				user.setUserId(resultSet.getInt("user_id"));
				System.out.println("New user in UserRepo, getUser" + user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No user found");
		}
		System.out.println("User from JDBC: " + user);
		return user;
	}

	/**
	 * Creates new user row in database
	 */
	@Override
	public User addUser(User user, String password) {
		try (
				PreparedStatement prepStatement = connection.prepareStatement(NEW_USER_QUERY );
				){			
			prepStatement.setString(1, user.getUsername());
			prepStatement.setString(2, password);
			prepStatement.setString(3, user.getFirstName());
			prepStatement.setString(4, user.getLastName());
			prepStatement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getUser(user.getUsername(), password);

	}

	/**
	 * Not implemented yet
	 */
	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not implemented yet
	 */
	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
