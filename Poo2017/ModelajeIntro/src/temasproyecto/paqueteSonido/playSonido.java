package temasproyecto.paqueteSonido;

//Librerías

import java.io.*;

import sun.audio.*;
public class playSonido {

    
    public static void main(String[] args) 
    throws Exception        
    {
        //Dirección del archivo .wav.
    	
        String sonido = "C:/Users/dnnxl/workspace/Sonido/now.wav";
        
        //Crea un objecto de tipo InputStream para leer el archivo en esa dirección.
        
        InputStream in = new FileInputStream(sonido);
        
        //Crea un archivo de tipo AudioStream para sonidos.
        
       // AudioStream audio = new AudioStream(in);
        
        //Llama el método para reproducir sonido.
        //AudioPlayer.player.start(audio);
    }
}