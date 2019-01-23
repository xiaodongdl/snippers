package com.robert.dsal.lookup.app.minn;

import java.util.Arrays;

/**
 * 
 * ���ǵ������������и�����Ҳ���Ƿ�Χ��-N...N������Ҫ���⴦���ϸ��N+M�β����ǲ�����ɵģ����Ǹ��Ӷȿɿ�����O(N+M)��Χ�ڡ�
 * 
 */
public class FindMinNImpl1 implements FindMInN {

	public int[] findMInN(int[] x) {
		int[] result = new int[x.length];
		int count = 0;

		// �Ѹ�������ǰ�棬�������ں��棬k�����һ������
		int k = partition(x);

		// �Ѹ��������������Ϊk+1ǰ���ֵ���Ǹ����������Ϣ��Ȼ����
		for (int i = 0; i <= k; i++) {
			x[i] = -x[i];
		}

		// ��������Χ
		for (int i = 0; i <= k; i++) {
			// ȡ��Ŀ������
			int v = x[i];
			if (v < 0)
				v = -v;
			v--;

			// ���Ŀ���Ǹ�ֵ�����ʾ���ظ�Ԫ��
			if (x[v] < 0)
				result[count++] = -(v + 1); // ��Ϊk��ǰ�Ǹ��������ԣ���Ҫ���ϸ��������������������

			// toggle��־λ
			x[v] = -x[v];
		}

		// �������еĸ���Ϊ����
		for (int i = 0; i < result.length; i++) {
			if (x[i] < 0)
				x[i] = -x[i];
		}

		// ����������Χ
		for (int i = k + 1; i < x.length; i++) {
			// ȡ��Ŀ������
			int v = x[i];
			if (v < 0)
				v = -v;
			v--;

			// ����ظ�������
			if (x[v] < 0)
				result[count++] = v + 1;

			// toggle��־λ
			x[v] = -x[v];
		}

		return Arrays.copyOfRange(result, 0, count);
	}

	private int partition(int[] x) {
		int k = -1;
		for (int i = 0; i < x.length; i++) {
			if (x[i] < 0)
				swap(x, ++k, i);
		}

		return k;
	}

	private void swap(int[] x, int i, int j) {
		int tmp = x[i];
		x[i] = x[j];
		x[j] = tmp;
	}

}
