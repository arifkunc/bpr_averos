package net.plaut.dbutil.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import net.plaut.dbutil.object.ConnectionInformation;
import net.plaut.dbutil.object.SqlCondition;

public class DbConnection{

	public static Connection createConnection(String hostName, String userName, String password, String dbName) throws SQLException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://"+hostName+"/"+dbName, userName, password);
			return conn;

		}catch (ClassNotFoundException ex){
			throw new SQLException();
		}

	}
	
	public static Connection createConnection(ConnectionInformation info) throws SQLException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://"+info.getHostname()+"/"+info.getDbname(), info.getUsername(), info.getPassword());
			return conn;

		}catch (ClassNotFoundException ex){
			throw new SQLException();
		}

	}
}