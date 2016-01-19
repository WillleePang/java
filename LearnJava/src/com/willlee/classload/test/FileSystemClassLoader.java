package com.willlee.classload.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 用来加载存储在文件系统上的 Java 字节代码
 * 
 * @author Administrator
 * 
 */
public class FileSystemClassLoader extends ClassLoader {
	private String rootDir;

	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}

	//查找class
	protected Class<?> findClass(String className)
			throws ClassNotFoundException {
		byte[] classData = getClassData(className);
		if (classData == null) {
			throw new ClassNotFoundException();
		} else {
			//执行定义加载器
			return defineClass(className, classData, 0, classData.length);
		}

	}

	//将类转换成字节数据
	protected byte[] getClassData(String className) {
		String path = classNameToPath(className);
		try {
			InputStream ins = new FileInputStream(path);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesNumRead = 0;
			while ((bytesNumRead = ins.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesNumRead);
			}
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	//获取类的路径
	protected String classNameToPath(String className) {
		return rootDir + File.separatorChar
				+ className.replace('.', File.separatorChar) + ".class";
	}

}
