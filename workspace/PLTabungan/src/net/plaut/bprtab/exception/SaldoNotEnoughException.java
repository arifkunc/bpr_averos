package net.plaut.bprtab.exception;

public class SaldoNotEnoughException extends Exception{

	private static final long serialVersionUID = 5061963674627301500L;

	public SaldoNotEnoughException(){
		super();
	}
	
	public SaldoNotEnoughException(String message){
		super(message);
	}
}
