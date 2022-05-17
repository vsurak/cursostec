package painter;

public class Command implements IConstants {
	private String command;
	private int Red; //read
	private int Green; //green
	private int Blue; // blue
	private int Transparency;  // transparency
	private int x0; // coordinates in pixels
	private int y0;
	private int x1;
	private int y1;
	private int radius; //radio in pixels
	
	public Command(String pCommand) {
		// default values
		Red = 0; Green = 0; Blue = 0; Transparency = 255;
		x0=0; y0=0; x1=0; y1=0;
		radius = 0;	

		String commandparts[] = pCommand.split(",");
		command = commandparts[TYPE];
		
		//command type "line" will have R,G,B,T, x0,y0,x1,y1 in such order
		//command type "dot" will have R,G,B,T, x0,y0, radius in such order
		//command type "clear" , have no parameters, it just clear the screen
		
		switch (command) {
			case "line" :
				Red = Integer.parseInt(commandparts[RED]);
				Green = Integer.parseInt(commandparts[GREEN]);
				Blue = Integer.parseInt(commandparts[BLUE]);
				Transparency = Integer.parseInt(commandparts[TRANSPARENCY]);
				x0 = Integer.parseInt(commandparts[X0]);
				y0 = Integer.parseInt(commandparts[Y0]);
				x1 = Integer.parseInt(commandparts[X1]);
				y1 = Integer.parseInt(commandparts[Y1]);
				break;
			case "dot" : {
				Red = Integer.parseInt(commandparts[RED]);
				Green = Integer.parseInt(commandparts[GREEN]);
				Blue = Integer.parseInt(commandparts[BLUE]);
				Transparency = Integer.parseInt(commandparts[TRANSPARENCY]);
				x0 = Integer.parseInt(commandparts[X0]);
				y0 = Integer.parseInt(commandparts[Y0]);
				radius = Integer.parseInt(commandparts[RADIO]);
				break;
			}	
		}
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public int getRed() {
		return Red;
	}

	public void setRed(int r) {
		Red = r;
	}

	public int getGreen() {
		return Green;
	}

	public void setGreen(int g) {
		Green = g;
	}

	public int getBlue() {
		return Blue;
	}

	public void setBlue(int b) {
		Blue = b;
	}

	public int getTransparency() {
		return Transparency;
	}

	public void setTransparency(int t) {
		Transparency = t;
	}

	public int getX0() {
		return x0;
	}

	public void setX0(int x0) {
		this.x0 = x0;
	}

	public int getY0() {
		return y0;
	}

	public void setY0(int y0) {
		this.y0 = y0;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
}


