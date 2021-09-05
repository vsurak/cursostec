package usointerfaces;

public interface ISellable 
{
	public double getPrice();
	public int getAño();
	public int getGarantia();
	public boolean ofertar(double pOferta);
	public double vender(double pPrecioCompra);
}
