package com.robert.dsal.lookup.app.minn;

import java.util.Arrays;

/**
 * 
 * �����ж���ռ䣬�Ǿ͵���ԭ�����������£�ʹ�÷���λ��ʾ״̬������������Ԫ��>=0, ��ĿҪ��Ҳ��1 .. N,ע���1��ʼ����Ҫ������Եת��
 * 
 * ������ж���Ŀռ������λͼ��hash�ȣ�λͼ�����n + m��ô��
 * 
 */

public class FindMInNImpl implements FindMInN {
	public int[] findMInN(int[] x) {
		// δ֪���
		int[] result = new int[x.length];
		int count = 0;

		// ����һ��O(N + M)
		for (int i = 0; i < x.length; i++) {
			// ��ǰԪ�ص�ֵ��ӳ��Ŀ��Ԫ�ص�����
			int v = x[i];
			// �������ֵ�����Ѿ������óɸ�ֵ�����ԣ�����������¼����Ԫ�صĳ�����������ԣ���������
			if (v < 0)
				v = -v;
			// ֵ��1��ʼ�����ԣ�Ҫ��1����0����
			v--;

			// ���ĳ��λ�õ�ֵ�Ѿ��Ǹ����ˣ������ֵ�ʹ����ˣ������
			if (x[v] < 0)
				result[count++] = v + 1;

			// toggle���λ�ã���������3�ε�Ԫ��ֻ���һ��
			x[v] = -x[v];

			// �����������������д�������빦����ͬ
			/**
			 * 
			 * if (x[v] >= 0) x[v] = -x[v]; else { x[v] = -x[v]; result[count++]
			 * = x[v]; }
			 * 
			 */

		}

		return Arrays.copyOfRange(result, 0, count);
	}
}
