package temasproyecto;


import java.io.*;

public class LeerBytes {
	

	public static void main(String[] args)
	{
      
      FileInputStream fileInputStream = null;
		File file = new File("C:\\Users\\KevinS\\Desktop\\TEC\\V semestre\\Datos\\Archivos\\texto.txt");
	
		byte[] fileArray = new byte[(int) file.length()];

		
		try {
			// Con este código se obtienen los bytes del archivo.
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(fileArray);
			
			fileInputStream.close();

			// Con este código se agregan los bytes al archivo.
			FileOutputStream fileOuputStream = new FileOutputStream("C:\\Users\\KevinS\\Desktop\\TEC\\V semestre\\Datos\\Archivos\\ejemplo4.txt");
			fileOuputStream.write(fileArray);
			fileOuputStream.close();
			
			for (int i = 0; i < fileArray.length;i++)
			{
				System.out.println(fileArray[i]);
			}
			System.out.println("tam"+fileArray.length);

		} catch (Exception e) {
			//Manejar Error
		}
	}	
}

