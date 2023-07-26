package shareexample.interfaces;

import java.time.LocalDateTime;
import java.util.Date;

public class ShareInfo {
	private int id;
	private String url;
	private String previewImage;
	private LocalDateTime posttime;
	private String description;
	private int likes;
	private String tags[];
	private String source;
	
	public ShareInfo(int pId, String pURL, LocalDateTime pPostTime, String pDescription) {
		this.id = pId;
		this.url = pURL;
		this.posttime = pPostTime;
		this.description = pDescription;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getPreviewImage() {
		return previewImage;
	}
	
	public void setPreviewImage(String previewImage) {
		this.previewImage = previewImage;
	}
	
	public LocalDateTime getPosttime() {
		return posttime;
	}
	
	public void setPosttime(LocalDateTime posttime) {
		this.posttime = posttime;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getLikes() {
		return likes;
	}
	
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public String[] getTags() {
		return tags;
	}
	
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	
	public String getSource() {
		return this.source;
	}
	
	public void setSource(String pValue) {
		this.source = pValue;
	}
	
}
