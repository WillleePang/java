package com.willlee.designpatterns.proxy.lazyload;

public class DBQueryProxy implements IDBQuery {

	public DBQueryProxy() {
		super();
		System.out.println("��ʼ��DBQueryProxy���");
	}

	private DBQuery real = null;

	public String request() {
		// TODO Auto-generated method stub
		// ��������Ҫ��ʱ����ܴ�����ʵ���󣬴������̿��ܺ���
		if (real == null) {
			real = new DBQuery();
		}// �ڶ��̻߳����£����ﷵ��һ������࣬������ Future ģʽ
		return real.request();
	}

}
