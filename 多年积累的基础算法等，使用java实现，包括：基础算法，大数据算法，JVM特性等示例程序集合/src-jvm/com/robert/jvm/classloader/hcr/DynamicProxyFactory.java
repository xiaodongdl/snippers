package com.robert.jvm.classloader.hcr;

import java.lang.reflect.Proxy;

/**
 * java������ʵ��
 * 
 * @author Robert
 */
public class DynamicProxyFactory {
	/*
	 * ����������
	 */
	private DefaultInvocationHandler invocationHandler;

	public DynamicProxyFactory() {
		this(null);
	}

	/**
	 * 
	 * @param invocationHandler
	 */
	public DynamicProxyFactory(DefaultInvocationHandler invocationHandler) {
		if (invocationHandler == null) {
			this.invocationHandler = new DefaultInvocationHandler();
		} else {
			this.invocationHandler = invocationHandler;
		}
	}

	/**
	 * �����������
	 * 
	 * @param target
	 * @return
	 */
	public Object newProxyInstance(final Object target) {
		invocationHandler.setTarget(target);
		Object proxy = Proxy.newProxyInstance(target.getClass()
				.getClassLoader(), target.getClass().getInterfaces(),
				invocationHandler);
		return proxy;
	}
}
