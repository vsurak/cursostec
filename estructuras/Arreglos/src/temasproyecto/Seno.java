package temasproyecto;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Seno extends JFrame {
	
	public Seno() {
	    setLayout(new BorderLayout());
	    add(new DrawSine(), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		
		Seno frame = new Seno();
	    frame.setSize(720, 720);
	    frame.setTitle("Funcion Seno");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);

	}
	
	class DrawSine extends JPanel {
		
		double v(double x)
		{
			return Math.asin(x);
		}

	    double f(double x) {
	        return Math.sin(x);
	    }


	    protected void paintComponent(Graphics g) 
	    {
	        super.paintComponent(g);


	        Polygon p = new Polygon();
	        Polygon q = new Polygon();
	        Polygon r = new Polygon();
	        Polygon s = new Polygon();
	        Polygon t = new Polygon();
	        
	        for (int x = -50; x <= 50; x++) {
	            p.addPoint(x + 360, 200 - (int) (50 * f((x / 180.0) * 2 * Math.PI)));
	            
	            g.setColor(Color.BLUE);
		        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);

	        }

	        for (int x = -50; x <= 50; x++) {
	            q.addPoint(x + 360, 380 - (int) (50 * f((x / 180.0) * 2 * Math.PI)));
	            
	            g.setColor(Color.RED);
		        g.drawPolyline(q.xpoints, q.ypoints, q.npoints);

	        }
	        
	        for (int x = -50; x <= 50; x++) {
	            r.addPoint(x + 360, 400 - (int) (50 * f((x / 180.0) * 2 * Math.PI)));
	            
	            g.setColor(Color.BLACK);
		        g.drawPolyline(r.xpoints, r.ypoints, r.npoints);

	        }

	        for (int x = -50; x <= 50; x++) {
	            s.addPoint(x + 360, 100 - (int) (50 * f((x / 180.0) * 2 * Math.PI)));
	            
	            g.setColor(Color.BLACK);
		        g.drawPolyline(s.xpoints, s.ypoints, s.npoints);

	        }
	        
	        for (int x = -50; x <= 50; x++) {
	            t.addPoint(x + 360, 150 - (int) (50 * f((x / 180.0) * 2 * Math.PI)));
	            
	            g.setColor(Color.GREEN);
		        g.drawPolyline(t.xpoints, t.ypoints, t.npoints);

	        }


	        


	    }
	 }

}
