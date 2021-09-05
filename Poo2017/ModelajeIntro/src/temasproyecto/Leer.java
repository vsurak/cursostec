package temasproyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Leer {
	public void leer(String direccion){
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		// Declaramos unas variables que necesitaremos luego
		
		// se utiliza un try/catch por el hecho de trabajar con buffers
		try {
			archivo = new File (direccion);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea;
			while ((linea=br.readLine())!=null)
				System.out.println(linea);
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(null!=fr){
					fr.close();
				}
			}catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}

}
