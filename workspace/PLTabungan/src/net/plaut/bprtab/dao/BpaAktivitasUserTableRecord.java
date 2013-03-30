package net.plaut.bprtab.dao;

import java.sql.Time;
import java.sql.Types;

import net.plaut.dbutil.dao.TableRecord;
import net.plaut.dbutil.object.DbFieldAttribute;

public class BpaAktivitasUserTableRecord extends TableRecord{

	public static DbFieldAttribute[] fieldAttributeArray = 
	{
		new DbFieldAttribute(1, "ID", true, Types.INTEGER),
		new DbFieldAttribute(2, "WAKTU", false, Types.TIME),
		new DbFieldAttribute(3, "USERNAME", false, Types.VARCHAR),
		new DbFieldAttribute(4, "AKTIVITAS", false, Types.VARCHAR)
	};
	
	public BpaAktivitasUserTableRecord(){
		super(BpaAktivitasUserTableRecord.fieldAttributeArray);
	}
	
	public Integer getId() {
		return (Integer) getValue("ID");
	}
	public void setId(Integer id) {
		setValue("ID", id);
	}
	public Time getWaktu() {
		return (Time) getValue("WAKTU");
	}
	public void setWaktu(Time time) {
		setValue("WAKTU", time);
	}
	public String getUsername() {
		return (String) getValue("USERNAME");
	}
	public void setUsername(String username) {
		setValue("USERNAME", username);
	}
	public String getAktivitas() {
		return (String) getValue("AKTIVITAS");
	}
	public void setAktivitas(String aktivitas) {
		setValue("AKTIVITAS", aktivitas);
	}
}
