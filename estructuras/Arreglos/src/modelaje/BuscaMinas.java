package modelaje;

public class BuscaMinas 
{
	private final int MINA = -1;
	private final int ESPACIO_VACIO = -2;
	private final int INDICE_REGLAS_FILAS=0;
	private final int INDICE_REGLAS_COLUMNAS=1;
	private final int INDICE_REGLAS_CANTMINAS=2;
	
	private short CantidadFilas;
	private short CantidadColumnas;
	private short CantidadMinas;
	private int[][] MapaMinas;
	private int[][] reglasMinas = {
									{8,8,10},
									{16,16,40},
									{16,30,99},
									{18,35,110}
								  };
	
	public BuscaMinas(short pFilas, short pColumnas)
	{
		this.CantidadFilas = pFilas;
		this.CantidadColumnas = pColumnas;
	}
	
	
	public int[][] generarMapaAlgoritmoFeo()
	{
		if ((CantidadFilas==8) && (CantidadColumnas==8)) {
			CantidadMinas = 10;
		} else 
		if ((CantidadFilas==16) && (CantidadColumnas==16)) {
			CantidadMinas = 40;
		} else
		if ((CantidadFilas==16) && (CantidadColumnas==30)) {
			CantidadMinas = 99;
		} else 
		{
			// solicito al usuario la cantidad de minas
		}
		return MapaMinas;
	}
	
	public int[][] generarMapa()
	{
		CantidadMinas = 0;
		for(int i=0; i<reglasMinas.length; i++)
		{
			if ((CantidadFilas==reglasMinas[i][INDICE_REGLAS_FILAS]) && 
				(CantidadColumnas==reglasMinas[i][INDICE_REGLAS_COLUMNAS])) 
			{
				CantidadMinas = (short)reglasMinas[i][INDICE_REGLAS_CANTMINAS];
				break;
			}
			
		}
		
		if (CantidadMinas==0)
		{
			// solicito al usuario la cantidad de minas
		}
		
		return MapaMinas;
	}	
	
}
