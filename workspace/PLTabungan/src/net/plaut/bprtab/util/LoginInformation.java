package net.plaut.bprtab.util;

import net.plaut.bprtab.constant.DbConstant;

public class LoginInformation {	
	private LoginInformation(){
		resetLoginInformation();
	}
	
	public static LoginInformation instance;
	
	public static LoginInformation getInstance(){
		if(instance == null)
			instance = new LoginInformation();
		return instance;
	}
	
	private boolean isLogin;
	private String username;
	private String password;
	private String userGroup;
	
	public void resetLoginInformation(){
		isLogin = false;
		username = "";
		password = "";
		userGroup = DbConstant.USER_GROUP_NO_USER;
	}

	public boolean isLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
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
	public String getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
}
