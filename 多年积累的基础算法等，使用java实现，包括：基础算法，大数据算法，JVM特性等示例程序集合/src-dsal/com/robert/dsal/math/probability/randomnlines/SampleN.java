package com.robert.dsal.math.probability.randomnlines;

import java.util.Iterator;

// TODO �ٿ�������ᣬ����������ص���ֵ��������������϶�����֪����������

/**
 
����һ������ int rd()�� �������50%���� 0 , 50%����1. ����дһ���º����� 25%����0 �� 75%����1

rand() + rand() * 2  % 4 == 0 

Robert Lee 6/18/2014 3:22:21 PM
�������1/4�ĸ���

Robert Lee 6/18/2014 3:22:41 PM
ȡ��������rand() + rand() * 2 % 4 != 0

Robert Lee 6/18/2014 3:22:48 PM
�������3/4�ĸ���

rd*rd != 0

*/

/**
 * 
 * ����һ�ַ�������ÿ��ѡ��һ����Ȼ���ȥ���Ԫ�أ���sample
 * 
 */
public interface SampleN {
	public int[] sample(Iterator<Integer> x, int n);
}
