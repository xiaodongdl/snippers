package com.robert.dsal.sort;

public class ShellSort implements Sort {

	public void sort(int[] seq) {
		// ѡ�񲽳�
		int h = 1;
		while (h < seq.length)
			h = 3 * h + 1;

		// ѭ��ÿһ�����������1λ��
		h /= 3;
		while (h > 0) {
			// ����ÿ�������е�ÿһ��������ִ��һ��ð������
			for (int i = seq.length / h * h; i > 0; i -= h) {
				for (int j = 0; j < i; j++) {
					if (j + h < seq.length && seq[j] > seq[j + h])
						swap(seq, j, j + h);
				}
			}

			h /= 3;
		}

	}

	private void swap(int[] seq, int i, int j) {
		int t = seq[i];
		seq[i] = seq[j];
		seq[j] = t;
	}

}
