package threading;

import javax.swing.JLabel;

public class ContadorThread extends Thread
{
	private JLabel EtiquetaToUpdate;
	
	public ContadorThread(JLabel pLabel)
	{
		EtiquetaToUpdate = pLabel;
	}
	
	public void run()
	{
		int contador =0;
		while (contador++<5000000)
		{
			EtiquetaToUpdate.setText(Integer.toString(contador));
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
