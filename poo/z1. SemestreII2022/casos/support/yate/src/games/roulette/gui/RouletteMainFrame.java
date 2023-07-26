package games.roulette.gui;

import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import games.roulette.Constants;
import games.roulette.controllers.RouletteMainFrameController;

public class RouletteMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private RouletteMainFrameController controller;
	private JLabel lblLastNumber;
	private JLabel lblHistory;
	private JTextField txtAmount;
	private JTextField txtNumbers;
	
	// this variable and the override of the update method are to implement java double buffering, preventing blinking when drawing is made
	//private Image offScreen;

	public RouletteMainFrame(String pTitle, RouletteMainFrameController pController) {
		super(pTitle);
		controller = pController; // frame ve al controller
		controller.setWindow(this); // controller ve al frame

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(0, 0, 1080, 780);
		this.setLocationRelativeTo(null);
		this.setLayout(null); // this allows this frame to locate the components with freedom in the screen
		this.setBackground(Color.white);
		this.initComponents();
		
		this.setVisible(true);		
	}
	
	public void setLastNumber(int pNumber) {
		lblLastNumber.setText(pNumber+"");
		lblHistory.setText(lblHistory.getText()+" "+pNumber);
	}
    
    private void initComponents() {
    	JLabel captionAmount = new JLabel("Amount: ");
    	captionAmount.setBounds(10, 20, 160, 20);
    	this.add(captionAmount);
    	
    	txtAmount = new JTextField();
    	txtAmount.setBounds(230, 20, 160, 20);
    	this.add(txtAmount);

    	JLabel captionNumbers = new JLabel("Numbers to bet, ej> 20 5 30 12 15  : ");
    	captionNumbers.setBounds(10, 50, 220, 20);
    	this.add(captionNumbers);

    	txtNumbers = new JTextField();
    	txtNumbers.setBounds(230, 50, 160, 20);
    	this.add(txtNumbers);
    	
    	JLabel captionHistory = new JLabel("History: ");
    	captionHistory.setBounds(10, 90, 220, 20);
    	this.add(captionHistory);

    	lblHistory = new JLabel("");
    	lblHistory.setBounds(230, 90, Constants.MAX_AMOUNT_OF_NUMBERS_IN_HISTORY*15, 20);
    	this.add(lblHistory);
    	
    	JLabel captionLastNumber = new JLabel("Last Number: ");
    	captionLastNumber.setBounds(10, 130, 220, 20);
    	this.add(captionLastNumber);

    	lblLastNumber = new JLabel("");
    	lblLastNumber.setBounds(240, 130, 40, 20);
    	this.add(lblLastNumber);
    	
    	JButton btnAddBet = new JButton("Add bet");  
    	btnAddBet.setBounds(280, 72, 100,20);
    	btnAddBet.addActionListener(new ActionListener(){  
    		public void actionPerformed(ActionEvent e){
    			controller.addBet(txtAmount.getText(), txtNumbers.getText());
    			txtAmount.setText("");
    			txtNumbers.setText("");
    		}  
    	});
    	this.add(btnAddBet);
    	
    	JButton btnSpin = new JButton("Spin");  
    	btnSpin.setBounds(280, 130, 100,20);
    	btnSpin.addActionListener(new ActionListener(){  
    		public void actionPerformed(ActionEvent e){  
    			controller.spin();
    		}  
    	});
    	this.add(btnSpin);
    }
}
