package com.willlee.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		TreeMap<Student, StudentDetailInfo> map = new TreeMap<Student, StudentDetailInfo>();
		Student s1 = new Student("1", 100);
		Student s2 = new Student("2", 99);
		Student s3 = new Student("3", 97);
		Student s4 = new Student("4", 91);
		map.put(s1, new StudentDetailInfo(s1));
		map.put(s2, new StudentDetailInfo(s2));
		map.put(s3, new StudentDetailInfo(s3));
		map.put(s4, new StudentDetailInfo(s4));

		// ��ӡ����λ�� S4 �� S2 ֮�����
		Map<Student, StudentDetailInfo> map1 = ((TreeMap<Student, StudentDetailInfo>) map)
				.subMap(s4, s2);
		for (Iterator<Student> iterator = map1.keySet().iterator(); iterator
				.hasNext();) {
			Student key = (Student) iterator.next();
			System.out.println(key + "->" + map.get(key));
		}
		System.out.println("subMap end");

		// ��ӡ������ s1 �͵���
		map1 = ((TreeMap<Student, StudentDetailInfo>) map).headMap(s1);
		for (Iterator<Student> iterator = map1.keySet().iterator(); iterator
				.hasNext();) {
			Student key = (Student) iterator.next();
			System.out.println(key + "->" + map.get(key));
		}
		System.out.println("subMap end");

		// ��ӡ������ s1 �ߵ���
		map1 = ((TreeMap<Student, StudentDetailInfo>) map).tailMap(s1);
		for (Iterator<Student> iterator = map1.keySet().iterator(); iterator
				.hasNext();) {
			Student key = (Student) iterator.next();
			System.out.println(key + "->" + map.get(key));
		}
		System.out.println("subMap end");
	}

}

class Student implements Comparable<Student> {

	public String name;
	public int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if (o.score < this.score) {
			return 1;
		} else if (o.score > this.score) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("name:");
		sb.append(name);
		sb.append(" ");
		sb.append("score:");
		sb.append(score);
		return sb.toString();
	}
}

class StudentDetailInfo {
	Student s;

	public StudentDetailInfo(Student s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return s.name + "'s detail information";
	}
}
