package market.model;

public class Order {
	private int orderId;
	private String producto;
	private String duenyo;
	
	public Order() {
		
	}
	
	public Order(int pOrderid, String pProd, String person) {
		this.orderId = pOrderid;
		this.producto = pProd;
		this.duenyo = person;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getDuenyo() {
		return duenyo;
	}
	public void setDuenyo(String duenyo) {
		this.duenyo = duenyo;
	}
}
