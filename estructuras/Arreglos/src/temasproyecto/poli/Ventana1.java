/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temasproyecto.poli;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import java.util.Random;
import javax.swing.JFrame;

/**
 * Se pretende con este ejemplo de codigo el explicar breve y consiso el tema de doble buffer con 
 * el que se pueden obtener mejoras meramente visuales en pantalla.
 * @author edgerik
 */
public class Ventana1  extends JFrame{
    
    int x,y; //Coordenadas de pantalla
    int bx, by; //Coordenadas de la nueva bolita
    
    
    private Image dbImage; //Declaracion del buffer tracero
    private Graphics dbg; //Declaracion de graficos para manejo del doble buffer
    
    
    public class AL extends KeyAdapter {
        
        /*
        Metodo bind(siempre se esta ejecutando)
        que toma el evento de una tecla y mueva las coordenadas
        */
        @Override
        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();
            if(keyCode == KeyEvent.VK_LEFT){
                if(x<=0)
                    x=0;
                else
                    x-= 10;
            }
            if(keyCode == KeyEvent.VK_RIGHT){
                if(x>=490) //Limite para coordenada x
                    x=490;
                else
                    x+= 10;
            }
            if(keyCode == KeyEvent.VK_UP){
               if(y<=0)
                   y=0;
               else
                   y-= 10;
            }
            if(keyCode == KeyEvent.VK_DOWN){
                if(y>=490) // Se define el limite para la coordenada y
                    y=490;
                else
                    y+= 10;
            }
//            String s = Integer.toString(x)+ "," + Integer.toString(y);
//            System.out.println(s);
        }
        
        @Override
        public void keyReleased(KeyEvent e){
            
        }
    }
    
    
    /*
    Metodo bind que pinta la pantalla cada vez que cambia
    */
//    @Override
//    public void paint(Graphics g){
//        dbImage = createImage(getWidth(), getHeight());
//        dbg = dbImage.getGraphics();
//        paintComponent(dbg);
//        g.drawImage(dbImage, 0, 0, this);
//    }
//    
    /*
    *******PARA VER como se vería la pantalla SIN el doble buffer:
    COMENTAR la funcion paint() de arriba, renombrar paintComponent() de abajo
    como paint()
    y ejecutar
    
    
    ***MOVER LA bolita con las flechas
    */
    
    /*
    Metodo que redibuja la figura en una diferente posicion
    */
    public void paint(Graphics g){
        if(x == bx & y == bx){
            g.setColor(Color.red);
            setNewBall();
            g.fillOval(bx, by, 10, 10);
        }
        
        g.fillOval(x, y, 10, 10);
        
        
        repaint();
    }
    
    public void setNewBall(){
        Random r = new Random();
        bx = r.nextInt(50);
        bx = bx*10;
        by = r.nextInt(50);
        by = by*10;
        System.out.println(bx);
        System.out.println(by);
    }
    
    public Ventana1(){
        addKeyListener(new AL());
        setTitle("Java Game");
        setSize(500, 500);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        x = 100;
        y = 100;
        setNewBall();
        
    }
}
