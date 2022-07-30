package crowly.library;

public class VideoResponse {
	private String VideoResponseURL;
	private String VideoKey;
	private String Content;
	private boolean Procesado;
	
	public VideoResponse(String pURL, String pKey, String pContent)
	{
		VideoResponseURL = pURL;
		VideoKey = pKey;
		Content = pContent;
		Procesado = false;
	}

	public String getVideoResponseURL() {
		return VideoResponseURL;
	}

	public void setVideoResponseURL(String videoResponseURL) {
		VideoResponseURL = videoResponseURL;
	}

	public String getVideoKey() {
		return VideoKey;
	}

	public void setVideoKey(String videoKey) {
		VideoKey = videoKey;
	}

	public boolean isProcesado() {
		return Procesado;
	}

	public void setProcesado(boolean procesado) {
		Procesado = procesado;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	
	
}
