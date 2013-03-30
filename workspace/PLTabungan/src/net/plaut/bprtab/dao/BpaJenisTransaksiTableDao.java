package net.plaut.bprtab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.plaut.bprtab.dao.condition.BpaJenisTransaksiSrcCond;
import net.plaut.dbutil.dao.TableDao;
import net.plaut.dbutil.object.SearchCondition;
import net.plaut.dbutil.object.SqlCondition;

public class BpaJenisTransaksiTableDao extends TableDao<BpaJenisTransaksiTableRecord> {

	@Override
	public String getTableName() {
		return "BPA_JENIS_TRANSAKSI";
	}

	@Override
	protected SqlCondition createSelectSQLCondition(SearchCondition searchCondition) {
		BpaJenisTransaksiSrcCond cond = (BpaJenisTransaksiSrcCond) searchCondition;
		String selectString = "SELECT * FROM "+ getTableName();
		String whereString="";
		
		StringBuilder whereStringBuilder = new StringBuilder();
		ArrayList param = new ArrayList();

		if(cond.getTransactionCd() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" KODE_TRANSAKSI = ?");
			param.add(cond.getTransactionCd());
		}

		if(cond.getTransactionName() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" NAMA_TRANSAKSI = ?");
			param.add(cond.getTransactionName());
		}

		whereString = whereStringBuilder.toString();
		String sqlString = selectString + whereString;
		SqlCondition sqlCond = new SqlCondition(sqlString, param.toArray());

		return sqlCond;
	}

	@Override
	protected SqlCondition createInsertSQLCondition(BpaJenisTransaksiTableRecord newRecord) {
		String insertString = "INSERT INTO " + getTableName() + " VALUES (?,?,?)";
		ArrayList param = new ArrayList();
		param.add(newRecord.getTransactionCd());
		param.add(newRecord.getTransactionName());
		param.add(newRecord.getDebitCredit());
		SqlCondition sqlCond = new SqlCondition(insertString, param.toArray());
		return sqlCond;
	}

	@Override
	protected SqlCondition createUpdateSQLCondition(BpaJenisTransaksiTableRecord updateRecord, SearchCondition updateCondition) {
		BpaJenisTransaksiSrcCond cond = (BpaJenisTransaksiSrcCond) updateCondition;
		String updateString = "UPDATE "+ getTableName() + " SET";
		String columnString="";
		String whereString="";
		
		StringBuilder columnStringBuilder = new StringBuilder();
		StringBuilder whereStringBuilder = new StringBuilder();
		ArrayList param = new ArrayList();
		
		// for set column_name = column_value
		if(updateRecord.getTransactionCd() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" KODE_TRANSAKSI=?");
			param.add(updateRecord.getTransactionCd());
		}
		
		if(updateRecord.getTransactionName() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" NAMA_TRANSAKSI=?");
			param.add(updateRecord.getTransactionName());
		}
		
		if(updateRecord.getDebitCredit() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" DEBIT_KREDIT=?");
			param.add(updateRecord.getDebitCredit());
		}

		// for where condition
		if(cond.getTransactionCd() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" KODE_TRANSAKSI=?");
			param.add(cond.getTransactionCd());
		}

		columnString = columnStringBuilder.toString();
		whereString = whereStringBuilder.toString();
		String sqlString = updateString + columnString + whereString;
		SqlCondition sqlCond = new SqlCondition(sqlString, param.toArray());
		return sqlCond;
	}

	@Override
	protected SqlCondition createDeleteSQLCondition(SearchCondition deleteCondition) {
		BpaJenisTransaksiSrcCond cond = (BpaJenisTransaksiSrcCond) deleteCondition;
		String deleteString = "DELETE FROM "+ getTableName();
		String whereString="";
		
		StringBuilder whereStringBuilder = new StringBuilder();
		ArrayList param = new ArrayList();

		if(cond.getTransactionCd() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" KODE_TRANSAKSI=?");
			param.add(cond.getTransactionCd());
		}

		whereString = whereStringBuilder.toString();
		String sqlString = deleteString + whereString;
		SqlCondition sqlCond = new SqlCondition(sqlString, param.toArray());

		return sqlCond;
	}

	@Override
	protected BpaJenisTransaksiTableRecord createRecord() {
		return new BpaJenisTransaksiTableRecord();
	}
	
}
