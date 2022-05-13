package painter;

public class Command implements IConstants {
	private String command;
	private int R; //read
	private int G; //green
	private int B; // blue
	private int T;  // transparency
	private int x0; // coordinates in pixels
	private int y0;
	private int x1;
	private int y1;
	private int radius; //radio in pixels
	
	public Command(String pCommand) {
		// default values
		R = 0; G = 0; B = 0; T = 0;
		x0=0; y0=0; x1=0; y1=0;
		radius = 0;	

		String commandparts[] = pCommand.split(",");
		command = commandparts[TYPE];
		
		//command type "line" will have R,G,B,T, x0,y0,x1,y1 in such order
		//command type "dot" will have R,G,B,T, x0,y0, radius in such order
		//command type "clear" , have no parameters, it just clear the screen
		
		switch (command) {
			case "line" :
				R = Integer.parseInt(commandparts[RED]);
				G = Integer.parseInt(commandparts[GREEN]);
				B = Integer.parseInt(commandparts[BLUE]);
				T = Integer.parseInt(commandparts[TRANSPARENCY]);
				x0 = Integer.parseInt(commandparts[X0]);
				y0 = Integer.parseInt(commandparts[Y0]);
				x1 = Integer.parseInt(commandparts[X1]);
				y1 = Integer.parseInt(commandparts[Y1]);
				break;
			case "dot" : {
				R = Integer.parseInt(commandparts[RED]);
				G = Integer.parseInt(commandparts[GREEN]);
				B = Integer.parseInt(commandparts[BLUE]);
				T = Integer.parseInt(commandparts[TRANSPARENCY]);
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

	public int getR() {
		return R;
	}

	public void setR(int r) {
		R = r;
	}

	public int getG() {
		return G;
	}

	public void setG(int g) {
		G = g;
	}

	public int getB() {
		return B;
	}

	public void setB(int b) {
		B = b;
	}

	public int getT() {
		return T;
	}

	public void setT(int t) {
		T = t;
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


