package crowly;

import java.util.ArrayList;

import crowly.connectors.MSClient;
import crowly.library.Cuerpo;
import crowly.library.IConstants;
import crowly.library.VideoResponse;

public class VideoProcesor implements IConstants
{
	private MSClient MsClient;
	private ArrayList<Cuerpo> CuerposTodosLosVideos;
	
	public VideoProcesor()
	{
		MsClient = new MSClient();
	}
	
	public void analizarVideos()
	{
		try 
		{
			for(String urlVideo : LISTA_VIDEOS) {
				MsClient.procesarVideo(urlVideo);
				Thread.sleep(ESPERA_ENTRE_LLAMADAS);
			}
			
			Thread.sleep(60000);
			
			for(VideoResponse video : MsClient.getVideosPendientes()) {
				MsClient.procesarRespuestaVideo(video);
				Thread.sleep(ESPERA_ENTRE_LLAMADAS);
			}
			
			CuerposTodosLosVideos = MsClient.getCuerpos();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		VideoProcesor proc = new VideoProcesor();
		proc.analizarVideos();
	}
}
