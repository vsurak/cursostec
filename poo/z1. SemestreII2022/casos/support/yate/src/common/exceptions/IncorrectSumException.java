package common.exceptions;

public class IncorrectSumException extends Exception {
	
	private int errorCode;
	
	public IncorrectSumException() {
		super("La suma quedó mal hecha no se logro hacer");
		errorCode = 50000;
	}
	
	public int getCode() {
		return errorCode;
	}
}
