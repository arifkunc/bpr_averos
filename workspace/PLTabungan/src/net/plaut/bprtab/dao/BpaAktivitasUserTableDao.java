package net.plaut.bprtab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.plaut.bprtab.dao.condition.BpaAktivitasUserSrcCond;
import net.plaut.bprtab.dao.condition.BpaUserSrcCond;
import net.plaut.dbutil.dao.TableDao;
import net.plaut.dbutil.object.SearchCondition;
import net.plaut.dbutil.object.SqlCondition;

public class BpaAktivitasUserTableDao extends TableDao<BpaAktivitasUserTableRecord> {

	public final static String TABLE_NAME = "BPA_AKTIVITAS_USER";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	protected SqlCondition createSelectSQLCondition(SearchCondition searchCondition) {
		BpaAktivitasUserSrcCond cond = (BpaAktivitasUserSrcCond) searchCondition;
		String selectString = "SELECT * FROM "+ getTableName();
		ArrayList param = new ArrayList();
		
		String whereString="";
		StringBuilder whereStringBuilder = new StringBuilder();
		

		if(cond.getId() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" ID = ?");
			param.add(cond.getUsername());
		}

		if(cond.getUsername() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" USERNAME = ?");
			param.add(cond.getUsername());
		}

		whereString = whereStringBuilder.toString();
		String sqlString = selectString + whereString;
		SqlCondition sqlCond = new SqlCondition(sqlString, param.toArray());

		return sqlCond;
	}

	@Override
	protected SqlCondition createInsertSQLCondition(BpaAktivitasUserTableRecord newRecord) {
		String insertString = "INSERT INTO " + getTableName() + " VALUES (?,?,?,?)";
		ArrayList param = new ArrayList();
		param.add(newRecord.getId());
		param.add(newRecord.getWaktu());
		param.add(newRecord.getUsername());
		param.add(newRecord.getAktivitas());
		SqlCondition sqlCond = new SqlCondition(insertString, param.toArray());
		return sqlCond;
	}

	@Override
	protected SqlCondition createUpdateSQLCondition(BpaAktivitasUserTableRecord updateRecord, SearchCondition updateCondition) {
		BpaAktivitasUserSrcCond cond = (BpaAktivitasUserSrcCond) updateCondition;
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
		
		if(updateRecord.getWaktu() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" WAKTU=?");
			param.add(updateRecord.getWaktu());
		}
		
		if(updateRecord.getUsername() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" USERNAME=?");
			param.add(updateRecord.getUsername());
		}
		
		if(updateRecord.getAktivitas() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" AKTIVITAS=?");
			param.add(updateRecord.getAktivitas());
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
		BpaAktivitasUserSrcCond cond = (BpaAktivitasUserSrcCond) deleteCondition;
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
	protected BpaAktivitasUserTableRecord createRecord() {
		return new BpaAktivitasUserTableRecord();
	}
}
