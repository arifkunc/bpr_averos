package net.plaut.dbutil.dao;

import net.plaut.dbutil.object.DbFieldAttribute;

public class TableRecord extends DbRecord implements Cloneable{
	
	protected TableRecord(DbFieldAttribute[] dbFieldAttributeArray) {
		super(dbFieldAttributeArray);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return (TableRecord)super.clone();
	}
}
