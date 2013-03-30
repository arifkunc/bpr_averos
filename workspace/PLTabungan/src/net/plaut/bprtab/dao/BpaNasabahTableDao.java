package net.plaut.bprtab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import net.plaut.bprtab.dao.condition.BpaNasabahSrcCond;
import net.plaut.bprtab.dao.condition.BpaUserSrcCond;
import net.plaut.dbutil.dao.TableDao;
import net.plaut.dbutil.object.DeleteCondition;
import net.plaut.dbutil.object.SearchCondition;
import net.plaut.dbutil.object.SqlCondition;
import net.plaut.dbutil.object.UpdateCondition;

public class BpaNasabahTableDao extends TableDao<BpaNasabahTableRecord> {

	@Override
	public String getTableName() {
		return "BPA_NASABAH";
	}

	@Override
	protected SqlCondition createSelectSQLCondition(SearchCondition searchCondition) {
		BpaNasabahSrcCond cond = (BpaNasabahSrcCond) searchCondition;
		String selectString = "SELECT * FROM "+ getTableName();
		String whereString="";
		
		StringBuilder whereStringBuilder = new StringBuilder();
		ArrayList param = new ArrayList();

		if(cond.getNoRekening() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" NO_REKENING = ?");
			param.add(cond.getNoRekening());
		}

		if(cond.getNamaLengkap() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" NAMA_LENGKAP = ?");
			param.add(cond.getNamaLengkap());
		}
		
		if(cond.getNis() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" NIS = ?");
			param.add(cond.getNis());
		}

		whereString = whereStringBuilder.toString();
		String sqlString = selectString + whereString;
		SqlCondition sqlCond = new SqlCondition(sqlString, param.toArray());

		return sqlCond;
	}

	@Override
	protected SqlCondition createInsertSQLCondition(BpaNasabahTableRecord newRecord) {
		String insertString = "INSERT INTO " + getTableName() + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		ArrayList param = new ArrayList();
		param.add(newRecord.getNoRekening());
		param.add(newRecord.getNamaLengkap());
		param.add(newRecord.getNis());
		param.add(newRecord.getKelas());
		param.add(newRecord.getGender());
		param.add(newRecord.getAlamat());
		param.add(newRecord.getNamaOrangTua());
		param.add(newRecord.getNoKontak());
		param.add(newRecord.getSaldo());
		param.add(newRecord.getTglDaftar());
		SqlCondition sqlCond = new SqlCondition(insertString, param.toArray());
		return sqlCond;
	}

	@Override
	protected SqlCondition createUpdateSQLCondition(BpaNasabahTableRecord updateRecord, SearchCondition updateCondition) {
		BpaNasabahSrcCond cond = (BpaNasabahSrcCond) updateCondition;
		String updateString = "UPDATE "+ getTableName() + " SET";
		String columnString="";
		String whereString="";
		
		StringBuilder columnStringBuilder = new StringBuilder();
		StringBuilder whereStringBuilder = new StringBuilder();
		ArrayList param = new ArrayList();
		
		// for set column_name = column_value
		if(updateRecord.getNoRekening() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" NO_REKENING=?");
			param.add(updateRecord.getNoRekening());
		}
		
		if(updateRecord.getNamaLengkap() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" NAMA_LENGKAP=?");
			param.add(updateRecord.getNamaLengkap());
		}
		
		if(updateRecord.getNis() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" NIS=?");
			param.add(updateRecord.getNis());
		}
		
		if(updateRecord.getKelas() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" KELAS=?");
			param.add(updateRecord.getKelas());
		}
		
		if(updateRecord.getGender() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" GENDER=?");
			param.add(updateRecord.getGender());
		}
		
		if(updateRecord.getAlamat() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" ALAMAT=?");
			param.add(updateRecord.getAlamat());
		}
		
		if(updateRecord.getNamaOrangTua() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" NAMA_ORANGTUA=?");
			param.add(updateRecord.getNamaOrangTua());
		}
		
		if(updateRecord.getNoKontak() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" TELEPON=?");
			param.add(updateRecord.getNoKontak());
		}
		
		if(updateRecord.getSaldo() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" SALDO=?");
			param.add(updateRecord.getSaldo());
		}
		
		if(updateRecord.getTglDaftar() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" TGL_DAFTAR=?");
			param.add(updateRecord.getTglDaftar());
		}
		
		if(updateRecord.getKet() != null){
			if(columnStringBuilder.length()>0){
				columnStringBuilder.append(",");
			}
			columnStringBuilder.append(" KET=?");
			param.add(updateRecord.getKet());
		}

		// for where condition
		if(cond.getNoRekening() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" NO_REKENING=?");
			param.add(cond.getNoRekening());
		}

		columnString = columnStringBuilder.toString();
		whereString = whereStringBuilder.toString();
		String sqlString = updateString + columnString + whereString;
		SqlCondition sqlCond = new SqlCondition(sqlString, param.toArray());
		return sqlCond;
	}

	@Override
	protected SqlCondition createDeleteSQLCondition(SearchCondition deleteCondition) {
		BpaNasabahSrcCond cond = (BpaNasabahSrcCond) deleteCondition;
		String deleteString = "DELETE FROM "+ getTableName();
		String whereString="";
		
		StringBuilder whereStringBuilder = new StringBuilder();
		ArrayList param = new ArrayList();

		if(cond.getNoRekening() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append(" WHERE");
			}
			whereStringBuilder.append(" NO_REKENING=?");
			param.add(cond.getNoRekening());
		}

		whereString = whereStringBuilder.toString();
		String sqlString = deleteString + whereString;
		SqlCondition sqlCond = new SqlCondition(sqlString, param.toArray());

		return sqlCond;
	}

	@Override
	protected BpaNasabahTableRecord setRecord(ResultSet rs) throws SQLException {
		BpaNasabahTableRecord record = new BpaNasabahTableRecord();
		record.setNoRekening(rs.getString("NO_REKENING"));
		record.setNamaLengkap(rs.getString("NAMA_LENGKAP"));
		record.setNis(rs.getString("NIS"));
		record.setKelas(rs.getString("KELAS"));
		record.setGender(rs.getString("GENDER"));
		record.setAlamat(rs.getString("ALAMAT"));
		record.setNamaOrangTua(rs.getString("NAMA_ORANGTUA"));
		record.setNoKontak(rs.getString("TELEPON"));
		record.setSaldo(rs.getDouble("SALDO"));
		record.setTglDaftar(rs.getDate("TGL_DAFTAR"));
		record.setKet(rs.getString("KET"));

		return record;
	}
	
}
