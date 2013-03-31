package net.plaut.bprtab.dao.condition;

import java.sql.Date;

import net.plaut.dbutil.object.SearchCondition;

public class BpaTransaksiSrcCond implements SearchCondition{
	private Integer id;
	private String kodeTransaksi;
	private Date tglTransaksi;
	private String noRekening;
	private Double nominal;
	private Double saldo;
	private String username;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKodeTransaksi() {
		return kodeTransaksi;
	}
	public void setKodeTransaksi(String kodeTransaksi) {
		this.kodeTransaksi = kodeTransaksi;
	}
	public Date getTglTransaksi() {
		return tglTransaksi;
	}
	public void setTglTransaksi(Date tglTransaksi) {
		this.tglTransaksi = tglTransaksi;
	}
	public String getNoRekening() {
		return noRekening;
	}
	public void setNoRekening(String noRekening) {
		this.noRekening = noRekening;
	}
	public Double getNominal() {
		return nominal;
	}
	public void setNominal(Double nominal) {
		this.nominal = nominal;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
