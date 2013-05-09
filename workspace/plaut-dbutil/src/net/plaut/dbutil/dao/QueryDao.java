package net.plaut.dbutil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.plaut.dbutil.object.SearchCondition;
import net.plaut.dbutil.object.SqlCondition;
import net.plaut.dbutil.util.DbGeneralUtil;


public abstract class QueryDao<R extends QueryRecord>{

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

	protected void setRecord(R rec, ResultSet rs, ResultSetMetaData rsMetaData) throws SQLException {
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

}
