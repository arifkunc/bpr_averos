package net.plaut.bprtab.dao;

import java.sql.Date;

import net.plaut.dbutil.dao.TableRecord;

public class BpaNasabahTableRecord extends TableRecord{
	private String noRekening;
	private String namaLengkap;
	private String nis;
	private String kelas;
	private String gender;
	private String alamat;
	private String namaOrangTua;
	private String noKontak;
	private Double saldo;
	private Date tglDaftar;
	private String ket;
	
	public String getNoRekening() {
		return noRekening;
	}
	public void setNoRekening(String noRekening) {
		this.noRekening = noRekening;
	}
	public String getNamaLengkap() {
		return namaLengkap;
	}
	public void setNamaLengkap(String namaLengkap) {
		this.namaLengkap = namaLengkap;
	}
	public String getNis() {
		return nis;
	}
	public void setNis(String nis) {
		this.nis = nis;
	}
	public String getKelas() {
		return kelas;
	}
	public void setKelas(String kelas) {
		this.kelas = kelas;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getNamaOrangTua() {
		return namaOrangTua;
	}
	public void setNamaOrangTua(String namaOrangTua) {
		this.namaOrangTua = namaOrangTua;
	}
	public String getNoKontak() {
		return noKontak;
	}
	public void setNoKontak(String noKontak) {
		this.noKontak = noKontak;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Date getTglDaftar() {
		return tglDaftar;
	}
	public void setTglDaftar(Date tanggalDaftar) {
		this.tglDaftar = tanggalDaftar;
	}
	public String getKet() {
		return ket;
	}
	public void setKet(String ket) {
		this.ket = ket;
	}
}
