package market.model;

public class Product {
	private String name;
	private int quantity;
	private float price;
	
	public Product() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String pName) {
		this.name = pName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
