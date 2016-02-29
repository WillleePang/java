package com.willlee.Serialization.java5things;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static void main(String[] args) {
		try {
			Person ted = new Person("Ted", "Neward", 39, Gender.FEMALE);
			Person charl = new Person("Charlotte", "Neward", 38, Gender.MALE);
			ted.setSpouse(charl);
			charl.setSpouse(ted);
			FileOutputStream fos = new FileOutputStream("tempdata.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ted);
			oos.close();
		} catch (Exception ex) {
			System.out
					.println("Exception thrown during test: " + ex.toString());
		}
		try {
			FileInputStream fis = new FileInputStream("tempdata.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Person ted = (Person) ois.readObject();
			System.out.println(ted);
			ois.close();
			new File("tempdata.ser").delete();
		} catch (Exception ex) {
			System.out
					.println("Exception thrown during test: " + ex.toString());
		}
	}
}
