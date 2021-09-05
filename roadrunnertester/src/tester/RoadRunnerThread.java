package tester;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RoadRunnerThread extends Thread implements IConstants {

	private Point position;
	private Color color;
	private Iterator<String> instructions;
	private double currentBearingAngle = START_BEARING;
	
	public RoadRunnerThread(File pFile) {
		position = new Point(START_X, START_Y);
		color = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
		loadFile(pFile);
	}
	
	private void loadFile(File pFile) {
		try {
			Scanner fileReader = new Scanner(pFile);
			ArrayList<String> fileLines = new ArrayList<String>();
			while(fileReader.hasNextLine()) {
				fileLines.add(fileReader.nextLine());
			}
			fileReader.close();
			
			instructions = fileLines.iterator();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void run() {
		try {
		    while(instructions.hasNext()) {
		        String instruction[] = instructions.next().split(",");
		        double angle = Double.parseDouble(instruction[DEGREE_FIELD]);
		        int instructionTime = (int)(Double.parseDouble(instruction[TIME_FIELD]));
		        

		        double distance = (instructionTime / SPEED_MILLIS) * SIZE;
		        Point destinyXY = calculateDestinyPosition(position, distance, angle);
		        

		        int steps = instructionTime / UPDATE_TIME_MILLIS; // cantidad de actualizaciones a esa velocidad
		        // para mx + c equation
		        double m = 0.0;
		        double c = 0.0;
		        double increments = 0.0;
		        double currentX = position.getX();
		        double currentY = position.getY();
		        double distanceX = destinyXY.getX()-position.getX();
		        
		        if (distanceX!=0.0) {
			        
			        m = (destinyXY.getY() - position.getY()) /  (destinyXY.getX() - position.getX());
			        c = (destinyXY.getX() * position.getY() - position.getX() * destinyXY.getY()) / (destinyXY.getX() - position.getX()); 

			        increments = (destinyXY.getX() -  position.getX()) / steps;  // el tamaño de los incrementos de X en esa cantidad de pasos
		        } else {
		        	m = (destinyXY.getY()-position.getY())/steps;
		        }
		        
		        for(;steps>0; steps--) {
		        	Thread.sleep(UPDATE_TIME_MILLIS);
		        	currentX+=increments;
		        	currentY = distanceX!=0 ? m * currentX + c : currentY + m;
		        	position.setLocation(currentX, currentY);
		        }	
		        
		        position.setLocation(destinyXY);
		    }			
		} catch (Exception ex) {
			
		}
	}
	
	public int getX() {
		return position.x;
	}
	
	public int getY() {
		return position.y;
	}
	
	public Color getColor() {
		return color;
	}
	
	private Point calculateDestinyPosition(Point pCurrentPosition, double pDistance, double pInstructionAngle) {
		Point result = new Point();

        currentBearingAngle -= (CUADRANT_TOTAL_ANGLE - pInstructionAngle); 
		double rad = currentBearingAngle * Math.PI / TOTAL_VISION;
		result.x = (int)(position.getX() + (pDistance * Math.cos(rad)));
		result.y = (int)(position.getY() + (pDistance * Math.sin(rad)));
        		        
		return result;
	}
}
