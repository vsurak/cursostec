package inheritance.news.improve;

public class NoticiaMobile extends Noticia {
	public NoticiaMobile() {
		super();
		maxPhotos = DisplayType.MOBILE.getValue();
	}
	
	public void addPhoto(int pUbicacionParrafo, String pURL) {
		super.addPhoto(pUbicacionParrafo, pURL);
		System.out.println("implementacion en el hijo");
	}
}
