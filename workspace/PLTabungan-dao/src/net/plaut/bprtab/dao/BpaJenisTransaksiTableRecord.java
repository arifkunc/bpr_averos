package net.plaut.bprtab.dao;

import java.sql.Types;

import net.plaut.dbutil.dao.TableRecord;
import net.plaut.dbutil.object.DbFieldAttribute;

public class BpaJenisTransaksiTableRecord extends TableRecord{
	
	public static final DbFieldAttribute[] fieldAttributeArray = 
	{
		new DbFieldAttribute(1, "KODE_TRANSAKSI", true, Types.VARCHAR),
		new DbFieldAttribute(2, "NAMA_TRANSAKSI", false, Types.VARCHAR),
		new DbFieldAttribute(3, "DEBIT_KREDIT", false, Types.VARCHAR)
	};
	
	public BpaJenisTransaksiTableRecord(){
		super(BpaJenisTransaksiTableRecord.fieldAttributeArray);
	}
	
	public String getTransactionCd() {
		return (String) getValue("KODE_TRANSAKSI");
	}
	
	public void setTransactionCd(String transactionCd) {
		setValue("KODE_TRANSAKSI", transactionCd);
	}
	
	public String getTransactionName() {
		return (String) getValue("NAMA_TRANSAKSI");
	}
	
	public void setTransactionName(String transactionName) {
		setValue("NAMA_TRANSAKSI", transactionName);
	}
	
	public String getDebitCredit() {
		return (String) getValue("DEBIT_KREDIT");
	}
	
	public void setDebitCredit(String debitCredit) {
		setValue("DEBIT_KREDIT", debitCredit);
	}
	
}
