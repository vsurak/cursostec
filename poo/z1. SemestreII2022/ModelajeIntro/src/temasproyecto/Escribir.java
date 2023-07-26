package temasproyecto;
import java.io.*;

public class Escribir{
	public void escribir(String direccion,String dato)
	{
		File f;
		f = new File(direccion);
 
		try
		{
			FileWriter w = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(w);;
			PrintWriter wr = new PrintWriter(bw);;			
 
			//wr.write(dato);//escribimos en el archivo
			wr.append(dato); //concatenamos en el archivo sin borrar lo existente
			wr.close();
			bw.close();
		} 
		catch(Exception e)
		{
			
		}
		finally
		{
			
		}
	}
}