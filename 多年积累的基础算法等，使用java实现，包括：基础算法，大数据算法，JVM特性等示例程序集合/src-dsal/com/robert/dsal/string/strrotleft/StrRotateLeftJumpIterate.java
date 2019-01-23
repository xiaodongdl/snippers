package com.robert.dsal.string.strrotleft;

/**
 * 
 * Near to O(n)
 * 
 */
public class StrRotateLeftJumpIterate implements StrRotateLeft {
	public void rotateLeft(char[] source, int size) {
		int gcd = gcd(size, source.length);

		// һ��ѭ�����Լ���Ĵ���
		for (int i = 0; i < gcd; i++) {
			char t = source[i];

			// ÿ����Ҫ�ƶ����ַ�������ô��
			int m = i;
			int n = m + size;

			while (true) {
				if (n >= source.length)
					n -= source.length;
				if (n == i) {
					source[m] = t;
					break;
				}

				source[m] = source[n];
				m = n;
				n = m + size;
			}
		}
	}

	private int gcd(int i, int j) {
		// ���j��i���򽻻�
		if (j > i) {
			i = i + j;
			j = i - j;
			i = i - j;
		}

		// �����Լ��
		int r = i % j;

		while (r != 0) {
			i = j;
			j = r;

			r = i % j;
		}

		return j;
	}
}
