package threading;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame
{
	private JLabel Etiqueta1;
	private JLabel Etiqueta2;
	
	public Ventana()
	{
		initComponents();
	}
	
	private void initComponents() {
		this.setVisible(true);
		this.setSize(500,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panel = new JPanel();
		this.add(panel);
		JButton button = new JButton("Sin Hilo");
		panel.add(button);
		button.addActionListener(new ActionListener()
	    {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  ejecucionSinHilo();
		      }
		});

		JButton button2 = new JButton("ConHilo");
		panel.add(button2);
		button2.addActionListener(new ActionListener()
	    {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  ejecucionConHilo();
		      }
		});
 
		Etiqueta1 = new JLabel("0");
		Etiqueta1.setBounds(100, 100, 200, 200);
		panel.add(Etiqueta1);

		Etiqueta2 = new JLabel("0");
		Etiqueta2.setBounds(100, 200, 200, 200);
		panel.add(Etiqueta2);
		
	}

	public void ejecucionSinHilo()
	{
		int contador =0;
		
		while (contador++<5000000)
		{
			Etiqueta1.setText(Integer.toString(contador));
		}
	}
	
	public void ejecucionConHilo()
	{
		ContadorThread nuevoHilo = new ContadorThread(Etiqueta2);
		nuevoHilo.start();
	}
}
