package com.robert.dsal.string.maxpalindrome;

import java.util.Arrays;

/**
 * 
 * 1. ������ת����ԭ�����洮����󹫹��ִ��� 
 * 2. ��ԭ�����洮�ϲ���һ������Ȼ�������׺���飬Ȼ������ 
 * 3. �������������׺�ִ�����󹫹��ִ�������������Ҫ�ֱ���ԭ�����洮�С�
 * 
 * ���������Ҫ��ʱ���û���׺��������򣬺�׺����������ҪO(nlog2n), ��������ÿ�ζԱȣ���Ҫ��������ʼλ������Աȣ�������less()�����ԣ�ȡ���ڴ������Ƴ̶ȣ�ͨ�����и���ϵ��O(c*nlog2n), c���ַ���ƽ�����Ƴ̶�
 * 
 */
public class MaxPalindromeSuffixArray implements MaxPalindrome {

	public char[] findMaxPalindrome(char[] str) {
		// �������洮�ϲ���һ�������Ĵ�
		char[] total = new char[str.length * 2];
		for (int i = 0; i < str.length; i++) {
			total[i] = str[i];
			total[total.length - 1 - i] = str[i];
		}

		// ��ʼ����׺����
		int[] suffix = new int[total.length];
		for (int i = 0; i < suffix.length; i++) {
			suffix[i] = i;
		}

		// �����׺����
		sort(total, suffix);

		// �ҳ���׺��������������Ԫ���ַ���ͬ����Ǹ��ִ�
		return maxCommon(total, suffix);
	}

	private void sort(char[] total, int[] suffix) {
		qsort(total, suffix, 0, total.length - 1);
	}

	private void qsort(char[] total, int[] suffix, int i, int j) {
		if (i >= j)
			return;

		int m = partition(total, suffix, i, j);

		qsort(total, suffix, i, m - 1);
		qsort(total, suffix, m + 1, j);
	}

	private int partition(char[] total, int[] suffix, int i, int j) {
		int m = i;

		// ���ѭ�������̶���û�л��ݣ����޿���ʹ��forѭ��������л��ݣ�������while
		for (int k = i + 1; k <= j; k++) {
			int ii = suffix[i];
			int ik = suffix[k];

			if (less(total, ik, ii))
				swap(suffix, ++m, k);
		}

		swap(suffix, i, m);

		return m;
	}

	private boolean less(char[] total, int i, int j) {
		while (i < total.length && j < total.length) {
			// ���ĳ���ַ�С����һ����С�ڣ����ĳ���ַ���һ���Ǵ���
			// ���ĳ���ַ���ȣ�����һ���ַ�
			if (total[i] < total[j])
				return true;
			else if (total[i] > total[j])
				return false;

			// �����κ�һ��whileѭ�������������ݼ�����������������ѭ��
			i++;
			j++;
		}

		return false;
	}

	private void swap(int[] suffix, int i, int j) {
		int t = suffix[i];
		suffix[i] = suffix[j];
		suffix[j] = t;
	}

	private char[] maxCommon(char[] total, int[] suffix) {
		int maxline = -1;
		int maxcount = 0;

		for (int i = 0; i < suffix.length - 1; i++) {
			int prev = suffix[i];
			int next = suffix[i + 1];

			// ȷ��һ��������ԭ����һ���������洮
			if (prev < suffix.length / 2 && next < suffix.length / 2)
				continue;
			if (prev >= suffix.length / 2 && next >= suffix.length / 2)
				continue;

			int count = count(total, prev, next);
			if (count > maxcount) {
				maxline = prev;
				maxcount = count;
			}

		}

		if (maxline != -1)
			return Arrays.copyOfRange(total, maxline, maxline + maxcount);

		return null;
	}

	private int count(char[] total, int prev, int next) {
		int count = 0;

		while (prev < total.length && next < total.length)
			// ע��ѭ�����������͵ݼ���������ѭ��
			if (total[prev++] == total[next++])
				count++;

		return count;
	}

}
