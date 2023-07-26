package insta;

import java.util.ArrayList;

public class Post {
	private String url;
	private String title;
	private ArrayList<String> photos;
	
	public Post(String pTitle, String pURL) {
		this.url = pURL;
		this.title = pTitle;
		this.photos = new ArrayList<String>();
	}
	
	public void addPhoto(String photoURL) {
		photos.add(photoURL);
	}
	
	
}
