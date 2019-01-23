package com.robert.dsal.string.substrmatch;

import java.util.Arrays;

/**
 * 
 * O(n * m)
 *
 */
public class SubstrMatcherBruteForce implements SubstrMatcher {
	public int[] indexesOf(char[] source, char[] target) {
		int[] indexes = new int[source.length];
		int count = 0;

		int i = -1, j = -1;
		int s = -1;

		while (i < source.length - 1) {
			if (source[++i] == target[++j]) {
				// ��������ַ���ȣ�������ƽ�
				if (j == 0)
					// ����ǵ�һ���ַ���ȣ��򱣴濪ʼλ��
					s = i;
				else if (j == target.length - 1) {
					// ���Ŀ�괮�����һ���ַ���ȣ���s�������е�һ��ƥ��
					indexes[count++] = s;

					// ��������ʣ���ַ�������source���ϴ�ƥ�俪ʼ��ǰ�ƽ�һ���ַ������ڳ�ʼ������-1������ֱ��ȡs��Ҳ���ǶԱ���һ���ַ���targetӦ�û��ݵ���һ���ַ�֮ǰ-1
					i = s;
					j = -1;
				}
			} else {
				// ��������ַ����ȣ���sourceӦ���ƽ�һ���ַ���Ҳ���ǶԱ���һ���ַ���targetӦ�û��ݵ���һ���ַ�
				i -= j;
				j = -1;
			}
		}

		return Arrays.copyOf(indexes, count);
	}

	public int indexOf(char[] source, char[] target) {
		int i = -1, j = -1;
		int s = -1;

		while (i < source.length - 1) {
			if (source[++i] == target[++j]) {
				// ��������ַ���ȣ�������ƽ�
				if (j == 0)
					// ����ǵ�һ���ַ���ȣ��򱣴濪ʼλ��
					s = i;
				else if (j == target.length - 1) {
					// ���Ŀ�괮�����һ���ַ���ȣ��򷵻ؿ�ʼλ��
					return s;
				}
			} else {
				// ��������ַ����ȣ���sourceӦ�öԱ��ϴο�ʼ���ƽ�һ���ַ���Ҳ������һ���ַ���targetӦ�û��ݵ���һ���ַ�
				i -= j;
				j = -1;
			}
		}

		return s;
	}
}
