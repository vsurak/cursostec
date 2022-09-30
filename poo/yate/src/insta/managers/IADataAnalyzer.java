package insta.managers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import insta.Post;

public class IADataAnalyzer  implements PropertyChangeListener {
	
	private void recognizedObjects(Post pPost) {
		System.out.println("detectando los objetos que salen en las fotos");
	}
	
	private void identifyLocation(Post pPost) {
		System.out.println("calculando la ubicacion donde fue tomada la foto");
	}

	private void extractPeople(Post pPost) {
		System.out.println("detectar las personas en las fotos");
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Post newpost = (Post)evt.getOldValue();
		this.recognizedObjects(newpost);
		this.identifyLocation(newpost);
		this.extractPeople(newpost);
	}

}
