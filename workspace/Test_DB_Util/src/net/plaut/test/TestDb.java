package net.plaut.test;

import java.awt.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import net.plaut.bprtab.dao.BpaUserTableDao;
import net.plaut.bprtab.dao.BpaUserTableRecord;
import net.plaut.bprtab.util.DbCommand;
import net.plaut.dbutil.db.DbConnection;

public class TestDb {
	public static void main(String []args){
		Connection con;
		try {
			con = DbCommand.getConnection();
			BpaUserTableDao dao = new BpaUserTableDao();
			ArrayList ret = dao.executeQuery(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
