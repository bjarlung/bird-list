package com.beatrice.birdList.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <h1> JDBCUtil </h1>
 * Connects to database. Singleton class
 * @author Beatrice
 *
 */
public class JDBCUtil {
	private Connection connection;
	private static JDBCUtil instance;

	private static final String URL = "jdbc:mysql://localhost:3306/bird_list";
	private static final String USER = "root";
	private static final String PASS = "";

	/**
	 * Private constructor. Gets connection to database.
	 */
	private JDBCUtil() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("In JDBCUtil catch, no database found");
			e.printStackTrace();
		}
	}

	/**
	 * Instantiates singleton instance if necessary.
	 * @return
	 */
	public static JDBCUtil getInstance(){
		if(instance == null) {
			instance = new JDBCUtil();
		}
		return instance;

	}

	public Connection getConnection() {
		return this.connection;
	}

}