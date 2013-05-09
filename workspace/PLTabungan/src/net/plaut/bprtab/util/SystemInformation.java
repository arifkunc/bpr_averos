package net.plaut.bprtab.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import net.plaut.bprtab.dao.BpaUserTableDao;
import net.plaut.bprtab.dao.BpaUserTableRecord;
import net.plaut.bprtab.dao.condition.BpaUserSrcCond;
import net.plaut.common.util.PropertiesReader;
import net.plaut.dbutil.object.ConnectInfo;

public class SystemInformation {
	
	private static ConnectInfo connectInfoInstance = null;
	
	public static ConnectInfo getConnectInfo(){
		if(connectInfoInstance == null){
			connectInfoInstance = new ConnectInfo();
			PropertiesReader reader = new PropertiesReader("prop/config.properties");
			connectInfoInstance.setHostname(reader.getProperty("db.hostname"));
			connectInfoInstance.setUsername(reader.getProperty("db.username"));
			connectInfoInstance.setPassword(reader.getProperty("db.password"));
			connectInfoInstance.setDbname(reader.getProperty("db.dbname"));
		}
		return connectInfoInstance;
	}
	
	public static String[] createUsernameData(){
		String[] result = {};
		try {
			Connection con = DbCommand.getConnection();
			BpaUserTableDao userDao = BpaUserTableDao.getInstance();
			List usernameList = userDao.executeQuery(con, new BpaUserSrcCond());
			int numOfUsername = usernameList.size();
			result = new String[numOfUsername];
			
			for(int i=0; i<result.length; i++){
				BpaUserTableRecord rec = (BpaUserTableRecord) usernameList.get(i);
				result[i] = rec.getUsername();
			}
		} catch (SQLException e) {
			System.out.println("Gagal terhubung ke database");
		}
		return result;
	}

}
