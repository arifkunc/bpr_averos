package net.plaut.bprtab.dao;

import java.util.List;

import net.plaut.bprtab.dao.condition.BpaTransaksiSrcCond;
import net.plaut.dbutil.dao.TableDao;
import net.plaut.dbutil.object.SearchCondition;

public class BpaTransaksiTableDao extends TableDao<BpaTransaksiTableRecord> {
	
	private static BpaTransaksiTableDao instance = new BpaTransaksiTableDao();
	
	private BpaTransaksiTableDao(){}
	
	public static BpaTransaksiTableDao getInstance(){
		return instance;
	}
	
	public static String TABLE_NAME = "BPA_TRANSAKSI";
	
	public static String SELECT_FROM = "SELECT ID, KODE_TRANSAKSI, TANGGAL_TRANSAKSI, NO_REKENING, NOMINAL, SALDO, USERNAME FROM BPA_TRANSAKSI";

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	protected BpaTransaksiTableRecord createRecord() {
		return new BpaTransaksiTableRecord();
	}

	@Override
	public String getSelectFromSql() {
		return SELECT_FROM;
	}

	@Override
	public String createStringCondition(SearchCondition searchCondition, List bindParams) {
		BpaTransaksiSrcCond cond = (BpaTransaksiSrcCond) searchCondition;
		StringBuilder whereStringBuilder = new StringBuilder();
		
		if(cond.getId() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append("WHERE");
			}
			whereStringBuilder.append(" ID = ?");
			bindParams.add(cond.getId());
		}

		if(cond.getNoRekening() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append("WHERE");
			}
			whereStringBuilder.append(" NO_REKENING = ?");
			bindParams.add(cond.getNoRekening());
		}

		return whereStringBuilder.toString();
	}
	
}
