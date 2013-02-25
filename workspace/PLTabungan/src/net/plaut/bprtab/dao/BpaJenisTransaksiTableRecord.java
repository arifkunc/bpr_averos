package net.plaut.bprtab.dao;

import net.plaut.dbutil.dao.TableRecord;

public class BpaJenisTransaksiTableRecord extends TableRecord{
	private String transactionCd;
	private String transactionName;
	private String debitCredit;
	public String getTransactionCd() {
		return transactionCd;
	}
	public void setTransactionCd(String transactionCd) {
		this.transactionCd = transactionCd;
	}
	public String getTransactionName() {
		return transactionName;
	}
	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
	public String getDebitCredit() {
		return debitCredit;
	}
	public void setDebitCredit(String debitCredit) {
		this.debitCredit = debitCredit;
	}
	

}
