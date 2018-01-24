package com.willlee.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		users.add(new User("egg", 23));
		users.add(new User("niu", 22));
		users.add(new User("qing", 28));

		Collections.sort(users);
		for (User user : users) {
			System.out.println(user.getName() + " " + user.getAge());
		}
	}
}

class User implements Comparable<Object> {
	private String name;
	private int age;

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Object o) {
		return this.age - ((User) o).getAge();
	}
}