package shareexample.sharables;

import shareexample.interfaces.IShareable;
import shareexample.interfaces.ShareInfo;

public class WhatsApp  implements IShareable {

	@Override
	public void share(ShareInfo pInfo) {
		System.out.println(pInfo.getUrl());
	}

}
