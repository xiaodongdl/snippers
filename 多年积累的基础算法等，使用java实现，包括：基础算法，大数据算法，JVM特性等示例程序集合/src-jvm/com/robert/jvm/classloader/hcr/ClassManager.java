package com.robert.jvm.classloader.hcr;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * �������Զ�̬���µ�java����<br>
 * ����:���캯�������в��� ����ʵ��һ���ӿ� ֻ����ʵ������(��Ϊ�ӿ��в����о�̬����)
 * 
 * @author Robert
 */
public class ClassManager {
	/**
	 * ������·����ʱ��
	 */
	private static Map mapModify = new HashMap();
	/**
	 * ���౻����ʱ��ʱ��
	 */
	private static Date firstDate = new Date();

	/**
	 * ���class�ļ��������ɹ����Զ�����,ֻ�����´����Ż����
	 * 
	 * @param name
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Object getInstance(String name) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, IOException {
		Class c = Class.forName(name);
		Class cNew = reloadClass(c);
		if (cNew == null) {
			cNew = c;
		}
		Object o = cNew.newInstance();
		return o;
	}

	/**
	 * �����������,���class�ļ��������ɹ����Զ�����,����ԭ����ʵ�����ķ���ʱҲ�������
	 * 
	 * @param name
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Object getInstanceProxy(String name) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, IOException {
		Object target = getInstance(name);

		DynamicProxyFactory factory = new DynamicProxyFactory(
				new HotInvocationHandler(this));

		return factory.newProxyInstance(target);
	}

	/**
	 * ���¼�����
	 * 
	 * @param c
	 * @return
	 * @throws IOException
	 */
	public synchronized Class reloadClass(Class c) throws IOException {
		Class cNew = null;
		if (hasChanged(c)) {
			cNew = loadClass(c);
		}
		return cNew;
	}

	private boolean hasChanged(Class c) throws IOException {
		boolean isChanged = false;
		String path = c.getResource(c.getSimpleName() + ".class").getPath();
		File f = new File(path);
		if (f.exists()) {
			Date newDate = new Date(f.lastModified());
			Date oldDate = null;
			String key = f.getCanonicalPath();
			if (mapModify.containsKey(key)) {
				oldDate = (Date) mapModify.get(key);
			} else {
				oldDate = firstDate;
			}
			isChanged = oldDate.compareTo(newDate) < 0;
			if (isChanged) {
				mapModify.put(key, newDate);
			}
		}
		return isChanged;
	}

	private Class loadClass(Class c) throws IOException {
		ClassLoaderAdvisor classLoader = new ClassLoaderAdvisor();
		Class cNew = classLoader.loadClass(c);
		return cNew;
	}

}
