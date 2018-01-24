package com.willlee.designpatterns.observer.carexample;

public class CarCostInfo implements Observer {

	private CarInfoManager iManager;

	public CarCostInfo() {
		iManager = null;
	}

	public CarCostInfo(CarInfoManager aManager) {
		iManager = aManager;
		iManager.register(this);
	}

	public void update(Observable subject) { // 显示车辆费用信息
		if (subject == iManager) {
			// 收到通知，获取新状态，更新显示信息
			String deptName = iManager.getDeptName();
			System.out.println(deptName+"更新车辆费用");
		}
	}

	public void setManager(CarInfoManager aManager) {
		iManager = aManager;
		iManager.register(this);
	}

}
