package main;
import data.FeriaDataAccess;

import java.util.ArrayList;

import common.Cliente;

public class MiPrograma {

	public static void main(String[] args) {
		ArrayList<Cliente> clientesBuscados = FeriaDataAccess.getInstance().getFilteredClients("re");
		
		for(Cliente client : clientesBuscados) {
			System.out.println(client.getNombre()+" "+client.getApellido1()+" "+client.getApellido2());
		}
	}

}
