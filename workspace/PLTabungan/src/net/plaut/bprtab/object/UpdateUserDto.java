package net.plaut.bprtab.object;

public class UpdateUserDto extends AddUserDto{
	private String oldUsername;
	
	public String getOldUsername() {
		return oldUsername;
	}
	public void setOldUsername(String oldUsername) {
		this.oldUsername = oldUsername;
	}
	
}
