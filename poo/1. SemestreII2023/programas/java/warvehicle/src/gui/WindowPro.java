package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WindowPro extends JFrame {

	public WindowPro() {
		setTitle("Una ventana separada de la logica");
        setSize(900, 500); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        setLocation(0, 0);
        
        JLabel label = new JLabel("El UI no debe saber de lógica, la lógica no debe saber de UI!");
        label.setFont(new Font("Arial", Font.BOLD, 18)); // Set font and size
        label.setForeground(Color.GREEN); // Set text color
        label.setBounds(10, 10, 600, 40);

        // Add label to the frame's content pane
        getContentPane().setLayout(null);
        getContentPane().add(label);
        
        JGuerraBoton button1 = new JGuerraBoton(WindowProActions.ACTION1,"Test 1");
        button1.setBounds(40, 80, 100, 30);

        JGuerraBoton button2 = new JGuerraBoton(WindowProActions.ACTION2,"Test 2");
        button2.setBounds(160, 80, 100, 30);
        
        JTextField txtName = new JTextField();
        txtName.setBounds(40, 130, 220, 30);
        

        getContentPane().add(button1);
        getContentPane().add(button2);
        getContentPane().add(txtName);

        // Add onClick event listeners to the buttons
        button1.addActionListener(e -> processActions(e));
        button2.addActionListener(e -> processActions(e));
        
        this.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                txtName.setText("escriba aqui su nombre");
            }
        });
	}
	
	public void processActions(ActionEvent pEvent) {
		if (pEvent.getSource() instanceof JGuerraBoton) {
			JGuerraBoton botonApretado = (JGuerraBoton)pEvent.getSource();
			if (botonApretado.getWarAction()==WindowProActions.ACTION1) {
				System.out.println("funcion para asociar logica 1");
			} 
			if (botonApretado.getWarAction()==WindowProActions.ACTION2) {
				System.out.println("funcion para asociar logica 2");
			} 			
		}
	}
}
