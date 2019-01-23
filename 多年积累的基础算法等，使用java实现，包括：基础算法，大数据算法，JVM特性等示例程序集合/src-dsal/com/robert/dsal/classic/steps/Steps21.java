package com.robert.dsal.classic.steps;

/**
 * 
 * һ������n����һЩ����õ�1����ô�����Ĳ�������n�Ĳ�����
 * 
 * n��ż����
 * 
 * n = n / 2;
 * 
 * n��������
 * 
 * n = 3*n + 1;
 * 
 * ������μ����������������������ж�����������֡�
 * 
 */

public class Steps21 {
	public static void main(String[] args) {
		// ���첽������
		int[] buffer = new int[2000000];

		buffer[1] = 0;
		for (int i = 2; i < buffer.length; i++) {
			if (buffer[i] == 0)
				buffer[i] = fill(buffer, i);
		}

		for (int i = 0; i < buffer.length; i++) {
			System.out.println(i + ":" + buffer[i]);
		}
	}

	private static int fill(int[] buffer, int i) {
		if (i == 1)
			return 0;

		if (i % 2 == 0)
			return fill(buffer, i / 2) + 1;

		if (i % 2 != 0)
			return fill(buffer, i * 3 + 1) + 1;

		return 0;
	}
}
