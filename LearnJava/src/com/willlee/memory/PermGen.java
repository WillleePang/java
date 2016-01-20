package com.willlee.memory;

import java.util.ArrayList;

/**
 * 方法区是存放虚拟机加载类的相关信息，如类、静态变量和常量，大小由-XX:PermSize和-XX:MaxPermSize来调节，类太多有可能撑爆永久带
 * 加上永久带的JVM参数：-XX:PermSize=10M -XX:MaxPermSize=10M
 * @author Administrator
 * 
 */
public class PermGen {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();  
        int i=0;  
        while(true){  
            list.add(String.valueOf(i++).intern());  
        }  
	}
}
