package net.plaut.bprtab.dao;

import java.util.List;

import net.plaut.bprtab.dao.condition.BpaUserSrcCond;
import net.plaut.dbutil.dao.TableDao;
import net.plaut.dbutil.object.SearchCondition;

public class BpaUserTableDao extends TableDao<BpaUserTableRecord>{

	private static BpaUserTableDao instance = new BpaUserTableDao();
	
	private BpaUserTableDao(){}
	
	public static BpaUserTableDao getInstance(){
		return instance;
	}
	
	public static final String TABLE_NAME = "BPA_USER";
	
	public static String SELECT_FROM = "SELECT USERNAME, PASSWORD, GROUP_ID FROM BPA_USER";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	protected BpaUserTableRecord createRecord() {
		return new BpaUserTableRecord();
	}

	@Override
	public String getSelectFromSql() {
		return SELECT_FROM;
	}

	@Override
	public String createStringCondition(SearchCondition searchCondition, List bindParams) {
		BpaUserSrcCond cond = (BpaUserSrcCond) searchCondition;
		StringBuilder whereStringBuilder = new StringBuilder();
		

		if(cond.getUsername() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append("WHERE");
			}
			whereStringBuilder.append(" USERNAME = ?");
			bindParams.add(cond.getUsername());
		}

		if(cond.getPassword() != null){
			if(whereStringBuilder.length() > 0){
				whereStringBuilder.append(" AND");
			} else {
				whereStringBuilder.append("WHERE");
			}
			whereStringBuilder.append(" PASSWORD = MD5(?)");
			bindParams.add(cond.getPassword());
		}

		return whereStringBuilder.toString();
		
	}

}
