package socket;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import painter.Command;
import painter.Controller;

public class SocketClient extends Thread {
	private Socket socketclient;
	private PrintWriter writer;
	private BufferedReader reader;
	private boolean stopReading = false;
	private Controller controller;
	
	public SocketClient(Socket pClientSocket, PrintWriter pOut, BufferedReader pIn, Controller pController) {
		socketclient = pClientSocket;
		writer = pOut;
		reader = pIn;
		controller = pController;
	}
	
	public void run() {
		try {
			System.out.println("new client, reading...");
			for( ;!stopReading && !socketclient.isClosed();) {
				String message = reader.readLine();
				if (message!=null && !message.isEmpty()) {
					System.out.println("recibido: "+message);
					Command command = new Command(message);
					controller.processCommand(command);
				}
				Thread.sleep(60);				
			}
			System.out.println("2");
			reader.close();
			writer.close();
			socketclient.close();
		} catch (Exception ex) {
			System.out.println("3");
			ex.printStackTrace();
			stopReading();
		}	
	}
	
	public void stopReading() {
		stopReading = true;
	}
}
