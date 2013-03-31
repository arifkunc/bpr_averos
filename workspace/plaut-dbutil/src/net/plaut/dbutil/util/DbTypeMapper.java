package net.plaut.dbutil.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class DbTypeMapper {
	
	public static Object getJavaObject(ResultSet rs, String columnName, int sqlType) throws SQLException{
		Object result = null;
		if(sqlType == Types.INTEGER){
			result = rs.getInt(columnName);
		} else if(sqlType == Types.VARCHAR){
			result = rs.getString(columnName);
		} else if(sqlType == Types.DATE){
			result = rs.getDate(columnName);
		} else if(sqlType == Types.DECIMAL){
			result = rs.getDouble(columnName);
		} else if (sqlType == Types.DOUBLE){
			result = rs.getDouble(columnName);
		} else {
			throw new SQLException("No matched SQL Type");
		}
		
		return result;
	}
}
