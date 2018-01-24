package com.willlee.designpatterns.observer.carexample;

import java.util.Vector;

public class CarInfoManager implements Observable {

	//维护一个观察者列表
	private Vector<Observer> observersList;

	//部门名称
	private String deptName;

	public CarInfoManager() throws Exception {
		observersList = new Vector<Observer>();
	}

	public void register(Observer obs) {
		// 动态观察者链表中添加观察者
		observersList.addElement(obs);
	}

	public void unRegister(Observer obs) {
		// 观察者链表中删除观察者
		observersList.removeElement(obs);

	}

	public void notifyObservers() {
		// 向所有观察者发送通知
		for (int i = 0; i < observersList.size(); i++) {
			Observer observer = (Observer) observersList.elementAt(i);
			observer.update(this);
		}

	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String dept) {
		deptName = dept;
		notifyObservers(); // 此处向观察者发送通知
	}
}
