package shareexample.sharables;

import shareexample.interfaces.IShareable;
import shareexample.interfaces.ShareInfo;

public class Instagram implements IShareable {

	@Override
	public void share(ShareInfo pInfo) {
		System.out.println(pInfo.getPreviewImage());
		System.out.println(pInfo.getPosttime());
		System.out.println("Likes :)"+pInfo.getLikes());
	}

}
