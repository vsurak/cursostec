package plants.utils;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  

public class Observable {
	private ArrayList<IObserver> observers;
	private ExecutorService executorPool;
	
	public Observable() {
		observers = new ArrayList<IObserver>();
		executorPool = Executors.newFixedThreadPool(5);
	}
	
	public void addObserver(IObserver pObservable) {
		observers.add(pObservable);
	}
	
	public void removeObserver(IObserver pObservable) {
		observers.remove(pObservable);
	}
	
	public void notifyObservers(Object pValue) {
		for(IObserver observer : observers) {
			observer.update(this, pValue);
		}
	}
	
	public void notify(Object pValue) {
		Observable thisInstance = this;
		
		for(IObserver observer : observers) {
			
			Runnable task = new Runnable() {
				@Override
				public void run() {
					observer.update(thisInstance, pValue);
				}
			};
			
			executorPool.execute(task);
		}
	}
}
