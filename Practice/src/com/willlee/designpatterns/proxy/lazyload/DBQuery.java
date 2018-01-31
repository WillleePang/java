package com.willlee.designpatterns.proxy.lazyload;

public class DBQuery implements IDBQuery {

	public DBQuery() {
		try {
			Thread.sleep(1000);// �������ݿ����ӵȺ�ʱ����
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("��ʼ��DBQuery���");
	}

	public String request() {
		// TODO Auto-generated method stub
		return "request string";
	}

}
