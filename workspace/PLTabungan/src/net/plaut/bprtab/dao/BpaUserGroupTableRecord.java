package net.plaut.bprtab.dao;

import net.plaut.dbutil.dao.TableRecord;

public class BpaUserGroupTableRecord extends TableRecord{
	private String id;
	private String groupName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
}
