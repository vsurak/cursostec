package usointerfaces;

public class Remolque implements ISellable, IConstants
{
	private int cantidadHabitaciones;
	private String Marca;
	private float Precio;
	
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getAño() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getGarantia() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean ofertar(double pOferta) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public double vender(double pPrecioCompra) {
		double precioFinal;
		
		precioFinal = Precio * IMPUESTO_VENTAS; // I.V.A.
		
		return precioFinal;		
		
	}
}
