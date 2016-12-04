package com.anton.coupons.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionPool {
	private static ConnectionPool instance = null;

	protected ConnectionPool() {
		// Exists only to defeat instantiation
	}

	// Singleton object creation
	public static ConnectionPool getInstance() {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}

	// Connection creation
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/Coupons?autoReconnect=true&useSSL=false",
				"root", "07071990");

	}

	public static void closeResources(Connection connection, PreparedStatement preparedStatement) {
		try {

			if (connection != null && preparedStatement != null) {

				connection.close();
				preparedStatement.close();
			} else if (connection != null) {

				connection.close();
			} else if (preparedStatement != null) {

				preparedStatement.close();
			}
		} catch (SQLException e) {
			// Write to log that we have a resource leak
			e.printStackTrace();
		}
	}

	// Closes all connections
	public void closeAllConnections() throws ClassNotFoundException, SQLException {
		ConnectionPool.getConnection().close();
	}

}
