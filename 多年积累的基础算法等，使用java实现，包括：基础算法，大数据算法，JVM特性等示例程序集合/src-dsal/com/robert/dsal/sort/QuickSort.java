package com.robert.dsal.sort;

import com.robert.dsal.util.AlUtil;

/**
 * <b>�㷨����:</b><br>
 * 1. ��һ�η����ҵ�һ��Ԫ�ص���ȷλ�á�<br>
 * 2. Ȼ�����з�Ϊ���������У���Ԫ��֮ǰ�����кʹ�Ԫ��֮������С�<br>
 * 3. �ݹ����������������С�
 * <p>
 * <b>ʱ�临�Ӷȣ�</b><br>
 * O(NlogN)<br>
 * n + 2*n/2 + 4*n/4 + ....(һ��logN��)�� �����NLogN�
 * 
 * ����1��N�Σ��ҵ�1��
 * ����2��N�Σ��ҵ�2��
 * ����3��N�Σ��ҵ�4��
 * ����4��N�Σ��ҵ�8��
 * ����5��N�Σ��ҵ�16��
 * ����6��N�Σ��ҵ�32��
 * ����x��N�Σ��ҵ�n��
 * 2^x = n
 * һ������logn�Σ�ÿ��ִ��N�ζԱȣ������NLogN
 * 
 */
public class QuickSort implements Sort {

	private int partition(int[] seq, int l, int r) {
		// �����ѡȡ���Ż��������������ɵ�����O(n^2����ʱ�临�Ӷȡ�
		int tmp = seq[l];
		int k = l;
		for (int i = l + 1; i <= r; i++)
			if (seq[i] < tmp)
				AlUtil.swap(seq, i, ++k);
		AlUtil.swap(seq, l, k);
		return k;
	}

	private void sort(int[] seq, int l, int r) {
		if (l > r)
			return;

		int index = partition(seq, l, r);

		sort(seq, l, index - 1);
		sort(seq, index + 1, r);
	}

	public void sort(int[] seq) {
		sort(seq, 0, seq.length - 1);
	}

}
