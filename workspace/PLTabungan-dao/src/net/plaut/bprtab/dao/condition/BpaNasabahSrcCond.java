package net.plaut.bprtab.dao.condition;

import net.plaut.dbutil.object.SearchCondition;

public class BpaNasabahSrcCond implements SearchCondition{
	private String noRekening;
	private String namaLengkap;
	private String nis;
	
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
	
}
