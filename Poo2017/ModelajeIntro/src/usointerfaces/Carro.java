package usointerfaces;

public class Carro implements ISellable, IConstants
{
	private int cantidadPuertas;
	private int Modelo;
	private double PrecioDelCarro;
	
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
		
		precioFinal = PrecioDelCarro * IMPUESTO_VENTAS * IMPUESTO_LUJO; // I.V.A. + I.BIENES DE LUJO
		
		return precioFinal;		
		
	}
}
