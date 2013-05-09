package net.plaut.bprtab.dao;

import java.util.List;

import net.plaut.bprtab.dao.condition.BpaAktivitasUserSrcCond;
import net.plaut.dbutil.dao.TableDao;
import net.plaut.dbutil.object.SearchCondition;

public class BpaAktivitasUserTableDao extends TableDao<BpaAktivitasUserTableRecord> {
	
	private static BpaAktivitasUserTableDao instance = new BpaAktivitasUserTableDao();
	
	private BpaAktivitasUserTableDao(){}
	
	public static BpaAktivitasUserTableDao getInstance(){
		return instance;
	}

	public final static String TABLE_NAME = "BPA_AKTIVITAS_USER";
	
	public final static String SELECT_FROM = "SELECT ID, WAKTU, USERNAME, AKTIVITAS FROM BPA_AKTIVITAS_USER";

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	protected BpaAktivitasUserTableRecord createRecord() {
		return new BpaAktivitasUserTableRecord();
	}

	@Override
	public String getSelectFromSql() {
		return SELECT_FROM;
	}

	@Override
	public String createStringCondition(SearchCondition searchCondition, List bindParams) {
		StringBuilder whereStringBuilder = new StringBuilder();
		BpaAktivitasUserSrcCond cond = (BpaAktivitasUserSrcCond) searchCondition;

		if(cond.getId() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append("WHERE");
			}
			whereStringBuilder.append(" ID = ?");
			bindParams.add(cond.getUsername());
		}

		if(cond.getUsername() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append("WHERE");
			}
			whereStringBuilder.append(" USERNAME = ?");
			bindParams.add(cond.getUsername());
		}

		return whereStringBuilder.toString();
	}
}
