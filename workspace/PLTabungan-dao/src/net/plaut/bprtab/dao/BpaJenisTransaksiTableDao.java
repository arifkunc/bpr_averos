package net.plaut.bprtab.dao;

import java.util.List;

import net.plaut.bprtab.dao.condition.BpaJenisTransaksiSrcCond;
import net.plaut.dbutil.dao.TableDao;
import net.plaut.dbutil.object.SearchCondition;

public class BpaJenisTransaksiTableDao extends TableDao<BpaJenisTransaksiTableRecord> {

	private static BpaJenisTransaksiTableDao instance = new BpaJenisTransaksiTableDao();
	
	private BpaJenisTransaksiTableDao(){}
	
	public static BpaJenisTransaksiTableDao getInstance(){
		return instance;
	}
	
	public static String TABLE_NAME = "BPA_JENIS_TRANSAKSI";
	
	public static String SELECT_FROM = "SELECT KODE_TRANSAKSI, NAMA_TRANSAKSI, DEBIT_KREDIT FROM BPA_JENIS_TRANSAKSI";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	protected BpaJenisTransaksiTableRecord createRecord() {
		return new BpaJenisTransaksiTableRecord();
	}

	@Override
	public String getSelectFromSql() {
		return SELECT_FROM;
	}

	@Override
	public String createStringCondition(SearchCondition searchCondition, List bindParams) {
		BpaJenisTransaksiSrcCond cond = (BpaJenisTransaksiSrcCond) searchCondition;
		
		StringBuilder whereStringBuilder = new StringBuilder();
		
		if(cond.getTransactionCd() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append("WHERE");
			}
			whereStringBuilder.append(" KODE_TRANSAKSI = ?");
			bindParams.add(cond.getTransactionCd());
		}

		if(cond.getTransactionName() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append("WHERE");
			}
			whereStringBuilder.append(" NAMA_TRANSAKSI = ?");
			bindParams.add(cond.getTransactionName());
		}

		return whereStringBuilder.toString();
	}
	
}
