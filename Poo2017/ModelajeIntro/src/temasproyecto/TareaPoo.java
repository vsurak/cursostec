/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temasproyecto;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Valerio
 */
public class TareaPoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame ventana = new JFrame("Ventana");
        ventana.setSize(800, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel etiqueta = new JLabel("",SwingConstants.CENTER);
        
        ImageIcon imagen = new ImageIcon("C:\\Users\\ger08\\Desktop\\HolaMundo.png");
        etiqueta.setIcon(imagen);
        ventana.add(etiqueta);
        ventana.setVisible(true);    
    }   
}
