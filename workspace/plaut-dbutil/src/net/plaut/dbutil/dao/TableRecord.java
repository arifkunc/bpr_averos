package net.plaut.dbutil.dao;

public class TableRecord extends DbRecord implements Cloneable{
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (TableRecord)super.clone();
	}
}
