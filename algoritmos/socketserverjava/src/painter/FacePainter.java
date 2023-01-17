package painter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import socket.*;

public class FacePainter extends JFrame {
	private Image offScreen;
	
	public FacePainter(String pTitle) {
		super(pTitle);
	}
	
	public void clear() {
		offScreen = this.createImage(this.getWidth(), this.getHeight());
		repaint();
	}
	
	public void paintLine(Command pCommand) {
		Color figureColor = new Color(pCommand.getRed(), pCommand.getGreen(), pCommand.getBlue(), pCommand.getTransparency());
		Graphics g = offScreen.getGraphics(); 
		g.setColor(figureColor);
		g.drawLine(pCommand.getX0(),  pCommand.getY0(),  pCommand.getX1(), pCommand.getY1());
		repaint();
	}
	
	public void paintDot(Command pCommand) {
		Color figureColor = new Color(pCommand.getRed(), pCommand.getGreen(), pCommand.getBlue(), pCommand.getTransparency());
		Graphics g = offScreen.getGraphics(); 
		g.setColor(figureColor);		
		g.fillOval(pCommand.getX0() - pCommand.getRadius(), pCommand.getY0() - pCommand.getRadius(), pCommand.getRadius()*2, pCommand.getRadius()*2);
		repaint();
	}
	
    @Override
    public void update(Graphics g) {                                
        paint(g);
    }
          
    @Override
    public void paint(Graphics g) {
		g.drawImage(offScreen, 0, 0, null);
    }
    	
	public static void main(String[] args) {
		try {
			FacePainter window = new FacePainter("Simple GUI");
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setResizable(false);
			window.setBounds(0, 0, 1080, 1080);
			window.setLocationRelativeTo(null);
			window.setBackground(Color.white);
			window.setVisible(true);
			
			window.clear();
			
			Controller mainController = new Controller(window);
			ServerPainter server = new ServerPainter(4000, mainController);
			server.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
