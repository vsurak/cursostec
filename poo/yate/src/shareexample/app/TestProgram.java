package shareexample.app;
import java.time.LocalDateTime;
import java.util.ArrayList;

import shareexample.interfaces.*;
import shareexample.sharables.*;

public class TestProgram {

	public static void main(String[] args) {
		ArrayList<IShareable> apps = new ArrayList<IShareable>();
		
		apps.add(new Email());
		apps.add(new WhatsApp());
		apps.add(new Instagram());
		
		ShareInfo info = new ShareInfo(38383, "http://www.ig.com/utm/3838393", LocalDateTime.now(), "Y sigue los temas de la reina isabel" );

		try {
			int choice = (System.in.read() % 3);
			
			apps.get(choice).share(info);
		} catch (Exception ex) {
			
		}
	}

}
