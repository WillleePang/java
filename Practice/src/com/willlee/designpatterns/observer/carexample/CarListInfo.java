package com.willlee.designpatterns.observer.carexample;

public class CarListInfo implements Observer {

	private CarInfoManager iManager;

	public CarListInfo() {
		iManager = null;
	}

	public CarListInfo(CarInfoManager aManager) {
		iManager = aManager;
		iManager.register(this);
	}

	public void update(Observable subject) { // 显示车辆列表信息
		if (subject == iManager) {
			// 收到通知，获取新状态，更新显示信息
			String deptName = iManager.getDeptName();
			System.out.println(deptName+"更新车辆列表信息");
		}

	}

	public void setManager(CarInfoManager aManager) {
		iManager = aManager;
		iManager.register(this);
	}

}
