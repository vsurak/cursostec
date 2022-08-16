package temasproyecto;
import javax.swing.*;
import java.awt.event.*; 
public class MostrarImagen extends JFrame
{
	ImageIcon imagen = new ImageIcon("HolaMundo.png");
	JLabel etiqueta = new JLabel(imagen);
	public MostrarImagen()
	{
		super("Muestra la imagen");
		//AGREGAMOS LA ETIQUETA QUE CONTIENE LA IMAGEN AL FRAME
		getContentPane().add(etiqueta);
		//ESTABLECEMOS EL TAMAÑO DEL FRAME
		this.setSize(350, 350);
	}
	public static void main(String H[])
	{
		MostrarImagen imagen = new MostrarImagen();
		imagen.show();
		imagen.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt){
				System.exit(0);
			}
		});
	}
}