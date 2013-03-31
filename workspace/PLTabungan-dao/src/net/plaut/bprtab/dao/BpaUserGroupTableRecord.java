package net.plaut.bprtab.dao;

import java.sql.Types;

import net.plaut.dbutil.dao.TableRecord;
import net.plaut.dbutil.object.DbFieldAttribute;

public class BpaUserGroupTableRecord extends TableRecord{
	
	public static final DbFieldAttribute[] fieldAttributeArray = 
	{
		new DbFieldAttribute(1, "ID", true, Types.VARCHAR),
		new DbFieldAttribute(2, "GROUP_NAME", false, Types.VARCHAR)
	};
	
	public BpaUserGroupTableRecord(){
		super(BpaUserGroupTableRecord.fieldAttributeArray);
	}
	
	public String getId() {
		return (String) getValue("ID");
	}
	public void setId(String id) {
		setValue("ID", id);
	}
	public String getGroupName() {
		return (String) getValue("GROUP_NAME");
	}
	public void setGroupName(String groupName) {
		setValue("GROUP_NAME", groupName);
	}
	
	
}
