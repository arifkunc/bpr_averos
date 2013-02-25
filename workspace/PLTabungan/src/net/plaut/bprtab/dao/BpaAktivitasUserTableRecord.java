package net.plaut.bprtab.dao;

import java.sql.Time;

import net.plaut.dbutil.dao.TableRecord;

public class BpaAktivitasUserTableRecord extends TableRecord{
	private Integer id;
	private Time waktu;
	private String username;
	private String aktivitas;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Time getWaktu() {
		return waktu;
	}
	public void setWaktu(Time waktu) {
		this.waktu = waktu;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAktivitas() {
		return aktivitas;
	}
	public void setAktivitas(String aktivitas) {
		this.aktivitas = aktivitas;
	}
}
