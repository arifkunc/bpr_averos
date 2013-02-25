package net.plaut.dbutil.test;

public class TesRun {
	public static void main(String []args){
		TesRecord tr = new TesRecord();
		tr.setNo("890");
		tr.setNama("Adi");
		TesRecord tr2 = null;
		try {
			tr2 = (TesRecord) tr.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("alamat tr = "+tr);
		System.out.println("alamat tr2 = "+tr2);
		
		System.out.println("isi tr");
		System.out.println("no = "+tr.getNo());
		System.out.println("nama = "+tr.getNama());
		
		System.out.println("isi tr2");
		System.out.println("no = "+tr2.getNo());
		System.out.println("nama = "+tr2.getNama());
	}
}
