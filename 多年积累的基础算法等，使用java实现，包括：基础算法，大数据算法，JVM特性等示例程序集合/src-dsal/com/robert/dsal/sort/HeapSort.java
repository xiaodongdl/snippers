package com.robert.dsal.sort;

import com.robert.dsal.util.AlUtil;

/**
 * 
 * ������һ����Ҫѡ�����һ����������С�ģ����һ����Ҫn�Σ�ÿ���ҳ����Ļ�����С��Ԫ�غ���Ҫ����������Ϊ��������Ķ�������
 * ÿ�������Ҫ����log2N��Ԫ�أ����ԣ����Ӷ���NLog2N
 * 
 * 
 * http://www.cnblogs.com/dolphin0520/archive/2011/10/06/2199741.html
 * http://blog.csdn.net/morewindows/article/details/6709644
 * 
 */
public class HeapSort implements Sort {

	private static void adjustHeap(int[] data, int start, int end) {
		while (2 * start + 1 < end) {
			int max = 2 * start + 1;
			if (2 * start + 2 < end) {
				if (data[2 * start + 2] > data[max])
					max = 2 * start + 2;
			}

			if (data[max] > data[start]) {
				int tmp = data[start];
				data[start] = data[max];
				data[max] = tmp;

				start = max;
			} else {
				break;
			}
		}
	}

	private static void sortHeap(int[] data, int start, int end) {
		for (int i = end - 1; i > 0; i--) {
			AlUtil.swap(data, 0, i);

			adjustHeap(data, start, i);
		}
	}

	public void sort(int[] seq) {
		// ����һ����Ҷ�ӽڵ㣬����Ҷ�ӽڵ㣬����ÿһ����Ҷ�ӽڵ����һ�ε���
		for (int i = seq.length / 2; i >= 0; i--) {
			adjustHeap(seq, i, seq.length);
		}

		// ÿ���ó���һ����һ����n�Σ���������log2N,��������Ӷ���nlog2N
		sortHeap(seq, 0, seq.length);
	}
}
