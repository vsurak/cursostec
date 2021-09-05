package testerUI;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;

import tester.*;

public class TrackWindow extends JFrame implements IConstants, ActionListener, Runnable
{
	private Image trackImage;
	private ControlsPanel controls;
	private ArrayList<RoadRunnerThread> runners = new ArrayList<RoadRunnerThread>();
	private boolean threadActive = false;
	
	public TrackWindow() {
		super("The Roadrunner Tester");
		this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setLocation(0, 0);
	    this.pack();
	    
	    trackImage = new ImageIcon(getClass().getResource("/pista de carrera.jpg")).getImage();
	    controls = new ControlsPanel(this);
	    controls.setLocation(0, 0);
	    this.add(controls);

	    this.add(new TrackPanel(trackImage, this, runners));
	    
	    this.addWindowListener(new WindowAdapter() {
	    	@Override
	    	public void windowClosing(WindowEvent e) {
	    		threadActive =  false;
	    	}	 
	    });
	    	    
	    this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		threadActive = false;
		runners.clear();
		for(File file : controls.getFiles() ) {
			runners.add(new RoadRunnerThread(file));
		}
		
		for(Thread runner : runners) {
			runner.start();
			Thread refreshing = new Thread(this);
			refreshing.start();
		}
	}
	
	public void run() {
		threadActive = true;
		while (threadActive) {
			try {
				this.repaint();
				Thread.sleep(UPDATE_TIME_MILLIS);				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
