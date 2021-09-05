package modelaje;

import java.util.BitSet;

public class BitVectorSample 
{
	public static void main(String args[])
	{
		BitSet valores = new BitSet(20);
		valores.set(80, true);
		
		System.out.println("Espacio BitSet valores: "+valores.size());
		System.out.println("Tamano logico BitSet valores: "+valores.length());
		
		
		
		for (int i=0; i<8;i++)
		{
			valores.set(i,true);
		}
		
		BitSet subset = valores.get(0,8);
		
		System.out.println("Espacio BitSet subset: "+subset.size());
		System.out.println("Tamano logico BitSet subset: "+subset.length());
		
		String s = "Hola Mundo";
		BitSet algo = BitSet.valueOf(s.getBytes());
		System.out.println("Tamano logico del hola mundo: "+algo.length());
	}
}
