package com.robert.jvm.generic.syntax;

public class SyntaxTest {
	public static void main(String[] args) {
		// ����ģ�嶨��ʱ������Ͳ�������ģ��ʵ����ʱ�������ָ����������ʹ�����½죬��������ʵ�����е�ģ��ƥ���

		// �����Զ��Ʋ�����ʵ����
		ValueTest<Integer> valueTest = new ValueTest();
		// <>�������������ʿ��ģ��ʵ����
		ValueTest<Integer> valueTest1 = new ValueTest<>();
		ValueTest<Integer> valueTest2 = new ValueTest<Integer>();

		// ��ʵ������ʱ�������ģ��ƥ��
		ValueTest<?> valueTest3 = new ValueTest<Integer>();
		ValueTest<Integer> valueTest4 = new ValueTest<Integer>();

		// ?ģ��ƥ��ģ���Ҫǿ��ת��
		Integer i1 = (Integer) valueTest3.method();
		Integer i2 = valueTest4.method();

		ValueTest<? extends Object> valueTest5 = new ValueTest();

		// ��ʾ��ʵ����ģ��
		valueTest5.<String> method1();

		// ��ʽʵ����ģ��
		String s = valueTest5.method1();

	}
}

class ValueTest<T extends Object> {
	T value;

	T method() {
		return null;
	}

	<E> E method1() {
		return null;
	}
}
