package net.plaut.bprtab.dao;

import java.util.List;

import net.plaut.bprtab.dao.condition.BpaNasabahSrcCond;
import net.plaut.dbutil.dao.TableDao;
import net.plaut.dbutil.object.SearchCondition;

public class BpaNasabahTableDao extends TableDao<BpaNasabahTableRecord> {

	private static BpaNasabahTableDao instance = new BpaNasabahTableDao();
	
	private BpaNasabahTableDao(){}
	
	public static BpaNasabahTableDao getInstance(){
		return instance;
	}
	
	public static String TABLE_NAME = "BPA_NASABAH";
	
	public static String SELECT_FROM = "SELECT NO_REKENING, NAMA_LENGKAP, NIS, KELAS, GENDER, ALAMAT, NAMA_ORANGTUA, TELEPON, SALDO, TGL_DAFTAR, KET FROM BPA_NASABAH";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	protected BpaNasabahTableRecord createRecord() {
		return new BpaNasabahTableRecord();
	}

	@Override
	public String getSelectFromSql() {
		return SELECT_FROM;
	}

	@Override
	public String createStringCondition(SearchCondition searchCondition, List bindParams) {
		BpaNasabahSrcCond cond = (BpaNasabahSrcCond) searchCondition;
		StringBuilder whereStringBuilder = new StringBuilder();

		if(cond.getNoRekening() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append("WHERE");
			}
			whereStringBuilder.append(" NO_REKENING = ?");
			bindParams.add(cond.getNoRekening());
		}

		if(cond.getNamaLengkap() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append("WHERE");
			}
			whereStringBuilder.append(" NAMA_LENGKAP = ?");
			bindParams.add(cond.getNamaLengkap());
		}

		if(cond.getNis() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append("WHERE");
			}
			whereStringBuilder.append(" NIS = ?");
			bindParams.add(cond.getNis());
		}

		return whereStringBuilder.toString();}

}
