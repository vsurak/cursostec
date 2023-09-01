package gui;

import javax.swing.*;
import java.awt.*;

public class RodriWindow extends JFrame {
	private JTextArea textArea;
	private JButton button2;
	
	public RodriWindow() {
		setTitle("Rodri Window caso #1");
        setSize(500, 600); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(50, 60);
        
        JLabel label = new JLabel("Rodrigo Window!");
        label.setFont(new Font("Arial", Font.BOLD, 18)); // Set font and size
        label.setForeground(Color.MAGENTA); // Set text color
        label.setBounds(150, 10, 100, 40);

        // Add label to the frame's content pane
        getContentPane().setLayout(null);
        getContentPane().add(label);
        
        textArea = new JTextArea();
        textArea.setLineWrap(true); // Enable line wrapping
        textArea.setWrapStyleWord(true); // Wrap at word boundaries

        Rectangle textAreaBounds = new Rectangle(40, 60, 180, 200);
        textArea.setBounds(textAreaBounds);
        
        // Add text area to the frame's content pane
        getContentPane().add(textArea);    
        
        JButton button1 = new JButton("Hola");
        button2 = new JButton("Adios");

        // Define positions for the buttons
        button1.setBounds(40, 280, 100, 30);
        button2.setBounds(160, 280, 100, 30);

        // Add buttons to the frame's content pane
        getContentPane().add(button1);
        getContentPane().add(button2);

        // Set null layout
        getContentPane().setLayout(null);

        // Add onClick event listeners to the buttons
        button1.addActionListener(e -> decirHola());
        button2.addActionListener(e -> decirAdios());	
    }
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(() -> {
			RodriWindow frame = new RodriWindow();
	        frame.setVisible(true);
	    });
	}
	
	private void decirHola() {
		textArea.setText("aqui va mi mensaje");
	}
	
	private void decirAdios() {
		button2.setBackground(Color.CYAN);
	}
}
