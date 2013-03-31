package net.plaut.bprtab.dao;

import java.sql.Date;
import java.sql.Types;

import net.plaut.dbutil.dao.TableRecord;
import net.plaut.dbutil.object.DbFieldAttribute;

public class BpaTransaksiTableRecord extends TableRecord{

	public static final DbFieldAttribute[] fieldAttributeArray = 
	{
		new DbFieldAttribute(1, "ID", true, Types.INTEGER),
		new DbFieldAttribute(2, "KODE_TRANSAKSI", false, Types.VARCHAR),
		new DbFieldAttribute(3, "TANGGAL_TRANSAKSI", false, Types.DATE),
		new DbFieldAttribute(4, "NO_REKENING", false, Types.VARCHAR),
		new DbFieldAttribute(5, "NOMINAL", false, Types.DECIMAL),
		new DbFieldAttribute(6, "SALDO", false, Types.DECIMAL),
		new DbFieldAttribute(7, "USERNAME", false, Types.VARCHAR)
	};
	
	public BpaTransaksiTableRecord(){
		super(BpaTransaksiTableRecord.fieldAttributeArray);
	}
	
	public Integer getId() {
		return (Integer) getValue("ID");
	}
	public void setId(Integer id) {
		setValue("ID", id);
	}
	public String getKodeTransaksi() {
		return (String) getValue("KODE_TRANSAKSI");
	}
	public void setKodeTransaksi(String kodeTransaksi) {
		setValue("KODE_TRANSAKSI", kodeTransaksi);
	}
	public Date getTglTransaksi() {
		return (Date) getValue("TANGGAL_TRANSAKSI");
	}
	public void setTglTransaksi(Date tglTransaksi) {
		setValue("TANGGAL_TRANSAKSI", tglTransaksi);
	}
	public String getNoRekening() {
		return (String) getValue("NO_REKENING");
	}
	public void setNoRekening(String noRekening) {
		setValue("NO_REKENING", noRekening);
	}
	public Double getNominal() {
		return (Double) getValue("NOMINAL");
	}
	public void setNominal(Double nominal) {
		setValue("NOMINAL", nominal);
	}
	public Double getSaldo() {
		return (Double) getValue("SALDO");
	}
	public void setSaldo(Double saldo) {
		setValue("SALDO", saldo);
	}
	public String getUsername() {
		return (String) getValue("USERNAME");
	}
	public void setUsername(String username) {
		setValue("USERNAME", username);
	}
}
