package temasproyecto.paqueteSonido;

//Librer�as

import java.io.*;


public class playSonido {

    
    public static void main(String[] args) 
    throws Exception        
    {
        //Direcci�n del archivo .wav.
    	
        String sonido = "C:/Users/dnnxl/workspace/Sonido/now.wav";
        
        //Crea un objecto de tipo InputStream para leer el archivo en esa direcci�n.
        
        InputStream in = new FileInputStream(sonido);
        
        //Crea un archivo de tipo AudioStream para sonidos.
        
       // AudioStream audio = new AudioStream(in);
        
        //Llama el m�todo para reproducir sonido.
        //AudioPlayer.player.start(audio);
    }
}