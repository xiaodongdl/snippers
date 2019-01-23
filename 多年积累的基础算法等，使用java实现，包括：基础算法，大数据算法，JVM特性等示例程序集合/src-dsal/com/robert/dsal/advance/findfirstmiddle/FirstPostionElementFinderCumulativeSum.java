package com.robert.dsal.advance.findfirstmiddle;

import java.util.ArrayList;
import java.util.List;

public class FirstPostionElementFinderCumulativeSum implements
		FirstPositionElementFinder {
	private static boolean less(int i, int j) {
		return i < j;
	}

	public int findFirstPositionElement(int[] seq) {
		List<Integer> result = new ArrayList<Integer>();

		int left[] = new int[seq.length];
		int right[] = new int[seq.length];

		// ����������������ģ������������С��
		int i, max = seq[0], min = seq[seq.length - 1];

		// ��¼ÿ��Ԫ�����ڵ�ǰλ��֮ǰ��С��ֵ
		for (i = 0; i < seq.length; i++) {
			if (less(max, seq[i]))
				max = seq[i];
			left[i] = max;
		}

		// ��¼ÿ��Ԫ�����ڵ�ǰλ��֮������ֵ
		// It is OK to use the only n extra space
		for (i = seq.length - 1; i > -1; i--) {
			if (less(seq[i], min))
				min = seq[i];
			right[i] = min;
		}

		// ���ĳ��Ԫ��������С��ͬ��Ҳ���Ƕ���ǰ����˵�����ģ����ں�����˵����С�����Ծ�Ҫ�����Ԫ��
		for (i = 0; i < seq.length; i++)
			if (left[i] == right[i])
				result.add(seq[i]);

		if (result.size() > 0)
			return result.get(0);
		return -1;
	}
}
