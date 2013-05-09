package net.plaut.dbutil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.plaut.dbutil.object.DbFieldData;
import net.plaut.dbutil.object.SearchCondition;
import net.plaut.dbutil.object.SqlCondition;
import net.plaut.dbutil.util.DbGeneralUtil;

public abstract class TableDao<R extends TableRecord> {

	public ArrayList executeQuery(Connection con, SearchCondition searchCondition) throws SQLException {
		SqlCondition sqlCondition = createSelectSQLCondition(searchCondition);
		PreparedStatement pStatement = con.prepareStatement(sqlCondition.getSqlString());
		DbGeneralUtil.bindPreparedStatementParameters(pStatement, sqlCondition.getParameters());
		ResultSet rs = pStatement.executeQuery();
		ResultSetMetaData rsMetaData = rs.getMetaData();
		ArrayList<R> result = new ArrayList<R>();

		while (rs.next()) {
			R rec = this.createRecord();
			setRecord(rec, rs, rsMetaData);
			result.add(rec);
		}

		rs.close();
		pStatement.close();

		return result;
	}

	public ArrayList<R> executeQuery(Connection con) throws SQLException {
		return executeQuery(con, null);
	}

	protected void setRecord(R rec, ResultSet rs, ResultSetMetaData rsMetaData)
			throws SQLException {
		int colNum = rsMetaData.getColumnCount();
		for (int i = 1; i <= colNum; i++) {
			Object value = null;
			String columnLabel = rsMetaData.getColumnLabel(i);
			int type = rsMetaData.getColumnType(i);
			value = DbGeneralUtil.getJavaObject(rs, columnLabel, type);
			rec.setValue(columnLabel, value);
		}
	}

	protected abstract R createRecord();

	public abstract String getTableName();

	public abstract String getSelectFromSql();

	public abstract String createStringCondition(SearchCondition searchCondition, List bindParams);

	private SqlCondition createSelectSQLCondition(SearchCondition condition) {
		String sqlString = getSelectFromSql();
		ArrayList<Object> bindParams = new ArrayList<Object>();
		if(condition != null){
			sqlString += " "+createStringCondition(condition, bindParams);
		}
		SqlCondition sqlCondition = new SqlCondition(sqlString.toString(), bindParams.toArray());
		return sqlCondition;
	}

	private SqlCondition createInsertSQLCondition(R newRecord) {
		StringBuilder insertBuilder = new StringBuilder("INSERT INTO "+getTableName()+"(");
		ArrayList<Object> bindParams = new ArrayList<Object>();
		StringBuilder columnBuilder = new StringBuilder();
		StringBuilder valueBuilder = new StringBuilder();
		HashMap<String, DbFieldData> valueMap = newRecord.getValueMap();
		Iterator<String> ite = valueMap.keySet().iterator();
		while(ite.hasNext()){
			String columnName = ite.next();
			DbFieldData fieldData = valueMap.get(columnName);
			if(fieldData.isAssigned()){
				// for column
				if(columnBuilder.length()>0){
					columnBuilder.append(",");
				}
				columnBuilder.append(columnName);
				
				// for values
				if(valueBuilder.length()>0){
					valueBuilder.append(",");
				}
				valueBuilder.append("?");
				bindParams.add(fieldData.getValue());
			}
		}
		String sqlString = insertBuilder.toString() + columnBuilder.toString() + ") VALUES (" + valueBuilder.toString() + ")";
		
		SqlCondition sqlCondition = new SqlCondition(sqlString.toString(), bindParams.toArray());
		return sqlCondition;
	}

	private SqlCondition createUpdateSQLCondition(R updateRecord, SearchCondition condition) {
		StringBuilder updateBuilder = new StringBuilder("UPDATE "+getTableName()+" SET ");
		ArrayList<Object> bindParams = new ArrayList<Object>();
		StringBuilder setBuilder = new StringBuilder();
		HashMap<String, DbFieldData> valueMap = updateRecord.getValueMap();
		Iterator<String> ite = valueMap.keySet().iterator();
		while(ite.hasNext()){
			String columnName = ite.next();
			DbFieldData fieldData = valueMap.get(columnName);
			if(fieldData.isModified()){
				if(setBuilder.length()>0){
					setBuilder.append(",");
				}
				setBuilder.append(columnName);
				setBuilder.append("=?");
				bindParams.add(fieldData.getValue());
			}
		}
		String sqlString = updateBuilder.toString() + setBuilder.toString();
		
		if(condition != null){
			sqlString += " "+createStringCondition(condition, bindParams);
		}
		
		SqlCondition sqlCondition = new SqlCondition(sqlString.toString(), bindParams.toArray());
		return sqlCondition;
	}

	private SqlCondition createDeleteSQLCondition(SearchCondition condition) {
		String sqlString = "DELETE FROM " + getTableName();
		ArrayList<Object> bindParams = new ArrayList<Object>();
		if(condition != null){
			sqlString += " "+createStringCondition(condition, bindParams);
		}
		SqlCondition sqlCondition = new SqlCondition(sqlString.toString(), bindParams.toArray());
		return sqlCondition;
	}

	public int insert(Connection con, R newRecord) throws SQLException {
		SqlCondition sqlCondition = createInsertSQLCondition(newRecord);
		PreparedStatement pStatement = con.prepareStatement(sqlCondition.getSqlString());
		DbGeneralUtil.bindPreparedStatementParameters(pStatement, sqlCondition.getParameters());
		int result = pStatement.executeUpdate();
		pStatement.close();
		return result;
	}

	public int update(Connection con, R updateRecord, SearchCondition condition) throws SQLException {
		SqlCondition sqlCondition = createUpdateSQLCondition(updateRecord, condition);
		PreparedStatement pStatement = con.prepareStatement(sqlCondition.getSqlString());
		DbGeneralUtil.bindPreparedStatementParameters(pStatement, sqlCondition.getParameters());
		int result = pStatement.executeUpdate();
		pStatement.close();
		return result;
	}

	public int delete(Connection con, SearchCondition deleteCondition) throws SQLException {
		SqlCondition sqlCondition = createDeleteSQLCondition(deleteCondition);
		PreparedStatement pStatement = con.prepareStatement(sqlCondition.getSqlString());
		DbGeneralUtil.bindPreparedStatementParameters(pStatement, sqlCondition.getParameters());
		int result = pStatement.executeUpdate();
		pStatement.close();
		return result;
	}

}