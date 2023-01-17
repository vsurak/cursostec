package painter;

import javax.swing.JFrame;

public class Controller {
	private FacePainter frame;
	
	public Controller(FacePainter pFrame) {
		frame = pFrame;
	}

	public void processCommand(Command pCommand) {
		switch (pCommand.getCommand()) {
			case "line" : 
				frame.paintLine(pCommand);
				break;
			case "dot" : 
				frame.paintDot(pCommand);				
				break;
			case "clear" :
				frame.clear();
				break;
		}
	}
}
