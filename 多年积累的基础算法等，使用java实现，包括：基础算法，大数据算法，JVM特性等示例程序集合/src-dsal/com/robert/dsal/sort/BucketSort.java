package com.robert.dsal.sort;

import com.robert.dsal.util.AlUtil;

/**
 * 
 * ���մ����ҵ�ÿһ����������ÿ�������Ϊ���飬һ��С�ģ�һ����ȵģ�����һ���ģ�������ȵ�������һ���������򣬶��ڴ�С��������ݹ�
 * 
 * �����RadixSort.java��˵�����ַ����Ǵ����ң���Ͱ�󣬶���ÿͰ����ݹ���ȥ
 * 
 */

public class BucketSort implements Sort {
	private boolean equal(int left, int right, int d) {
		int datal = left / d % 10;
		int datar = right / d % 10;

		return datal == datar;
	}

	private boolean less(int left, int right, int d) {
		int datal = left / d % 10;
		int datar = right / d % 10;

		return datal < datar;
	}

	public void bucketRadix(int[] seq, int start, int end, int d) {
		// �����ֵ������浽�������ÿ��������һ�εݹ飬ֱ�����������ʣ��һ��Ԫ�أ�һ��Ԫ�ؾ����Ѿ�����ģ����d=0����ô����Ԫ�ص����һ�����ֻ�һ����Ҳ����ʣ��Ԫ�ظ��������
		if (start >= end || d == 0)
			return;

		int base = seq[start];
		int l = start;
		int r = end;

		// �Ե�һ��Ԫ����d������Ϊ���ֵĻ�׼����Ԫ�طֳ�3�飬start~l-1:С�ڵ�һ��Ԫ�أ�l~m�����ڵ�һ��Ԫ�صģ�m~end:���ڵ�һ��Ԫ��
		for (int i = start + 1; i <= r; i++) {
			if (less(seq[i], base, d)) {
				AlUtil.swap(seq, ++l, i);
			} else if (equal(seq[i], base, d)) {
				AlUtil.swap(seq, i--, r--);
			}
		}

		// �ѵ�һ��Ԫ�ط����С���м�
		AlUtil.swap(seq, start, l);

		// �Ѻ�����������Ԫ�ص������м�
		int m = l;
		for (int i = r + 1; i <= end; i++) {
			AlUtil.swap(seq, ++m, i);
		}

		// �ݹ�����С�ڵļ��ϣ����ڵļ��ϣ����е��ڵļ����Ժ������������
		bucketRadix(seq, start, l - 1, d);
		bucketRadix(seq, l, m, d / 10);
		bucketRadix(seq, m + 1, end, d);
	}

	public void sort(int seq[]) {
		bucketRadix(seq, 0, seq.length - 1, 1000000000);
	}
}
