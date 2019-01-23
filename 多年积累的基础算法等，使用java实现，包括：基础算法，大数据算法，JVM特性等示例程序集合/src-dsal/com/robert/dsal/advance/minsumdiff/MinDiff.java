package com.robert.dsal.advance.minsumdiff;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ������1-50�����֣���ÿ������ȡ����������һ������1^3 - 50^3, ����Ҫ����50�����ֳ����飬ÿ��25�����֣���ÿ������֮�������С�ķַ���
 * 
 */

public interface MinDiff {
	class Result {
		int diff = Integer.MAX_VALUE;

		List<Integer> c1 = new ArrayList<Integer>();
		List<Integer> c2 = new ArrayList<Integer>();
	}

	public Result minDiff(int start, int end, int power);
}
