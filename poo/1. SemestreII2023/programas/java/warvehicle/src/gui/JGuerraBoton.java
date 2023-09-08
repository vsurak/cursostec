package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class JGuerraBoton extends JButton {
	private WindowProActions waraction;
	
	public JGuerraBoton(WindowProActions pAction, String pLabel) {
		super(pLabel);
		
		this.setBackground(Color.DARK_GRAY);
		this.setPreferredSize(new Dimension(30, 65));
		waraction = pAction;
		
	}

	public WindowProActions getWarAction() {
		return waraction;
	}

}
