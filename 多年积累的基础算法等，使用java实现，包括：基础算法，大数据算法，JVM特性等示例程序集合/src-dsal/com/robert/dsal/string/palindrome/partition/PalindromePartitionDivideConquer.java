package com.robert.dsal.string.palindrome.partition;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ÿ�δ�����ɨ�裬����ҵ�һ��������ʼλ�õĻ��ģ���ݹ���ʣ��Ԫ�صĻ��ķ�����Ȼ��ѵ�ǰ���������������С����Ƿ��Ρ�
 * 
 */
public class PalindromePartitionDivideConquer implements PalindromePartition {

	public char[][][] partition(char[] s) {
		// ��0��ʼ
		return partition(s, 0);
	}

	private char[][][] partition(char[] s, int start) {
		// ��ʼ�����������һά���ǽ�������ĸ������ڶ�ά����ÿ��������������ķ��������ڶ���ά����ÿ���������ַ���
		char[][][] currResult = new char[0][][];

		// ����������ұ�һ��Ԫ�أ���ݹ鷵�أ���ǰ��������һ��Ԫ��
		if (start == s.length - 1) {
			currResult = new char[1][1][1];
			currResult[0][0][0] = s[start];

			return currResult;
		}

		// �ӿ�ʼԪ�������ҵ�һ������
		int i = start;
		while (i < s.length) {
			if (isPalindrome(s, start, i)) {
				// �ҵ����ĺ�����ݹ�
				char[][][] nextResult = partition(s, i + 1);

				// �ϲ���ǰ�����ͺ���ķ���
				currResult = mergeResult(currResult, s, start, i, nextResult);
			}

			i++;
		}

		return currResult;
	}

	private char[][][] mergeResult(char[][][] currResult, char[] s, int start,
			int i, char[][][] nextResult) {
		char[][][] result = new char[currResult.length + nextResult.length][][];

		// �ȿ������еĽ������
		int j;
		for (j = 0; j < currResult.length; j++) {
			result[j] = currResult[j];
		}

		// �ϲ�����ݹ�Ľ������
		for (int k = 0; k < nextResult.length; k++) {
			// ����ÿһ���������
			char[][] partion = new char[nextResult[k].length + 1][];

			// ��һ���������ǵ�ǰ����
			partion[0] = new char[i - start + 1];
			for (int l = start; l <= i; l++) {
				partion[0][l - start] = s[l];
			}

			// ��������ķ���
			for (int l = 0; l < nextResult[k].length; l++) {
				partion[l + 1] = nextResult[k][l];
			}
			result[j++] = partion;
		}

		return result;
	}

	private boolean isPalindrome(char[] s, int i, int j) {
		while (i < j && s[i++] != s[j--])
			return false;

		return true;
	}

	public List<List<String>> partition(String s) {
		return partition(s, 0);
	}

	private List<List<String>> partition(String s, int start) {
		List<List<String>> currResult = new ArrayList<List<String>>();

		if (start == s.length() - 1) {
			List<String> parts = new ArrayList<String>();
			parts.add(s.substring(s.length() - 1));

			currResult.add(parts);

			return currResult;
		}

		int i = start;

		while (i < s.length()) {
			if (isPalindrome(s.substring(start, i + 1))) {
				List<List<String>> nextResult = partition(s, i + 1);
				for (int j = 0; j < nextResult.size(); j++) {
					List<String> solution = nextResult.get(j);
					solution.add(0, s.substring(start, i + 1));
				}
				currResult.addAll(nextResult);
			}

			i++;
		}

		return currResult;
	}

	private boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;

		while (i < j && s.charAt(i++) != s.charAt(j--))
			return false;

		return true;
	}

}
