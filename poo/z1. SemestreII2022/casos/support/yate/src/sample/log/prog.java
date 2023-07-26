package sample.log;

public class prog {
	public static void main(String args[]) {
		Logger logger = new Logger();
		logger.log("esta pasando algo", LogType.INFO);
		logger.log("esta pasando algo", LogType.INFO);
		logger.log("esta pasando algo", LogType.INFO);
		
		for(int i=0; i<100000; i++) {
			logger.log("esta pasando algo -> "+i , LogType.ERROR);
		}
	}
}
