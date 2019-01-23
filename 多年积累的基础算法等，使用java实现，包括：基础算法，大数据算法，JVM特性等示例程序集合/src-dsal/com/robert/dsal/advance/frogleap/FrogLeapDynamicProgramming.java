package com.robert.dsal.advance.frogleap;

/**
 * 
 * O(n*l), l��Ԫ�ص�ƽ������Ҳ����ÿ�γ��Ե�ƽ������
 * 
 */
public class FrogLeapDynamicProgramming implements FrogLeap {
	public int[] fropLeap(int[] x) {
		// �����������һ��Ԫ����Ҫ����������С�Ĳ�����
		int[] vector = new int[x.length];
		vector[vector.length - 1] = 0;

		// �����������һ��Ԫ����Ҫ����������С�Ĳ��������һ��Ԫ������
		int[] next = new int[x.length];
		next[next.length - 1] = -1;

		for (int i = x.length - 2; i >= 0; i--) {
			// �����ǰԪ����0�������������һ��Ԫ�أ�������Ԫ��
			if (x[i] == 0) {
				vector[i] = -1;
				next[i] = -1;
				continue;
			}

			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			// ��ѭ����������ݾ���һ����̬�滮������ÿһ��ѭ����һ���׶Σ�ÿ���׶�Ҫ������ô����������죬ÿ���ܹ���ǰ�ƶ�һ��Ԫ�أ����������ֽṹ���ص�
			/** ��̬�滮����
			 * if (canJump2End())
			 *	 minSteps[i] = 1;
			 * else 
			 *   minSteps[i] = min(1 + minSteps[i + x]); // x is [1,value[i]]
			**/
			for (int j = 1; j <= x[i]; j++) {
				if (i + j >= x.length - 1) {
					// ���һ�����������һ��Ԫ��
					min = 1;
					minIndex = x.length - 1;
				} else if (x[i + j] != -1 && vector[i + j] + 1 < min) {
					// �ҵ������Ǹ�Ԫ�ص����һ��Ԫ�������ٲ����
					min = vector[i + j] + 1;
					minIndex = i + j;
				}
			}

			if (minIndex != -1) {
				// �ҵ�һ����С����
				vector[i] = min;
				next[i] = minIndex;
			} else {
				// û���ҵ���С����
				vector[i] = -1;
				next[i] = -1;
			}
		}

		// �������
		int[] results = new int[vector[0] + 1];

		results[0] = 0;
		for (int i = 1; i < results.length; i++) {
			results[i] = next[results[i - 1]];
		}

		return results;
	}
}
