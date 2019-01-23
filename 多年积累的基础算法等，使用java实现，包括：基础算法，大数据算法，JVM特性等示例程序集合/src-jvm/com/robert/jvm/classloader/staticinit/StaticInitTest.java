package com.robert.jvm.classloader.staticinit;

public class StaticInitTest {
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		/*
			// ��̬��ʼ��
			Class<?> clazz = Class.forName("com.robert.jvm.classloader.staticinit.InitObject");
			// �Ѿ���ʼ����
			clazz.newInstance();
		*/

		/*
			// û�о�̬��ʼ��
			Class clazz = Class.forName("com.robert.jvm.classloader.staticinit.InitObject",false, StaticInitTest.class.getClassLoader());
			// ʵ������ʱ��̬��ʼ��
			clazz.newInstance();
		*/

		// ִ�о�̬��ʼ
		Class<?> c = ClassLoader.getSystemClassLoader().loadClass("com.robert.jvm.classloader.staticinit.InitObject");
		// ʵ������ʱ��ִ�о�̬��ʼ��
		c.newInstance();
		
		// �ܽᣬĬ��Class.forNameִ�о�̬��ʼ�������ǿ�����ʾ�Ĵ���������о�̬��ʼ����ClassLoader.loadClass��ִ�о�̬��ʼ��
		// Class.newInstance��ʱ�����û�г�ʼ��������ô�ͽ��г�ʼ��
	}
}

class InitObject {
	static {
		System.out.println("Static Init...");
	}
}