package shareexample.sharables;

import shareexample.interfaces.*;

public class Email implements IShareable {

	@Override
	public void share(ShareInfo pInfo) {
		System.out.println("to: ");
		System.out.println("from: ");
		System.out.println("subject: "+pInfo.getDescription());
		System.out.println("Body");
		System.out.println(pInfo.getSource());
		System.out.println(pInfo.getUrl());
	}

}
