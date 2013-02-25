package net.plaut.bprtab.tesmvc;

import net.plaut.common.util.PropertiesReader;

public class TesProperty {
	public static void main(String []args){
		PropertiesReader r = new PropertiesReader("prop/config.properties");
		System.out.println(r.getProperty("db.hostname"));
		System.out.println(r.getProperty("db.password"));
	}
}
