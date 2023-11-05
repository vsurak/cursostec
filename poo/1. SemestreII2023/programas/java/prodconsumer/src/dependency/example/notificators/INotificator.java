package dependency.example.notificators;

import library.Order;

public interface INotificator {
	public void notify(Order pOrder, String pMessage);
}
