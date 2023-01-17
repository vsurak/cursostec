package tester;

public interface IConstants {
	public static int TRACK_WIDTH = 1800;
	public static int TRACK_HEIGHT = 904;
	public static int WINDOW_COMP_SPACE = 200;
	public static int WINDOW_WIDTH = TRACK_WIDTH;
	public static int WINDOW_HEIGHT = TRACK_WIDTH+WINDOW_COMP_SPACE;

	public static int START_X = 0;
	public static int START_Y = 128+WINDOW_COMP_SPACE;
	public static double START_BEARING = 0.0;
	public static double TOTAL_VISION = 180.0;
	public static double CUADRANT_TOTAL_ANGLE = 90.0;
	public static int SIZE = 20;
	public static int SPEED_MILLIS = 500;
	public static int UPDATE_TIME_MILLIS = 100;
	public static int DEGREE_FIELD = 0;
	public static int TIME_FIELD = 1;
}
