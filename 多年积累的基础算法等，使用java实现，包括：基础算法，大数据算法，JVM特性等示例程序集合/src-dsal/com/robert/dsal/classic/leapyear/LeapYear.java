package com.robert.dsal.classic.leapyear;

/**
 * 
 * ����һ�򣬰��겻���İ�������
 * 
 * ���ܱ�4�������ǲ��ܱ�100�����������ܱ�400�����������꣬���������ꡣ
 * 
 */
public class LeapYear {
	public boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
}
