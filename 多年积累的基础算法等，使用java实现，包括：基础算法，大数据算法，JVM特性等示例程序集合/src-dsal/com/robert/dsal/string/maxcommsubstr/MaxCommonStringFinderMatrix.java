package com.robert.dsal.string.maxcommsubstr;

// Still can't understand

//TODO Move to string.maxcommonsubstr

//TODO ����һ�ֶ�̬�滮�ķ�������󹫹�������

/**
 * 
 * �������ַ���������ִ���
 * �㷨�������ַ����γ�һ�����󣬽������ַ���ƥ���λ�ñ��Ϊ0��c[i][j]�������ַ���ƥ���λ�ñ��Ϊn,����n=c[i-1][j-1]+1,
 * ���������Խ��߷����������Ϊ�����ִ��������������
 * 
 * ���ɶ�ά����
 * 
 * 0 0 0 1 0 0 0 1 1 0 0 1 0 0 �� 0 1 0 0 0 0 0 0 0 2 1 0 0 0 �� ��1 0 2 0 1 0 1 0
 * 0 0 0 0 1 0 �� ��0 2 0 0 0 0 0 0 0 1 1 0 0 0 �� ��1 0 3 0 1 0 1 0 0 0 0 0 1 0 ��
 * ��0 0 0 4 0 0 0 2 1 0 0 1 0 0 ���� 1 0 1 0 5 0 1 0 0 0 0 0 2 0 �� ��1 0 1 0 1 0 1
 * 0 0 0 0 0 1 0 �� ��0 0 0 2 0 0 0 2 1 0 0 1 0 0 �� ��0 0 0 0 0 0 0 0 0 0 0 0 0 1
 * ���� 0 0 0 0 0 0 0 0 0 0 0 0 0 1 �� ��0 0 0 0 0 1 0 0 0 0 0 0 0 0
 */
public class MaxCommonStringFinderMatrix implements MaxCommonStringFinder {
	public String findMaxCommonString(String s1, String s2) {
		return findMaxCommonString(s1.toCharArray(), s2.toCharArray());
	}

	public String findMaxCommonString(char[] c1, char[] c2) {
		// TODO to be classified

		int[][] c = new int[c1.length][c2.length];
		int start = 0; // ��¼�����Ӵ�����ʼλ��
		int end = 0;// ��¼�����Ӵ��Ľ���λ��
		int maxLength = 0;// ��¼������Ӵ��ĳ���

		for (int i = 0; i < c1.length; i++) {
			for (int j = 0; j < c2.length; j++) {
				if (c1[i] == c2[j]) {
					if (i == 0 || j == 0) {
						c[i][j] = 1;
					} else {
						c[i][j] = c[i - 1][j - 1] + 1;
					}
				} else {
					c[i][j] = 0;
				}

				if (c[i][j] > maxLength) {
					maxLength = c[i][j];
					end = j;
				}
			}
		}
		start = end - maxLength + 1;

		char[] p = new char[maxLength];

		for (int k = start; k <= end; k++) {
			p[k - start] = c2[k];
		}

		return String.valueOf(p);
	}

}
