package net.plaut.dbutil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.plaut.dbutil.object.SearchCondition;
import net.plaut.dbutil.object.SqlCondition;

public abstract class TableDao<R extends TableRecord> extends DbDao<R>{
	
	public abstract String getTableName();
	
	protected abstract SqlCondition createInsertSQLCondition(R newRecord);
	
	protected abstract SqlCondition createUpdateSQLCondition(R updateRecord, SearchCondition updateCondition);
	
	protected abstract SqlCondition createDeleteSQLCondition(SearchCondition deleteCondition);
	
	public int insert(Connection con, R newRecord) throws SQLException{
		SqlCondition sqlCondition = createInsertSQLCondition(newRecord);
		PreparedStatement pStatement = con.prepareStatement(sqlCondition.getSqlString());
		bindPreparedStatementParameters(pStatement, sqlCondition.getParameters());
		int result = pStatement.executeUpdate();
		pStatement.close();
		return result;
	}
	
	public int update(Connection con, R updateRecord, SearchCondition updateCondition) throws SQLException{
		SqlCondition sqlCondition = createUpdateSQLCondition(updateRecord, updateCondition);
		PreparedStatement pStatement = con.prepareStatement(sqlCondition.getSqlString());
		bindPreparedStatementParameters(pStatement, sqlCondition.getParameters());
		int result = pStatement.executeUpdate();
		pStatement.close();
		return result;
	}
	
	public int delete(Connection con, SearchCondition deleteCondition) throws SQLException{
		SqlCondition sqlCondition = createDeleteSQLCondition(deleteCondition);
		PreparedStatement pStatement = con.prepareStatement(sqlCondition.getSqlString());
		bindPreparedStatementParameters(pStatement, sqlCondition.getParameters());
		int result = pStatement.executeUpdate();
		pStatement.close();
		return result;
	}
	
}