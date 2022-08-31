package inheritance.news;

import java.time.LocalDate;

public class newsmain {

	/*
	 * Existen noticias compuestas de titulo, lista de párrafos,
	 * fecha del artículo y una lista de fotografías. Cada fotografía
	 * indica en que posición se va a mostrar con respecto a un número de
	 * párrafo. Cuando se ven las noticias en desktop aparecen hasta 4 fotos en 
	 * horizontal, si se ven en tablet se pueden ver un máximo de 2 horizontales y
	 * finalmente si es mobile entonces solo 1 imagen horizontal máximo.
	 */
	public static void main(String[] args) {
		Noticia article = new Noticia();
		article.setTitulo("Noticia de prueba");
		article.setDate(LocalDate.of(2022, 8, 20));
		article.addParrafo("Este es el parrafo 1");
		article.addParrafo("Este es el parrafo 2");
		article.addParrafo("Este es el parrafo 3");
		article.addPhoto(0, "Url de foto 1 parrafo 0");
		article.addPhoto(0, "Url de foto 2 parrafo 0");
		article.addPhoto(1, "Url de foto 1 parrafo 1");
		article.addPhoto(2, "Url de foto 1 parrafo 2");
		article.addPhoto(2, "Url de foto 2 parrafo 2");
		article.addPhoto(2, "Url de foto 3 parrafo 2");
		article.addPhoto(2, "Url de foto 4 parrafo 2");
		article.addPhoto(2, "Url de foto 5 parrafo 2");
		
		article.displayNoticia(DisplayType.DESKTOP);
	}

}
