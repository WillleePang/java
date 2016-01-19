package com.willlee.designpatterns.proxy.fontprovider;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class LogProviderHandler implements InvocationHandler {
	private Object target;

	public LogProviderHandler(Object target) {
		super();
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Type[] types = method.getParameterTypes();
		if (method.getName().matches("get.+") && types.length == 1
				&& types[0] == String.class) {
			
			System.out.println("log "+proxy.getClass()+" provider is working!");
		}
		return method.invoke(target, args);
	}
}
