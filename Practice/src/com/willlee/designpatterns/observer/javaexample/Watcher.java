package com.willlee.designpatterns.observer.javaexample;


public class Watcher implements Observer {
	
	public Watcher(Observable o) {
		o.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
        System.out.println("状态发生改变：" + ((Watched)arg0).getData());		
	}

}
