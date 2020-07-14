package com.todo.DBSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSource {
	private static Connection CONN;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		CONN =DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "");
		return CONN;
	}

	public static void closeConnection(Connection conn) throws SQLException {
		CONN.close();
	}
}
