package net.plaut.dbutil.dao;


public abstract class QueryDao<R extends QueryRecord> extends DbDao<R>{
	
	protected abstract String getSelectQuery();
}
