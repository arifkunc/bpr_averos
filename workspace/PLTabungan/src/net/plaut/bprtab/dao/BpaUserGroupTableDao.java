package net.plaut.bprtab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.plaut.bprtab.dao.condition.BpaUserGroupSrcCond;
import net.plaut.dbutil.dao.TableDao;
import net.plaut.dbutil.object.SearchCondition;
import net.plaut.dbutil.object.SqlCondition;

public class BpaUserGroupTableDao extends TableDao<BpaUserGroupTableRecord> {

	public static final String TABLE_NAME = "BPA_USER_GROUP";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	protected SqlCondition createSelectSQLCondition(SearchCondition searchCondition) {
		
		String sqlString;
		String selectString = "SELECT * FROM "+ getTableName();
		ArrayList param = new ArrayList();
		
		if(searchCondition == null){
			sqlString = selectString;
			SqlCondition sqlCond = new SqlCondition(sqlString, param.toArray());
			return sqlCond;
		}
		
		BpaUserGroupSrcCond cond = (BpaUserGroupSrcCond) searchCondition;
		String whereString="";
		StringBuilder whereStringBuilder = new StringBuilder();
		

		if(cond.getId() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" ID = ?");
			param.add(cond.getId());
		}

		whereString = whereStringBuilder.toString();
		sqlString = selectString + whereString;
		SqlCondition sqlCond = new SqlCondition(sqlString, param.toArray());

		return sqlCond;
	}

	@Override
	protected SqlCondition createInsertSQLCondition(BpaUserGroupTableRecord newRecord) {
		String insertString = "INSERT INTO " + getTableName() + " VALUES (?,?)";
		ArrayList param = new ArrayList();
		param.add(newRecord.getId());
		param.add(newRecord.getGroupName());
		SqlCondition sqlCond = new SqlCondition(insertString, param.toArray());
		return sqlCond;
	}

	@Override
	protected SqlCondition createUpdateSQLCondition(BpaUserGroupTableRecord updateRecord, SearchCondition updateCondition) {
		BpaUserGroupSrcCond cond = (BpaUserGroupSrcCond) updateCondition;
		String updateString = "UPDATE "+ getTableName() + " SET";
		String columnString="";
		String whereString="";
		
		StringBuilder columnStringBuilder = new StringBuilder();
		StringBuilder whereStringBuilder = new StringBuilder();
		ArrayList param = new ArrayList();
		
		// for set column_name = column_value
		if(updateRecord.getId() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" ID=?");
			param.add(updateRecord.getId());
		}
		
		if(updateRecord.getGroupName() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" GROUP_NAME=?");
			param.add(updateRecord.getGroupName());
		}

		// for where condition
		if(cond.getId() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" ID=?");
			param.add(cond.getId());
		}

		columnString = columnStringBuilder.toString();
		whereString = whereStringBuilder.toString();
		String sqlString = updateString + columnString + whereString;
		SqlCondition sqlCond = new SqlCondition(sqlString, param.toArray());
		return sqlCond;
	}

	@Override
	protected SqlCondition createDeleteSQLCondition(SearchCondition deleteCondition) {
		BpaUserGroupSrcCond cond = (BpaUserGroupSrcCond) deleteCondition;
		String deleteString = "DELETE FROM "+ getTableName();
		String whereString="";
		
		StringBuilder whereStringBuilder = new StringBuilder();
		ArrayList param = new ArrayList();

		if(cond.getId() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" ID=?");
			param.add(cond.getId());
		}

		whereString = whereStringBuilder.toString();
		String sqlString = deleteString + whereString;
		SqlCondition sqlCond = new SqlCondition(sqlString, param.toArray());

		return sqlCond;
	}

	@Override
	protected BpaUserGroupTableRecord getRecordFromResultSet(ResultSet rs) throws SQLException {
		BpaUserGroupTableRecord record = new BpaUserGroupTableRecord();
		record.setId(rs.getString("ID"));
		record.setGroupName(rs.getString("GROUP_NAME"));
		
		return record;
	}
	
}
