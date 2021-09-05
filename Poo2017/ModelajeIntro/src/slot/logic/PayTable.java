package slot.logic;

import slot.library.*;

public class PayTable 
{
	private int[][] TablaPagos =
		{
				{000,4000,8000,20000},
				{123,400,800,1200},
				{111,300,600,900},
				{222,200,400,600},
				{333,100,200,300},
				{213,50,100,150},
				{231,50,100,150},
				{132,50,100,150},
				{312,50,100,150},
				{321,50,100,150},
				{444,40,80,120},
				{555,20,40,60},
				{666, 10,20,30}
		};
	
	
	public int calcularPago(Simbolo[] pPayLine, short pCreditsPlayed)
	{
		int result = 0;
		String pseudoNumero = "";
		for(int indexPayline=0; indexPayline<pPayLine.length; indexPayline++)
		{
			pseudoNumero += ""+pPayLine[indexPayline].getId();
		}
		
		int payCode = Integer.valueOf(pseudoNumero).intValue();
		
		for(int indexPagos=0; indexPagos<TablaPagos.length; indexPagos++)
		{
			if (payCode==TablaPagos[indexPagos][0])
			{
				result = TablaPagos[indexPagos][pCreditsPlayed];
				break;
			}
		}
		return result;
		
	}
}
