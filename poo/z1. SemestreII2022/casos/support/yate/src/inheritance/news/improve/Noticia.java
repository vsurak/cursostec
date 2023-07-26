package inheritance.news.improve;

import java.time.LocalDate;
import java.util.ArrayList;

public class Noticia {
	protected ArrayList<String> parrafos;
	protected ArrayList<String> indexedFotos[];	
	protected int maxPhotos;
	protected final int MAX_PARRAFOS = 20;
	private String titulo;
	private LocalDate date;
	
	public Noticia() {
		this.parrafos = new ArrayList<String>();
		
		indexedFotos = new ArrayList[MAX_PARRAFOS];
		for(int i=0; i<MAX_PARRAFOS; i++) {
			indexedFotos[i] = new ArrayList<String>();
		}
	}
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public void addParrafo(String pParrafo) {
		parrafos.add(pParrafo);
	}
	
	public void addPhoto(int pUbicacionParrafo, String pURL) {
		indexedFotos[pUbicacionParrafo].add(pURL);
	}
	
	public void displayNoticia() {
		System.out.println(this.titulo);
		System.out.println(this.getDate().toString());

		int indexParrafo = 0;
		
		int maxFotosPerRow = maxPhotos;
		parrafos.add(0, "");
		for(String parrafo: parrafos) {
			maxFotosPerRow = maxPhotos;
			System.out.println("\n"+parrafo);
			
			for(String fotourl : indexedFotos[indexParrafo]) {
				if (maxFotosPerRow==0) {
					maxFotosPerRow = maxPhotos;
					System.out.println("");
				}
				System.out.print(fotourl+" ");
				maxFotosPerRow--;
			}
			indexParrafo++;
		}
	}
}
