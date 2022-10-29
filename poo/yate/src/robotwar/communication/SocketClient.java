package robotwar.communication;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient extends Thread {
	private Socket conexion;
    private PrintWriter output;
    private DataOutputStream binOutput;
    private BufferedReader input;
    private boolean listen = false;
    
	public SocketClient(String pIpAddress, int pPort) throws Exception {
		try {
			Socket socket = new Socket( pIpAddress, pPort);
			setSocket(socket);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public SocketClient(Socket pConexion) throws Exception {
		setSocket(pConexion);
	}
	
	public void setSocket(Socket pConexion) throws Exception {
		this.conexion = pConexion;
		this.input = new BufferedReader(new InputStreamReader(pConexion.getInputStream()));
		this.output = new PrintWriter(pConexion.getOutputStream());
		this.binOutput = new DataOutputStream(pConexion.getOutputStream());
		this.listen = true;
		
		this.start();
	}
	
	public void close() {
		this.listen = false;
	}
	
	public void run() {
		while (this.listen) {
			try {
				String msg = this.input.readLine();
				processMessage(msg);
				Thread.sleep(100);
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void processMessage(String pMsg) {
		// aqui pueden dos tipos de procesadores
		// el que esta del lado del cliente y el del lado del server
		// ese proccesor mejor por dependency injection
		System.out.println(pMsg);
	}
	
	public void processMessage(byte[] pMsg) {
		
	}

	public void sendMsg(String pMsg) {
		try {
			this.output.write(pMsg+"\n");
			this.output.flush();		
		} catch (Exception ex) {
			
		}
	}
	
	public void sendMsg(byte[] pMsg) {
		try {
			this.binOutput.write(pMsg);
			this.output.flush();		
		} catch (Exception ex) {
			
		}
	}
	
}
