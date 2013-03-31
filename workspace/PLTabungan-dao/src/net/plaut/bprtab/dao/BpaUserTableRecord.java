package net.plaut.bprtab.dao;

import java.sql.Types;

import net.plaut.dbutil.dao.TableRecord;
import net.plaut.dbutil.object.DbFieldAttribute;

public class BpaUserTableRecord extends TableRecord{

	public static final DbFieldAttribute[] fieldAttributeArray = 
	{
		new DbFieldAttribute(1, "USERNAME", true, Types.VARCHAR),
		new DbFieldAttribute(2, "PASSWORD", false, Types.VARCHAR),
		new DbFieldAttribute(3, "GROUP_ID", false, Types.VARCHAR)
	};
	
	public BpaUserTableRecord(){
		super(BpaUserTableRecord.fieldAttributeArray);
	}
	
	public String getUsername() {
		return (String) getValue("USERNAME");
	}
	public void setUsername(String username) {
		setValue("USERNAME", username);
	}
	public String getPassword() {
		return (String) getValue("PASSWORD");
	}
	public void setPassword(String password) {
		setValue("PASSWORD", password);
	}
	public String getGroupId() {
		return (String) getValue("GROUP_ID");
	}
	public void setGroupId(String groupId) {
		setValue("GROUP_ID", groupId);
	}
	
	
}
