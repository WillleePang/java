package com.willlee.sourcecode.Enum;

public enum Color implements Behaviour {
	RED("��ɫ", 1), GREEN("��ɫ", 2), BLANK("��ɫ", 3), YELLO("��ɫ", 4);
	// ��Ա����
	private String name;
	private int index;

	// ���췽��
	private Color(String name, int index) {
		this.name = name;
		this.index = index;
	}

	// ��ͨ����
	public static String getName(int index) {
		for (Color c : Color.values()) {
			if (c.getIndex() == index) {
				return c.name;
			}
		}
		return null;
	}

	// get set ����
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	// ����toString����
	@Override
	public String toString() {
		return this.index + "_" + this.name;
	}

	public void print() {
		System.out.println(this.index + ":" + this.name);

	}

	public String getInfo() {
		return this.name;
	}
}
