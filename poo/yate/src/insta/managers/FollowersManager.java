package insta.managers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import insta.Post;
import insta.model.Account;

public class FollowersManager implements PropertyChangeListener {
	private void notifyFollowers(Post pPost, Account pAuthor) {
		System.out.println("Le aviso a todos los followers en account de este nuevo post");
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		notifyFollowers((Post)evt.getOldValue(), (Account)evt.getNewValue());
	}
}
