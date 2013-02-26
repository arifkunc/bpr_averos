package net.plaut.bprtab.komp.model;

public class LoginModel {
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void resetModel() {
		userName = "";
		password = "";
	}

}