package inheritance.news.improve;

public enum DisplayType {
	DESKTOP(4), TABLET(2), MOBILE(1);
	
    private final int value;

    DisplayType(final int newValue) {
        value = newValue;
    }

    public int getValue() { 
    	return value; 
    }
}
