package com.willlee.designpatterns.observer.javaexample;


public class Watcher implements Observer {
	
	public Watcher(Observable o) {
		o.addObserver(this);
	}

	public void update(Observable arg0, Object arg1) {
        System.out.println("״̬�����ı䣺" + ((Watched)arg0).getData());		
	}

}
