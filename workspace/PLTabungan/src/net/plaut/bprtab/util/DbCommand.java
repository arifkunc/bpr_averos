package net.plaut.bprtab.util;

import java.sql.Connection;
import java.sql.SQLException;

import net.plaut.dbutil.db.DbConnection;

public class DbCommand {
	public static Connection getConnection() throws SQLException{
		return DbConnection.createConnection(SystemInformation.getConnectInfo());
	}
}
