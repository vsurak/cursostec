package socket;

import java.net.*;

import painter.Controller;

import java.io.*;


public class ServerPainter extends Thread {
	private ServerSocket serverSocket;
	private Controller controller;
    
    
	public ServerPainter(int pPort, Controller pController) {
		try {
			System.out.println("listening on port "+pPort);
			serverSocket = new ServerSocket(pPort);	
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        
	}
	
	public void run() {
		try {
			
			Socket clientSocket = serverSocket.accept();
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			DataInputStream in = new DataInputStream(clientSocket.getInputStream());
			
			SocketClient client = new SocketClient(clientSocket, out, in, controller);
			client.start();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
