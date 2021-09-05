package temasproyecto;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class UsoArchivo {
	
	private String archivo;
	
	private FileInputStream fileInput;
	private BufferedInputStream bufferedInput;
    
	private FileOutputStream fileOutput;
	private BufferedOutputStream bufferedOutput;
	
	private byte[] bytes = null;
    
    public UsoArchivo(String pArchivo) {
    	archivo = pArchivo;
    }
    
	public byte[] leerArchivo(){
		try {
			fileInput = new FileInputStream(archivo);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return null;
		}
		bufferedInput = new BufferedInputStream(fileInput);
	     try {
	    	 bytes = new byte[1000];
	    	 bufferedInput.read(bytes);
	     }
	     catch(Exception e){
	         e.printStackTrace();
	         return null;
	     }finally{
	              try {
					bufferedInput.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           }
		return bytes;
	}
	
	public void escribirArchivo(byte[] pBytes){
		bytes = pBytes;
		try {
			fileOutput = new FileOutputStream (archivo);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		bufferedOutput = new BufferedOutputStream(fileOutput);
        try
        {
            bufferedOutput.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
        	   bufferedOutput.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
}
