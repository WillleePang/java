package com.willlee.Serialization.java5things;

import java.io.Serializable;

class PersonProxy implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public PersonProxy(Person orig) {
		data = orig.getFirstName() + "," + orig.getLastName() + ","
				+ orig.getAge();
		if (orig.getSpouse() != null) {
			Person spouse = orig.getSpouse();
			data = data + "," + spouse.getFirstName() + ","
					+ spouse.getLastName() + "," + spouse.getAge();
		}
	}

	public String data;

	private Object readResolve() throws java.io.ObjectStreamException {

		String[] pieces = data.split(",");
		Person result = new Person(pieces[0], pieces[1],
				Integer.parseInt(pieces[2]));
		if (pieces.length > 3) {
			result.setSpouse(new Person(pieces[3], pieces[4], Integer
					.parseInt(pieces[5])));
			result.getSpouse().setSpouse(result);
		}
		return result;
	}
}

// 1. 序列化允许重构
// 序列化允许一定数量的类变种，甚至重构之后也是如此，ObjectInputStream 仍可以很好地将其读出来。
enum Gender {
	MALE, FEMALE
}

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	public Person(String fn, String ln, int a, Gender g) {
		this.firstName = fn;
		this.lastName = ln;
		this.age = a;
		this.gender = g;
	}

	public Person(String fn, String ln, int a) {
		this.firstName = fn;
		this.lastName = ln;
		this.age = a;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public Person getSpouse() {
		return spouse;
	}

	private Object writeReplace() throws java.io.ObjectStreamException {
		return new PersonProxy(this);
	}

	public void setFirstName(String value) {
		firstName = value;
	}

	public void setLastName(String value) {
		lastName = value;
	}

	public void setGender(Gender value) {
		gender = value;
	}

	public void setAge(int value) {
		age = value;
	}

	public void setSpouse(Person value) {
		spouse = value;
	}

	// 2.序列化并不安全
	// 3. 序列化的数据可以被签名和密封
	private void writeObject(java.io.ObjectOutputStream stream)
			throws java.io.IOException {
		// "Encrypt"/obscure the sensitive data
		age = age << 2;
		stream.defaultWriteObject();
	}

	private void readObject(java.io.ObjectInputStream stream)
			throws java.io.IOException, ClassNotFoundException {
		stream.defaultReadObject();

		// "Decrypt"/de-obscure the sensitive data
		age = age >> 2;
	}

	public String toString() {
		return "[Person: firstName=" + firstName + " lastName=" + lastName
				+ " gender=" + gender + " age=" + age + " spouse="
				+ spouse.getFirstName() + "]";
	}

	private String firstName;
	private String lastName;
	private int age;
	private Person spouse;
	private Gender gender;
}
