package insta;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import insta.managers.FollowersManager;
import insta.managers.IADataAnalyzer;
import insta.model.Account;

public class MainApp {

	private PropertyChangeSupport listeners;
	
	public MainApp() {
		listeners = new PropertyChangeSupport(this);
	}
	
	// el objetivo es que cuando se publique un nuevo post
	// otros objetos reaccionen y hagan algo con el post, de esta manera
	// la programación queda mas desacoplada, pues entonces esta clase 
	// solo se preocupa por realizar el post
	// pueden haber N subscriptores, cada subscriptor decide que hacer cuando 
	// el evento de publishPost ocurre
	public void publishPost(String pTitle, ArrayList<String> photos, Account pAuthor) {
		Post newPost = new Post(pTitle, "http://insta-poo/postid/"+java.util.UUID.randomUUID().toString());
		for(String photoURL : photos) {
			newPost.addPhoto(photoURL);
		}
		listeners.firePropertyChange("newPost", newPost, pAuthor);
	}
	
  	public void addPropertyChangeListener(PropertyChangeListener pcl) {
  		listeners.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
    	listeners.removePropertyChangeListener(pcl);
    }

	public static void main(String[] args) {
		Account pedro = new Account("eminen", "pedro perez");
		Account ana = new Account("anita", "ana perez");
		Account juan = new Account("juan", "juan perez");
		juan.addFollower(pedro);
		juan.addFollower(ana);
		
		ArrayList<String> fotosdelpost = new ArrayList<String>();
		fotosdelpost.add("http://insta-poo/imgs/83jd92isjs.jpg");
		fotosdelpost.add("http://insta-poo/imgs/73jdjd8js.jpg");
		
		MainApp instaApp = new MainApp();
		
		instaApp.addPropertyChangeListener(new FollowersManager());
		instaApp.addPropertyChangeListener(new IADataAnalyzer());
		
		instaApp.publishPost("otra forma de hacer observers en java", fotosdelpost, juan);
	}

}
