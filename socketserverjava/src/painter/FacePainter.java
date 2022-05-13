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
		clear();
	}
	
	public void clear() {
		Dimension size = this.getSize();
		offScreen = createImage(size.width, size.height);	
	}
	
	public void paintLine(Command pCommand) {
		Color figureColor = new Color(pCommand.getR(), pCommand.getG(), pCommand.getB(), pCommand.getT());
		offScreen.getGraphics().setColor(figureColor);
		offScreen.getGraphics().drawLine(pCommand.getX0(),  pCommand.getY0(),  pCommand.getX1(), pCommand.getY1());
	}
	
	public void paintDot(Command pCommand) {
		Color figureColor = new Color(pCommand.getR(), pCommand.getG(), pCommand.getB(), pCommand.getT());
		offScreen.getGraphics().setColor(figureColor);
		offScreen.getGraphics().fillOval(pCommand.getX0() - pCommand.getRadius(), pCommand.getY0() - pCommand.getRadius(), pCommand.getRadius()*2, pCommand.getRadius()*2);		
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
			window.setBounds(0, 0, 800, 600);
			window.setLocationRelativeTo(null);
			window.setBackground(Color.white);
			window.setVisible(true);
			
			Controller mainController = new Controller(window);
			ServerPainter server = new ServerPainter(4000, mainController);
			server.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
