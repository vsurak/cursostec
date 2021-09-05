package usointerfaces;

public class Casa implements ISellable, IConstants, Comparable
{
	private int Tamaño;
	private int capacidadPersonas;
	private double PrecioCasa;
	
	public Casa(double pPrecio)
	{
		PrecioCasa = pPrecio;
	}
	
	@Override
	public double getPrice() {
		
		return PrecioCasa;
	}
	@Override
	public int getAño() {
		// TODO Auto-generated method stub
		return 2010;
	}
	@Override
	public int getGarantia() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	@Override
	public boolean ofertar(double pOferta) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public double vender(double pPrecioCompra) 
	{
		double precioFinal;
	
		precioFinal = PrecioCasa * IMPUESTO_VENTAS; // I.V.A.
		
		return precioFinal;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
