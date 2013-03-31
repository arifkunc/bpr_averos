package net.plaut.bprtab.dao.condition;

import net.plaut.dbutil.object.SearchCondition;

public class BpaUserGroupSrcCond implements SearchCondition{
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
