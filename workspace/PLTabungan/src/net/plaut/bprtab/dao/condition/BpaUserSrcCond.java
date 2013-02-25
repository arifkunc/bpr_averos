package net.plaut.bprtab.dao.condition;

import net.plaut.dbutil.object.SearchCondition;

public class BpaUserSrcCond implements SearchCondition{
	private String username;
	private String password;
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
}
