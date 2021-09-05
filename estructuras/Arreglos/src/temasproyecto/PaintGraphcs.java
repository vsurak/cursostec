package temasproyecto;

import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*;    // Using Swing's components and containers
 
/** Custom Drawing Code Template */
public class PaintGraphcs extends JFrame {
   public static final int CANVAS_WIDTH  = 640;
   public static final int CANVAS_HEIGHT = 480;
   private DrawCanvas canvas;
 
   public PaintGraphcs() {
      canvas = new DrawCanvas();    
      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
 
      Container cp = getContentPane();
      cp.add(canvas);
 
      setDefaultCloseOperation(EXIT_ON_CLOSE);  
      pack();             
      setTitle("Prueba");  
      setVisible(true);   
   }
 
   /**
    * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
    */
   private class DrawCanvas extends JPanel {
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);     
         setBackground(Color.GRAY); 
 

         g.setColor(Color.YELLOW);    
         g.drawLine(30, 40, 100, 200);
         g.drawOval(150, 180, 10, 10);
         g.drawRect(200, 210, 20, 30);
         g.setColor(Color.RED);       
         g.fillOval(300, 310, 30, 50);
         g.fillRect(400, 350, 60, 50);
         g.setColor(Color.LIGHT_GRAY);
         g.drawOval(100, 100, 100, 100);
         g.setColor(Color.WHITE);
     g.drawRect(1, 1, 1,1);
         g.setFont(new Font("Monospaced", Font.PLAIN, 30));
         g.drawString("Prueba de paint", 100, 100);
      }
   }
 
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new PaintGraphcs(); 	
         }
      });
   }
}