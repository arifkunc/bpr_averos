package net.plaut.bprtab.object;

public class UpdateNasabahDto extends AddNasabahDto{
	private String oldNoRekening;

	public String getOldNoRekening() {
		return oldNoRekening;
	}

	public void setOldNoRekening(String oldNoRekening) {
		this.oldNoRekening = oldNoRekening;
	}
	
}
