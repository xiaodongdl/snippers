package com.robert.dsal.lookup.app.findrepeat;

/**
 * 
 * 1-1000���ں���1001��Ԫ�ص������У�ֻ��Ψһ��һ��Ԫ��ֵ�ظ���������ֻ����һ�Ρ�ÿ������Ԫ��ֻ�ܷ���һ�Σ����һ���㷨�������ҳ�����
 * ���ø����洢�ռ䣬�ܷ����һ���㷨ʵ�֣�
 * 
 */
public class SingleRepeatFinderDefault implements SingleRepeatFinder {

	public int findSingleRepeat(int[] seq) {
		int sum = seq[0];
		for (int i = 1; i < seq.length; i++)
			sum += seq[i];

		int result = sum - ((seq.length - 1) + 1) * (seq.length - 1) / 2;

		return result;
	}
}
