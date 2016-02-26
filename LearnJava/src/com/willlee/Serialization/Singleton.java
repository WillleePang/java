package com.willlee.Serialization;

import java.io.Serializable;

public class Singleton implements Serializable {

  private static final long serialVersionUID = 1L;
  private volatile static Singleton singleton;

  private Singleton() {}

  public static Singleton getSingleton() {
    if (singleton == null) {
      synchronized (Singleton.class) {
        if (singleton == null) {
          singleton = new Singleton();
        }
      }
    }
    return singleton;
  }

  // 只要在Singleton类中定义readResolve就可以解决该问题：
  private Object readResolve() {
    return singleton;
  }
}
