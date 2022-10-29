package robotwar.common.robotbase;

public enum ORIENTATION {
	NORTH(0), SOUTH(1), EAST(2), WEST(3);
	
	private int value;
	
	ORIENTATION(int pValue) {
		value = pValue;
	}
	
	public int getValue() {
		return value;
	}

}
