package com.robert.dsal.sort;

public class RadixSort implements Sort {

	// �Ӹ�λ����λһֱ���ϣ�ÿ��ȷ��һλ��˳�������λû�иı�˳������Ȼ�������˳�򣬷����ո�λ��

	// ��λ�������������ȼ�

	// �����BucketSort.java��˵��ÿ�η�Ͱ�����ݻ�����һ�������У����õݹ飬�ǵݹ��㷨

	public void sortRadix(int[] seq, int d) {
		int n = 1;
		int m = 1;
		int[][] temp = new int[10][seq.length];
		int[] order = new int[10];
		while (m <= d) {
			for (int i = 0; i < seq.length; i++) {
				int lsd = ((seq[i] / n) % 10);
				temp[lsd][order[lsd]] = seq[i];
				order[lsd]++;
			}
			int k = 0;
			for (int i = 0; i < 10; i++) {
				if (order[i] != 0)
					for (int j = 0; j < order[i]; j++) {
						seq[k] = temp[i][j];
						k++;
					}
				order[i] = 0;
			}
			k = 0;

			n *= 10;
			m++;
		}
	}

	public void sort(int seq[]) {
		// ֻ����10λʮ��������
		sortRadix(seq, 10);
	}
}
