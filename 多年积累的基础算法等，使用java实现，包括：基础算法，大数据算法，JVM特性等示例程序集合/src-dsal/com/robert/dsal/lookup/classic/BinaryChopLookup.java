package com.robert.dsal.lookup.classic;

import java.util.Arrays;

/**
 * �㷨���ƣ�
 * 
 * ���ֲ��һ����۰����
 * 
 * �㷨������
 * 
 * 1.ȡ���������м��ֵ���������Ŀ�����������ҵ��� �� ������������ 2.���Ŀ������С���м������������������l��m-1�����в��ҡ�
 * 3.���򣬵���������m+1��h�����в��ҡ�
 * 
 * ʱ�临�Ӷȣ�
 * 
 * O(logN) ����1��ʣ�� n/2 ����2��ʣ�� n/4 ����3��ʣ�� n/8 .......... ����x��ʣ��n/2^x 2^x = n => x=
 * logN
 * 
 * �ؼ��㣺
 * 
 * 1.1000��������Ҫ10����1000000��������Ҫ20�����ɼ�����Խ����ֲ���Խ�죬logN�������ݵ������Ӷ����ӵ����Ʊ�С��С�����ԡ�
 * 2.���ֲ���Ҫ����������������������С� 3.ѭ����ֹ������l > r��
 * 
 */
public class BinaryChopLookup extends AbstractLookup {
	@Override
	public void setup(int[] seq) {
		super.setup(seq);

		Arrays.sort(seq);
	}

	@Override
	public int lookup(int t) {
		return lookup(seq, 0, seq.length - 1, t);
	}

	private int lookup(int[] seq, int l, int r, int t) {
		// ������>=, ����=��ʵ���ж���һ��seq[l] == t��������ѭ��������ж�
		while (l <= r) {
			// �ֳ��������� l - m-1, m, m+1 - r
			int m = (l + r) / 2;
			if (seq[m] == t)
				return m;

			if (t < seq[m])
				r = m - 1;
			else
				l = m + 1;
		}
		return -1;
	}
}
