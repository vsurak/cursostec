/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temasproyecto.musica;

import java.applet.AudioClip;
import java.io.IOException;


/**
 *
 * @author Andrea
 */
public class sonido {
    AudioClip sonidoFondo;
    
    // inicializa la variable con la direccion
    public void sonidoInicializar(){
        sonidoFondo = java.applet.Applet.newAudioClip(getClass().getResource("/Resources/fondo.wav"));
        
    }
    
    public void Play(){
            sonidoFondo.play();
    }
    public void Loop(){
            sonidoFondo.loop();
    }
    public void Stop(){
            sonidoFondo.stop(	);
    }
    
    
}
