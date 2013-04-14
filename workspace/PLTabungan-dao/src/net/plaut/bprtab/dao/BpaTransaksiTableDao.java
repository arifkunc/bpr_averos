package net.plaut.bprtab.dao;

import java.util.ArrayList;

import net.plaut.bprtab.dao.condition.BpaTransaksiSrcCond;
import net.plaut.dbutil.dao.TableDao;
import net.plaut.dbutil.object.SearchCondition;
import net.plaut.dbutil.object.SqlCondition;

public class BpaTransaksiTableDao extends TableDao<BpaTransaksiTableRecord> {

	@Override
	public String getTableName() {
		return "BPA_TRANSAKSI";
	}

	@Override
	protected SqlCondition createSelectSQLCondition(SearchCondition searchCondition) {
		BpaTransaksiSrcCond cond = (BpaTransaksiSrcCond) searchCondition;
		String selectString = "SELECT * FROM "+ getTableName();
		String whereString="";
		
		StringBuilder whereStringBuilder = new StringBuilder();
		ArrayList param = new ArrayList();

		if(cond.getId() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" ID = ?");
			param.add(cond.getId());
		}

		if(cond.getNoRekening() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" NO_REKENING = ?");
			param.add(cond.getNoRekening());
		}

		whereString = whereStringBuilder.toString();
		String sqlString = selectString + whereString;
		SqlCondition sqlCond = new SqlCondition(sqlString, param.toArray());

		return sqlCond;
	}

	@Override
	protected SqlCondition createInsertSQLCondition(BpaTransaksiTableRecord newRecord) {
		String insertString = "INSERT INTO " + getTableName() + " VALUES (?,?,?,?,?,?,?)";
		ArrayList param = new ArrayList();
		param.add(newRecord.getId());
		param.add(newRecord.getKodeTransaksi());
		param.add(newRecord.getTglTransaksi());
		param.add(newRecord.getNoRekening());
		param.add(newRecord.getNominal());
		param.add(newRecord.getSaldo());
		param.add(newRecord.getUsername());
		SqlCondition sqlCond = new SqlCondition(insertString, param.toArray());
		return sqlCond;
	}

	@Override
	protected SqlCondition createUpdateSQLCondition(BpaTransaksiTableRecord updateRecord, SearchCondition updateCondition) {
		BpaTransaksiSrcCond cond = (BpaTransaksiSrcCond) updateCondition;
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
		
		if(updateRecord.getKodeTransaksi() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" KODE_TRANSAKSI=?");
			param.add(updateRecord.getKodeTransaksi());
		}
		
		if(updateRecord.getTglTransaksi() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" TANGGAL_TRANSAKSI=?");
			param.add(updateRecord.getTglTransaksi());
		}
		
		if(updateRecord.getNoRekening() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" NO_REKENING=?");
			param.add(updateRecord.getNoRekening());
		}
		
		if(updateRecord.getNominal() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" NOMINAL=?");
			param.add(updateRecord.getNominal());
		}
		
		if(updateRecord.getSaldo() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" SALDO=?");
			param.add(updateRecord.getSaldo());
		}
		
		if(updateRecord.getUsername() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" USERNAME=?");
			param.add(updateRecord.getUsername());
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
		BpaTransaksiSrcCond cond = (BpaTransaksiSrcCond) deleteCondition;
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
	protected BpaTransaksiTableRecord createRecord() {
		return new BpaTransaksiTableRecord();
	}
	
}
