package com.willlee.designpatterns.observer.carexample;

public class Client {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		//创建主题对象
		CarInfoManager iSubject = new CarInfoManager();
		//创建观察者
		CarCostInfo costOb = new CarCostInfo(iSubject);
		CarListInfo listOb = new CarListInfo (iSubject);
		//主题状态更新、通知各观察者
		iSubject.setDeptName("财务部");
		iSubject.setDeptName("技术部");
	}
}
