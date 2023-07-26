package inheritance.bills;

public class Pair {
	private String key;
	private String value;
	
	
	public Pair(String pKey, String pValue) {
		this.key = pKey;
		this.value = pValue;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
