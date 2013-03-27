package net.plaut.dbutil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.plaut.dbutil.object.SearchCondition;
import net.plaut.dbutil.object.SqlCondition;

public abstract class DbDao<R extends DbRecord> {
	
	public ArrayList<R> executeQuery(Connection con, SearchCondition searchCondition) throws SQLException{
		SqlCondition sqlCondition = createSelectSQLCondition(searchCondition);
		PreparedStatement pStatement = con.prepareStatement(sqlCondition.getSqlString());
		bindPreparedStatementParameters(pStatement, sqlCondition.getParameters());
		ResultSet rs = pStatement.executeQuery();
		ArrayList<R> result = new ArrayList<R>();
		while(rs.next()){
			R record = getRecordFromResultSet(rs);
			result.add(record);
		}

		rs.close();
		pStatement.close();
		
		return result;
	}
	
	public ArrayList<R> executeQuery(Connection con) throws SQLException{
		return executeQuery(con, null);
	}
	
	protected abstract SqlCondition createSelectSQLCondition(SearchCondition searchCondition);
	
	protected abstract R getRecordFromResultSet(ResultSet rs) throws SQLException;
	
	protected void bindPreparedStatementParameters(PreparedStatement pStatement, Object[] param) throws SQLException{
		if(param == null || param.length == 0)
			return;
		
		for(int i=0; i<param.length; i++){
			Object obj = param[i];
			if(obj == null){
				pStatement.setString(i+1, "");
				continue;
			}
			Class<?> javaClass = obj.getClass();
			if (javaClass == String.class) {
				pStatement.setString(i+1, (String) obj);
			} else if (javaClass == Boolean.class) {
				pStatement.setBoolean(i+1, (Boolean) obj);
			} else if (javaClass == Byte.class) {
				pStatement.setByte(i+1, (Byte) obj);
			} else if (javaClass == Short.class) {
				pStatement.setShort(i+1, (Short) obj);
			} else if (javaClass == Integer.class) {
				pStatement.setInt(i+1, (Integer) obj);
			} else if (javaClass == Long.class) {
				pStatement.setLong(i+1, (Long) obj);
			} else if (javaClass == Float.class) {
				pStatement.setFloat(i+1, (Float) obj);
			} else if (javaClass == Double.class) {
				pStatement.setDouble(i+1, (Double) obj);
			} else if (javaClass == java.math.BigDecimal.class) {
				pStatement.setBigDecimal(i+1, (java.math.BigDecimal) obj);
			} else if (javaClass == java.sql.Date.class) {
				pStatement.setDate(i+1, (java.sql.Date) obj);
			} else if (javaClass == java.util.Date.class) {
				pStatement.setTimestamp(i+1, new java.sql.Timestamp(((java.util.Date) obj).getTime()));
			} else if (javaClass == java.sql.Time.class) {
				pStatement.setTime(i+1, (java.sql.Time) obj);
			} else if (javaClass == java.sql.Timestamp.class) {
				pStatement.setTimestamp(i+1, (java.sql.Timestamp) obj);
			} else if (javaClass == java.sql.Array.class) {
				pStatement.setArray(i+1, (java.sql.Array) obj);
			} else if (javaClass == java.sql.Blob.class) {
				pStatement.setBlob(i+1, (java.sql.Blob) obj);
			} else if (javaClass == java.sql.Clob.class) {
				pStatement.setClob(i+1, (java.sql.Clob) obj);
			} else if (javaClass == java.sql.Ref.class) {
				pStatement.setRef(i+1, (java.sql.Ref) obj);
			} else {
				pStatement.setObject(i+1, obj);
			}
		}
	}
}
