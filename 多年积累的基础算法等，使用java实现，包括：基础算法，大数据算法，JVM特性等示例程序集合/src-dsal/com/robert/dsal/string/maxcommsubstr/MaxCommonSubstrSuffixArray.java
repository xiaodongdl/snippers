package com.robert.dsal.string.maxcommsubstr;

import java.util.Arrays;

/**
 * 
 * O(nlog2n)�� ��Ҫ�������򣬿��ǵ��Ա�������׺����ָ����ִ���O(c*nlog2n), c�ǶԱ�ʱ���whileѭ����ȡ�����ַ����ƶ�
 * 
 */
public class MaxCommonSubstrSuffixArray implements MaxCommonSubstr {
	public char[] maxCommonSubstr(char[] s1, char[] s2) {
		// �ϲ�����
		char[] source = new char[s1.length + s2.length];
		for (int i = 0; i < s1.length; i++) {
			source[i] = s1[i];
		}
		for (int j = 0; j < s2.length; j++) {
			source[s1.length + j] = s2[j];
		}

		// ��ʼ����׺����
		int[] suffixes = new int[source.length];
		for (int i = 0; i < suffixes.length; i++) {
			suffixes[i] = i;
		}

		// �����׺����

		sort(source, suffixes);

		// ������������������ַ����Ĺ����ִ�
		int maxstart = -1;
		int maxlength = 0;

		for (int i = 0; i < suffixes.length - 1; i++) {
			int prev = suffixes[i];
			int next = suffixes[i + 1];

			if (prev < s1.length && next < s1.length)
				continue;

			if (prev >= s1.length && next <= s1.length)
				continue;

			// �����������ַ���ͳ����ͬ�ַ�����
			int length = 0;
			while (prev < suffixes.length && next < suffixes.length
					&& source[prev++] == source[next++])
				length++;

			if (length > maxlength) {
				maxlength = length;
				maxstart = suffixes[i];
			}
		}

		if (maxstart != -1)
			return Arrays.copyOfRange(source, maxstart, maxstart + maxlength);

		return null;
	}

	private void sort(final char[] source, final int[] suffixes) {
		quicksort(source, suffixes, 0, suffixes.length);
	}

	private void quicksort(char[] source, int[] suffixes, int i, int j) {
		if (i >= j)
			return;

		int m = partition(source, suffixes, i, j);

		quicksort(source, suffixes, i, m);
		quicksort(source, suffixes, m + 1, j);
	}

	private int partition(char[] source, int[] suffixes, int i, int j) {
		int m = i;
		int f = i + 1;

		while (f < j) {
			if (less(source, suffixes, f, i)) {
				swap(suffixes, f, ++m);
			}
			f++;
		}

		swap(suffixes, i, m);

		return m;
	}

	private void swap(int[] suffixes, int i, int j) {
		int tmp = suffixes[i];
		suffixes[i] = suffixes[j];
		suffixes[j] = tmp;
	}

	private boolean less(char[] source, int[] suffixes, int i, int j) {
		int fi = suffixes[i];
		int mi = suffixes[j];

		while (fi < source.length && mi < source.length) {
			if (source[fi] < source[mi])
				return true;
			else if (source[fi] > source[mi])
				return false;
			fi++;
			mi++;
		}

		return true;
	}

}
