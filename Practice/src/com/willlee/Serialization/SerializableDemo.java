package com.willlee.Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.IOUtils;

public class SerializableDemo {
  public static void main(String[] args) {
    // Initializes The Object
    User user = new User();
    user.setName("hollis");
    user.setGender("male");
    user.setAge(23);
    user.setBirthday(new Date());
    System.out.println(user);
    // Write Obj to File
    ObjectOutputStream oos = null;
    try {
      oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
      oos.writeObject(user);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      IOUtils.closeQuietly(oos);
    }
    // Read Obj from File
    File file = new File("tempFile");
    ObjectInputStream ois = null;
    try {
      ois = new ObjectInputStream(new FileInputStream(file));
      User newUser = (User) ois.readObject();
      System.out.println(newUser);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      IOUtils.closeQuietly(ois);
    }


    List<String> list = new ArrayList<String>();
    list.add("hello");
    list.add("world");
    list.add("pang");
    list.add("willlee");
    System.out.println("init list:" + list);
    try {
      oos = new ObjectOutputStream(new FileOutputStream("stringList"));
      oos.writeObject(list);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      IOUtils.closeQuietly(oos);
    }
    file = new File("stringList");
    try {
      ois = new ObjectInputStream(new FileInputStream(file));
      @SuppressWarnings("unchecked")
      List<String> newList = (List<String>) ois.readObject();
      System.out.println("new list:" + newList);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      IOUtils.closeQuietly(ois);
    }

    // 序列化对单例的破坏
    // 通过对Singleton的序列化与反序列化得到的对象是一个新的对象，这就破坏了Singleton的单例性。
    // 序列化会通过反射调用无参数的构造方法创建一个新的对象。
    try {
      // Write Obj to file
      oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
      oos.writeObject(Singleton.getSingleton());
      // Read Obj from file
      file = new File("tempFile");
      ois = new ObjectInputStream(new FileInputStream(file));
      Singleton newInstance = (Singleton) ois.readObject();
      System.out.println(newInstance == Singleton.getSingleton());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      IOUtils.closeQuietly(ois);
    }


  }
}
