package net.plaut.bprtab.komp.model;

public class TambahUserModel {
	private String userName;
	private String password;
	private String idGroupLevel;

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

	public String getIdGroupLevel() {
		return idGroupLevel;
	}

	public void setIdGroupLevel(String idGroupLevel) {
		this.idGroupLevel = idGroupLevel;
	}

	private void resetModel() {
		userName = "";
		password = "";
		idGroupLevel = "";
	}

}
