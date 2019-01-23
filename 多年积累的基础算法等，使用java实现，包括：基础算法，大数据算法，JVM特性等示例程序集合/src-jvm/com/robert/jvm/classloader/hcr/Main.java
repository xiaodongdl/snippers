package com.robert.jvm.classloader.hcr;

import java.io.IOException;

/**
 * Hot Code Replacement(HCR)
 * 
 * Ҫʵ������ȼ��أ�����ʹ�ø���ͽӿڣ�������߽ӿ���App ClassLoader�м��أ�
 * �����ڿͻ�����ClassLoader�м��أ�����Ҫ�滻���ʱ��ͬʱ��Ҫ�滻ClassLoader��ʵ���� �������ڸ�����߽ӿ���App
 * ClassLoader�м��أ���˼�ʹ����ClassLoaderҲ���᲻ƥ��
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, InterruptedException {
		ClassManager manager = new ClassManager();
		String className = "com.robert.jvm.classload.Test";
		ITest t = (ITest) manager.getInstanceProxy(className);
		t.test();

		int size = 5;
		int i = 0;
		while (i < size) {
			System.out.println(i);
			i++;
			Thread.currentThread().sleep(1000);
		}

		t.test();

		i = 0;
		while (i < size) {
			System.out.println(i);
			i++;
			Thread.currentThread().sleep(1000);
		}

		t.test();

		long beginTime1 = System.currentTimeMillis();
		int count = 10000;
		for (int k = 0; k < count; k++) {
			t.test();
		}
		long endTime1 = System.currentTimeMillis();

		ITest t2 = new Test();
		long beginTime2 = System.currentTimeMillis();
		for (int k = 0; k < count; k++) {
			t2.test();
		}
		long endTime2 = System.currentTimeMillis();

		System.out.println("proxy time=======" + (endTime1 - beginTime1));
		System.out.println("no proxy time=======" + (endTime2 - beginTime2));

	}

}