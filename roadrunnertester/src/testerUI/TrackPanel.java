package testerUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tester.IConstants;
import tester.RoadRunnerThread;

public class TrackPanel extends JPanel implements IConstants {

	private Image trackImage;
	private JFrame mainFrame;
	private ArrayList<RoadRunnerThread> runners;
	
	public TrackPanel(Image pImage, JFrame pFrame, ArrayList<RoadRunnerThread> pRunners) {
		this.mainFrame = pFrame;
		this.trackImage = pImage;
		this.runners = pRunners;
		this.setSize(TRACK_WIDTH, TRACK_WIDTH);
		this.setLayout(null);
	}
	
	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.trackImage, 0, WINDOW_COMP_SPACE, this.mainFrame);
        
        if (runners.size()>0) {
        	for(RoadRunnerThread runner : runners) {
        		g.setColor(runner.getColor());
        		g.fillOval(runner.getX(), runner.getY(), SIZE, SIZE);
        	}
        }
	}
}
