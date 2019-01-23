package com.robert.dsal.sort;

public class MergeSort implements Sort {

	public void sort(int[] seq) {
		int[] tmp = new int[seq.length];
		sort(seq, 0, seq.length, tmp);
	}

	private void sort(int[] seq, int start, int end, int[] tmp) {
		// ���ʣ��һ��Ԫ�أ���Ȼ�������
		if (start + 1 == end) {
			tmp[start] = seq[start];
			return;
		}

		int mid = (start + end) / 2;

		// �ֳ����飬�ֱ����У����к�������seq�� tmp��Զ�Ǹ���ʱ�ռ�
		sort(seq, start, mid, tmp);
		sort(seq, mid, end, tmp);

		int i = start, j = mid;

		// ��·�鲢
		int c = start;
		while (i != mid && j != end) {
			if (seq[i] < seq[j])
				tmp[c++] = seq[i++];
			else
				tmp[c++] = seq[j++];

		}

		if (i == mid)
			for (int k = j; k < end; k++)
				tmp[c++] = seq[k];

		if (j == end)
			for (int k = i; k < mid; k++)
				tmp[c++] = seq[k];

		// �����������ݹ鲢��ԭ����
		for (int k = start; k < end; k++)
			seq[k] = tmp[k];

	}

}
