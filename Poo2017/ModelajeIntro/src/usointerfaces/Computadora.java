package usointerfaces;

public class Computadora implements ISellable, IConstants
{
	private String Nombre;
	private int Pulgadas;
	private double PrecioFinal;
	
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
		
		PrecioFinal = pPrecioCompra;
		return PrecioFinal;
	}
}
