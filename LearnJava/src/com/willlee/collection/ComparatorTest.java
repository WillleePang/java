package com.willlee.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
	public static void main(String[] args) {
		List<User1> users = new ArrayList<User1>();
		users.add(new User1("egg", 21));
		users.add(new User1("niu", 22));
		users.add(new User1("gg", 29));
		UserComparator comparator = new UserComparator();
		Collections.sort(users, comparator);
		for (User1 user : users) {
			System.out.println(user.getUsername() + " " + user.getAge());
		}
	}
}

class User1 {
	private String username;
	private int age;

	public User1(String username, int age) {
		super();
		this.username = username;
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class UserComparator implements Comparator<User1> {

	@Override
	public int compare(User1 user1, User1 user2) {
		int age1 = user1.getAge();
		int age2 = user2.getAge();
		if (age1 < age2) {
			return 1;
		}
		return 0;
	}

}