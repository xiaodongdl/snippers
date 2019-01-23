package com.robert.dsal.string.maxpalindrome;

import java.util.Arrays;

/**
 * 
 * ʹ������ָ�룬һ����ʼָ�룬һ����βָ�룬��������ָ��֮���ǲ��ǻ��ġ�
 * 
 * O(n^2), ����ÿ�ζԱ���Ҫ�ӿ�ʼ�ַ�����Աȣ����ԣ����и���ϵ����O(c*n^2), c���ַ���ƽ�����Ƴ���
 *
 */
public class MaxPalindromeBruteForce implements MaxPalindrome {

	public char[] findMaxPalindrome(char[] str) {
		int start = -1;
		int count = 0;

		for (int i = 0; i < str.length - 1; i++) {
			for (int j = i + 1; j < str.length; j++) {
				if (isPalindrome(str, i, j) && j - i + 1 > count) {
					start = i;
					count = j - i + 1;
				}

			}
		}

		if (start != -1)
			return Arrays.copyOfRange(str, start, start + count);

		return null;
	}

	private boolean isPalindrome(char[] str, int i, int j) {
		while (i < j) {
			if (str[i++] != str[j--])
				return false;
		}

		return true;
	}

}
