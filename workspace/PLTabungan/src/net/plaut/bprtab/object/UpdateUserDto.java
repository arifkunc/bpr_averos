package net.plaut.bprtab.object;

public class UpdateUserDto {
	private String oldUsername;
	private String username;
	private String password;
	private String groupLevelId;
	
	public String getOldUsername() {
		return oldUsername;
	}
	public void setOldUsername(String oldUsername) {
		this.oldUsername = oldUsername;
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
	public String getGroupLevelId() {
		return groupLevelId;
	}
	public void setGroupLevelId(String groupLevelId) {
		this.groupLevelId = groupLevelId;
	}
	
}
