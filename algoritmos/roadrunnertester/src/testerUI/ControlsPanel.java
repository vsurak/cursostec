package testerUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tester.IConstants;

public class ControlsPanel extends JPanel implements IConstants, ActionListener {

	private JFrame mainFrame;
	private JFileChooser fileSelector = new JFileChooser();
	private ArrayList<File> fileList = new ArrayList<File>();
	
	public ControlsPanel(ActionListener pRunListener) 
	{
		this.setLayout(null);
		this.setSize(WINDOW_WIDTH, WINDOW_COMP_SPACE);
				
		JButton btnAddFile = new JButton("Add file");
		btnAddFile.setSize(200, 50);
		btnAddFile.setLocation(10, 10);
		btnAddFile.addActionListener(this);

		JButton btnRun = new JButton("Run");
		btnRun.setSize(200, 50);
		btnRun.setLocation(10, 65);
		btnRun.addActionListener(pRunListener);
		
		this.add(btnAddFile);
		this.add(btnRun);
	}

	public void actionPerformed(ActionEvent e){  
		int returnVal = fileSelector.showOpenDialog(this);
		
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileSelector.getSelectedFile();
            fileList.add(file);
            JLabel fileLabel = new JLabel(fileList.size()+". "+file.getAbsolutePath());
            fileLabel.setBounds((int)(((WINDOW_WIDTH/2)*0.6)), 10+fileList.size()*20, 800, 20);
            this.add(fileLabel);
            this.repaint();
        }		
	}  
	
	public ArrayList<File> getFiles() {
		return fileList;
	}
	
}
