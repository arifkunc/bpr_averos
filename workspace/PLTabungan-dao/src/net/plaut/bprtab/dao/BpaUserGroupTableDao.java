package net.plaut.bprtab.dao;

import java.util.List;

import net.plaut.bprtab.dao.condition.BpaUserGroupSrcCond;
import net.plaut.dbutil.dao.TableDao;
import net.plaut.dbutil.object.SearchCondition;

public class BpaUserGroupTableDao extends TableDao<BpaUserGroupTableRecord> {

	private static BpaUserGroupTableDao instance = new BpaUserGroupTableDao();
	
	private BpaUserGroupTableDao(){}
	
	public static BpaUserGroupTableDao getInstance(){
		return instance;
	}
	
	public static final String TABLE_NAME = "BPA_USER_GROUP";
	
	public static String SELECT_FROM = "SELECT ID, GROUP_NAME FROM BPA_USER_GROUP";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	protected BpaUserGroupTableRecord createRecord() {
		return new BpaUserGroupTableRecord();
	}

	@Override
	public String getSelectFromSql() {
		return SELECT_FROM;
	}

	@Override
	public String createStringCondition(SearchCondition searchCondition, List bindParams) {
		BpaUserGroupSrcCond cond = (BpaUserGroupSrcCond) searchCondition;
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

		return whereStringBuilder.toString();
	}
	
}
