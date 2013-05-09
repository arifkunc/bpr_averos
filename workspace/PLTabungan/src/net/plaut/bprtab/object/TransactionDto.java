package net.plaut.bprtab.object;

public class TransactionDto {
	private String transactionCd;
	private String transactionDate;
	private String rekeningNo;
	private double nominal;
	private String username;
	
	public String getTransactionCd() {
		return transactionCd;
	}
	public void setTransactionCd(String transactionCd) {
		this.transactionCd = transactionCd;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getRekeningNo() {
		return rekeningNo;
	}
	public void setRekeningNo(String rekeningNo) {
		this.rekeningNo = rekeningNo;
	}
	public double getNominal() {
		return nominal;
	}
	public void setNominal(double nominal) {
		this.nominal = nominal;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
