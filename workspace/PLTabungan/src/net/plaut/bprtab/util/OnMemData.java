package net.plaut.bprtab.util;

public class OnMemData {
	private OnMemData(){
		
	}
	
	private static OnMemData instance = new OnMemData();
	
	public static OnMemData getInstance(){
		return instance;
	}
	
	private String[] usernameData;

	public String[] getUsernameData() {
		return usernameData;
	}

	public void setUsernameData(String[] usernameData) {
		this.usernameData = usernameData;
	}
	
	
}
