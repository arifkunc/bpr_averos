package net.plaut.bprtab.dao;

import net.plaut.dbutil.dao.TableRecord;

public class BpaUserTableRecord extends TableRecord{
	private String username;
	private String password;
	private String group;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	
}
