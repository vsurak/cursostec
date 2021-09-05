/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temasproyecto.musica;

import java.io.IOException;
import javax.swing.JOptionPane;



/**
 *
 * @author Andres
 */
public class Musica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        sonido nuevosonido= new sonido();
        nuevosonido.sonidoInicializar();
        boolean minimenu=true;
        while (minimenu){
            int menu=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese:\n"
                    + "1.-Para dar play\n"
                    + "2.- Para hacer un loop\n"
                    + "3.- Para Hacer stop\n"
                    + "4.- Salir"));
            
            switch(menu){
                case 1: nuevosonido.Play();
                    break;
                case 2: nuevosonido.Loop();
                    break;
                case 3: nuevosonido.Stop();
                    break;
                case 4: minimenu=false;
                    break;
            }
        
        }
        
        
        
    }
    
    
    
    
    
}
