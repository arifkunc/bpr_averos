package net.plaut.dbutil.test;

import net.plaut.dbutil.dao.TableRecord;

public class TesRecord extends TableRecord{
	private String no;
	private String nama;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
}
