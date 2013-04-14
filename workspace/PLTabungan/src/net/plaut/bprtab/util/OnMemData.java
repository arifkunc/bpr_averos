package net.plaut.bprtab.util;

public class OnMemData {
	private OnMemData(){
		
	}
	
	private static OnMemData instance = new OnMemData();
	
	public static OnMemData getInstance(){
		return instance;
	}
}
