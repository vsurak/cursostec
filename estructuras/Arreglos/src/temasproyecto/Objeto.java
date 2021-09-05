package temasproyecto;

import java.io.Serializable;

public class Objeto implements Serializable{ //el objeto es serializable
	private static final long serialVersionUID = 4099418922330044777L; //ID generado automáticamente
	private String texto;
	private int numero;
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getTexto() {
		return texto;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNumero() {
		return numero;
	}
}
