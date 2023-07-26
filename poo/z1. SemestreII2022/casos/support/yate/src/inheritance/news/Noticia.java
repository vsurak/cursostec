package inheritance.news;

import java.time.LocalDate;
import java.util.ArrayList;

public class Noticia {
	private String titulo;
	private ArrayList<String> parrafos;
	private LocalDate date;
	private ArrayList<Foto> fotos;
	
	public Noticia() {
		this.parrafos = new ArrayList<String>();
		this.fotos = new ArrayList<Foto>();
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
		Foto newFoto = new Foto();
		newFoto.setParrafo(pUbicacionParrafo);
		newFoto.setUrl(pURL);
		
		fotos.add(newFoto);
	}
	
	public void displayNoticia(DisplayType pType) {
		System.out.println(this.titulo);
		System.out.println(this.getDate().toString());

		int indexParrafo = 0;
		int maxFotos = 0;
		for(String parrafo :  this.parrafos) {
			maxFotos = pType.getValue();
			System.out.println("====inician fotos====");
			for(Foto foto : fotos) {
				if (foto.getParrafo()==indexParrafo) {
					if (maxFotos>0) {
						System.out.print(foto.getUrl()+" ");
					} else {
						System.out.println(" ");
						System.out.print(foto.getUrl()+" ");
						maxFotos = pType.getValue();
					}
					maxFotos--;
				}
			}
			indexParrafo++;
			System.out.println("\n"+parrafo);
		}
	}
}
