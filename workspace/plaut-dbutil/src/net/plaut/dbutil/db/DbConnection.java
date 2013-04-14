package net.plaut.dbutil.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.plaut.dbutil.object.ConnectInfo;
import net.plaut.dbutil.object.DatabaseType;

public class DbConnection{
	
	private final static String DRIVER_CLASS_NAME_MYSQL = "com.mysql.jdbc.Driver";
	
	public static Connection createConnection(ConnectInfo info) throws SQLException{
		try{
			if(info.getDatabaseType() == DatabaseType.TYPE_MYSQL){
				Class.forName(DRIVER_CLASS_NAME_MYSQL);
				Connection conn = DriverManager.getConnection("jdbc:mysql://"+info.getHostname()+"/"+info.getDbname(), info.getUsername(), info.getPassword());
				return conn;
			} else {
				throw new SQLException("Database type is not defined");
			}

		}catch (ClassNotFoundException ex){
			throw new SQLException("Driver class not found");
		}

	}
}