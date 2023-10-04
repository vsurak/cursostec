package poo.exceptions;

import java.io.IOException;

public class RodrigoException extends IOException {
	private int positionOfFailed;

	public RodrigoException(String pMessage, int pIndex) {
		super(pMessage+" en la posicion "+pIndex);
		positionOfFailed = pIndex;
	}
	
	public int getpositionOfFailed() {
		return positionOfFailed;
	}
}
