package net.plaut.bprtab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.plaut.bprtab.dao.condition.BpaUserSrcCond;
import net.plaut.dbutil.dao.TableDao;
import net.plaut.dbutil.object.SearchCondition;
import net.plaut.dbutil.object.SqlCondition;

public class BpaUserTableDao extends TableDao<BpaUserTableRecord>{

	@Override
	public String getTableName() {
		return "BPA_USER";
	}

	@Override
	protected SqlCondition createSelectSQLCondition(SearchCondition searchCondition) {
		BpaUserSrcCond cond = (BpaUserSrcCond) searchCondition;
		String selectString = "SELECT * FROM "+ getTableName();
		ArrayList param = new ArrayList();
		if(cond == null){
			SqlCondition sqlCond = new SqlCondition(selectString, param.toArray());
			return sqlCond;
		}
		
		String whereString="";
		StringBuilder whereStringBuilder = new StringBuilder();
		

		if(cond.getUsername() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" USERNAME = ?");
			param.add(cond.getUsername());
		}

		if(cond.getPassword() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" PASSWORD = MD5(?)");
			param.add(cond.getPassword());
		}

		whereString = whereStringBuilder.toString();
		String sqlString = selectString + whereString;
		SqlCondition sqlCond = new SqlCondition(sqlString, param.toArray());

		return sqlCond;
	}

	@Override
	protected SqlCondition createInsertSQLCondition(BpaUserTableRecord newRecord) {
		String insertString = "INSERT INTO " + getTableName() + " VALUES (?,MD5(?),?)";
		ArrayList param = new ArrayList();
		param.add(newRecord.getUsername());
		param.add(newRecord.getPassword());
		param.add(newRecord.getGroupId());
		SqlCondition sqlCond = new SqlCondition(insertString, param.toArray());
		return sqlCond;
	}

	@Override
	protected SqlCondition createUpdateSQLCondition(BpaUserTableRecord updateRecord, SearchCondition updateCondition) {
		BpaUserSrcCond cond = (BpaUserSrcCond) updateCondition;
		String updateString = "UPDATE "+ getTableName() + " SET";
		String columnString="";
		String whereString="";
		
		StringBuilder columnStringBuilder = new StringBuilder();
		StringBuilder whereStringBuilder = new StringBuilder();
		ArrayList param = new ArrayList();
		
		// for set column_name = column_value
		if(updateRecord.getUsername() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" USERNAME=?");
			param.add(updateRecord.getUsername());
		}
		
		if(updateRecord.getPassword() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" PASSWORD=MD5(?)");
			param.add(updateRecord.getPassword());
		}
		
		if(updateRecord.getGroupId() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" GROUP_ID=?");
			param.add(updateRecord.getGroupId());
		}

		// for where condition
		if(cond.getUsername() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" USERNAME=?");
			param.add(cond.getUsername());
		}

		columnString = columnStringBuilder.toString();
		whereString = whereStringBuilder.toString();
		String sqlString = updateString + columnString + whereString;
		SqlCondition sqlCond = new SqlCondition(sqlString, param.toArray());
		return sqlCond;
	}

	@Override
	protected SqlCondition createDeleteSQLCondition(SearchCondition deleteCondition) {
		BpaUserSrcCond cond = (BpaUserSrcCond) deleteCondition;
		String deleteString = "DELETE FROM "+ getTableName();
		String whereString="";
		
		StringBuilder whereStringBuilder = new StringBuilder();
		ArrayList param = new ArrayList();

		if(cond.getUsername() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" USERNAME=?");
			param.add(cond.getUsername());
		}

		whereString = whereStringBuilder.toString();
		String sqlString = deleteString + whereString;
		SqlCondition sqlCond = new SqlCondition(sqlString, param.toArray());

		return sqlCond;
	}

	@Override
	protected BpaUserTableRecord createRecord() {
		return new BpaUserTableRecord();
	}

}
