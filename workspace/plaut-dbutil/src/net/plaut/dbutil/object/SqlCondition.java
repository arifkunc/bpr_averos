package net.plaut.dbutil.object;

public class SqlCondition {
	private String sqlString;
	private Object[] parameters;
	
	public SqlCondition(String sqlString, Object[] parameters) {
		this.sqlString = sqlString;
		this.parameters = parameters;
	}
	
	public String getSqlString() {
		return sqlString;
	}
	public void setSqlString(String sqlString) {
		this.sqlString = sqlString;
	}
	public Object[] getParameters() {
		return parameters;
	}
	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}
}
