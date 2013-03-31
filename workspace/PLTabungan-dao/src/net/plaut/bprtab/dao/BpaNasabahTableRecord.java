package net.plaut.bprtab.dao;

import java.sql.Date;
import java.sql.Types;

import net.plaut.dbutil.dao.TableRecord;
import net.plaut.dbutil.object.DbFieldAttribute;

public class BpaNasabahTableRecord extends TableRecord{
	
	public static final DbFieldAttribute[] fieldAttributeArray = 
	{
		new DbFieldAttribute(1, "NO_REKENING", true, Types.VARCHAR),
		new DbFieldAttribute(2, "NAMA_LENGKAP", false, Types.VARCHAR),
		new DbFieldAttribute(3, "NIS", false, Types.VARCHAR),
		new DbFieldAttribute(4, "KELAS", false, Types.VARCHAR),
		new DbFieldAttribute(5, "GENDER", false, Types.VARCHAR),
		new DbFieldAttribute(6, "ALAMAT", false, Types.VARCHAR),
		new DbFieldAttribute(7, "NAMA_ORANGTUA", false, Types.VARCHAR),
		new DbFieldAttribute(8, "TELEPON", false, Types.VARCHAR),
		new DbFieldAttribute(9, "SALDO", false, Types.DECIMAL),
		new DbFieldAttribute(10, "TGL_DAFTAR", false, Types.DATE),
		new DbFieldAttribute(11, "KET", false, Types.VARCHAR),
	};
	
	public BpaNasabahTableRecord(){
		super(BpaNasabahTableRecord.fieldAttributeArray);
	}
	
	public String getNoRekening() {
		return (String) getValue("NO_REKENING");
	}
	public void setNoRekening(String noRekening) {
		setValue("NO_REKENING", noRekening);
	}
	public String getNamaLengkap() {
		return (String) getValue("NAMA_LENGKAP");
	}
	public void setNamaLengkap(String namaLengkap) {
		setValue("NAMA_LENGKAP", namaLengkap);
	}
	public String getNis() {
		return (String) getValue("NIS");
	}
	public void setNis(String nis) {
		setValue("NIS", nis);
	}
	public String getKelas() {
		return (String) getValue("KELAS");
	}
	public void setKelas(String kelas) {
		setValue("KELAS", kelas);
	}
	public String getGender() {
		return (String) getValue("GENDER");
	}
	public void setGender(String gender) {
		setValue("GENDER", gender);
	}
	public String getAlamat() {
		return (String) getValue("ALAMAT");
	}
	public void setAlamat(String alamat) {
		setValue("ALAMAT", alamat);
	}
	public String getNamaOrangTua() {
		return (String) getValue("NAMA_ORANGTUA");
	}
	public void setNamaOrangTua(String namaOrangTua) {
		setValue("NAMA_ORANGTUA", namaOrangTua);
	}
	public String getNoKontak() {
		return (String) getValue("TELEPON");
	}
	public void setNoKontak(String noKontak) {
		setValue("TELEPON", noKontak);
	}
	public Double getSaldo() {
		return (Double) getValue("SALDO");
	}
	public void setSaldo(Double saldo) {
		setValue("SALDO", saldo);
	}
	public Date getTglDaftar() {
		return (Date) getValue("TGL_DAFTAR");
	}
	public void setTglDaftar(Date tanggalDaftar) {
		setValue("TGL_DAFTAR", tanggalDaftar);
	}
	public String getKet() {
		return (String) getValue("KET");
	}
	public void setKet(String ket) {
		setValue("KET", ket);
	}
	
}
