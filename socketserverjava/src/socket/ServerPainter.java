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
			controller = pController;
			serverSocket = new ServerSocket(pPort);	
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        
	}
	
	public void run() {
		try {
			while (true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("new client connected");
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
				SocketClient client = new SocketClient(clientSocket, out, in, controller);
				client.start();
				Thread.sleep(250);				
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
}
