package net.plaut.bprtab.dao.condition;

import net.plaut.dbutil.object.SearchCondition;

public class BpaAktivitasUserSrcCond implements SearchCondition{
	private String id;
	private String username;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
