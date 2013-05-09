package net.plaut.bprtab.object;

import java.util.Date;

public class UpdateNasabahDto{
	private String rekeningNo;
	private String namaLengkap;
	private String nis;
	private String kelas;
	private String gender;
	private String alamat;
	private String namaOrangTua;
	private String telepon;
	private double saldo;
	private Date tanggalDaftar;
	private String ket;

	public String getRekeningNo() {
		return rekeningNo;
	}

	public void setRekeningNo(String rekeningNo) {
		this.rekeningNo = rekeningNo;
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

	public String getTelepon() {
		return telepon;
	}

	public void setTelepon(String telepon) {
		this.telepon = telepon;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Date getTanggalDaftar() {
		return tanggalDaftar;
	}

	public void setTanggalDaftar(Date tanggalDaftar) {
		this.tanggalDaftar = tanggalDaftar;
	}

	public String getKet() {
		return ket;
	}

	public void setKet(String ket) {
		this.ket = ket;
	}

}
