package robotwar.communication;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer implements Runnable {
	private final int PORT_NUMBER = 10000;
	private boolean listening;
	
	public SocketServer() {
		listening = true;
	}
	
	public void startListening() {
		Thread t = new Thread(this);
		t.start();
	}
	
	public void stopListening() {
		listening = false;
		
	}
	
	public void run() {
		try {
			while (listening) {
				// este es el server especifico que escucha los entrantes
				ServerSocket socketListener = new ServerSocket(PORT_NUMBER);
				
				// la conexion del que se acaba de conectar
				Socket connection = socketListener.accept();
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
