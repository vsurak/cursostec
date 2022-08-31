package inheritance.news.improve;

// a esto se le llama especializacion
public class NoticiaTablet extends Noticia {
	public NoticiaTablet() {
		super();
		maxPhotos = DisplayType.TABLET.getValue();
	}
	
	public void addPhoto(int pUbicacionParrafo, String pURL) {
		super.addPhoto(pUbicacionParrafo, pURL);
		System.out.println("implementacion en el hijo");
	}

}
