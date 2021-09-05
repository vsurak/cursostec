package temasproyecto;

import java.io.*;

public class Serializacion<e> {
	
	public byte[] serializar(e objeto){
		ByteArrayOutputStream bs= new ByteArrayOutputStream();
		ObjectOutputStream os;
		try {
			os = new ObjectOutputStream (bs);
			os.writeObject(objeto);
			os.close();
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
		return bs.toByteArray();
	}
	
	@SuppressWarnings("unchecked")
	public e deserializar(byte[] bytes){
		ByteArrayInputStream bs= new ByteArrayInputStream(bytes);
		ObjectInputStream is;
		e objeto = null;
		try {
			is = new ObjectInputStream(bs);
			objeto = (e)is.readObject();
			is.close();
		} catch (IOException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		return objeto;
	}
}
