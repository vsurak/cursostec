package poo.exceptions;

public class RodrigoException extends Exception {
	private int positionOfFailed;

	public RodrigoException(String pMessage, int pIndex) {
		super(pMessage+" en la posicion "+pIndex);
		positionOfFailed = pIndex;
	}
	
	public int getpositionOfFailed() {
		return positionOfFailed;
	}
}
