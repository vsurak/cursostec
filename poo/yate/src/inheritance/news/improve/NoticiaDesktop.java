package inheritance.news.improve;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NoticiaDesktop extends Noticia {
	
	public NoticiaDesktop() {
		super();
		maxPhotos = DisplayType.DESKTOP.getValue();
	}
	
	public void addPhoto(int pUbicacionParrafo, String pURL) {
		super.addPhoto(pUbicacionParrafo, pURL);
		System.out.println("implementacion en el hijo");
	}
}
