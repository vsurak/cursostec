package data;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import common.Cliente;

public class FeriaDataAccess implements IDataConstants {
	
	private static FeriaDataAccess instance;
	private Connection conexion; 
	
	private FeriaDataAccess() {
		try {
			conexion = DriverManager.getConnection(CONN_STRING);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public synchronized static FeriaDataAccess getInstance() {
		if (instance==null) {
			instance = new FeriaDataAccess();
		}
		return instance;
	}
	
	public ArrayList<Cliente> getFilteredClients(String pFilter) {
		ArrayList<Cliente> result = new ArrayList<Cliente>();
		try {
			
			// option de llamada de un query directo
			//Statement stmt = conexion.createStatement();
		    //String SQL = "SELECT nombre, apellido1, apellido2 FROM dbo.Clientes";
		    //ResultSet rs = stmt.executeQuery(SQL);
		    
			// haciendo una llamada a un stored procedure
			PreparedStatement  spGetFilteredClients = conexion.prepareStatement("{call dbo.getFilteredClients(?)}");
			spGetFilteredClients.setString(1, pFilter);  
	        ResultSet rs = spGetFilteredClients.executeQuery(); 
		
		    // Iterate through the data in the result set and display it.
		    while (rs.next()) {
		    	Cliente newClient = new Cliente();
		    	newClient.setNombre(rs.getString("nombre"));
		    	newClient.setApellido1(rs.getString("apellido1"));
		    	newClient.setApellido2(rs.getString("apellido2"));
		        result.add(newClient);
		    }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
}