package com.robert.dsal.string.substrmatch;

import java.util.Arrays;

/**
 * 
 * abcdefg abcdefh
 * 
 * ����Ϊ6���ַ����ȣ�����Ϊ0��5���ַ�����ȣ����ԣ��ڶ�������0�����ϵ��ַ��͵ڶ�������1-5�����ϵ��ַ����ȣ�����1-5�����ϵ��ַ�����ȣ�
 * ���ԣ��ڶ�����������0����Ҫ�͵�һ����1-5�����Աȣ�һ������ȣ�ֱ�Ӻ͵������Ա�
 * 
 * when i == 6, j == 6 a[i] != b[j] 
 * i���� j���ݵ�0
 * 
 * ����KMP��˼�롣
 * 
 * 
 * ��ͨ�����������ݵ����ǰ��׺
 * 
 * abcabcg abcabch
 * 
 * when i == 6, j == 6 a[i] != b[j] 
 * i���� j���ݵ�backtrace[j], j = backtrace[j];
 * 
 * backtrace������ʵ���ǵ�ǰ�ַ�ǰ��������ȵ�ǰ��׺
 * 
 * abcabch, hλ��ǰ��׺��abc = abc�����hλȡֵΪ3
 * aaaaah, hǰ��5��a����ôhȡֵ4��ǰ��׺Ҫ���ٱ������ִ���һ���ַ���Ҳ����aaa = aaa
 * 
 * ʱ�临�Ӷ���ԭ����Ŀ�괮���ƽϸߵ�������ܹ��ӽ�������
 * 
 * 
 */

public class SubstrMatcherKMP implements SubstrMatcher {
	public int[] indexesOf(char[] source, char[] target) {
		int[] indexes = new int[source.length];
		int count = 0;

		int[] backtrace = getBacktrace(target);

		int i = 0, j = 0;

		while (i < source.length) {
			if (source[i] == target[j]) {
				if (j == target.length - 1) {
					// ���һ����
					indexes[count++] = i - j;

					// ����
					i++;
					j = backtrace[j];
					continue;
				}

				// �����ַ���ȣ���ǰ�ƽ�
				i++;
				j++;
			} else if (j == 0) {
				// �����һ���ַ����ȣ���source����ǰ�ƽ�1���ַ�
				i++;
			} else {
				// ����ӵڶ����ַ���ʼĳ���ַ����ȣ���Ŀ�괮����
				j = backtrace[j];
			}
		}

		return Arrays.copyOf(indexes, count);
	}

	public int indexOf(char[] source, char[] target) {
		int[] backtrace = getBacktrace(target);

		int i = 0, j = 0;

		while (i < source.length && j < target.length) {
			if (source[i] == target[j]) {
				// �����ַ���ȣ���ǰ�ƽ�
				i++;
				j++;
			} else if (j == 0) {
				// �����һ���ַ����ȣ���source����ǰ�ƽ�1���ַ�
				i++;
			} else {
				// ����ӵڶ����ַ���ʼĳ���ַ����ȣ���Ŀ�괮����
				j = backtrace[j];
			}
		}

		if (j == target.length)
			return i - target.length;

		return -1;
	}

	/**
	 * 
	 * ȡ�û��ݵ���������
	 * 
	 *  ababcdef 
	 * -10012000
	 * 
	 * 1. ��һ���ַ��Ļ���������-1�����û���õ�
	 * 2. ��������һ���ַ�������ǰ��������ַ�������ǰ׺�������ĺ�׺����ôǰ��׺�ĳ��Ⱦ��ǵ�ǰ�ַ��Ļ���������ǰ׺������С�������ִ��ĳ��� 
	 * 2.1 index = 1, ǰ��a��û��ǰ��׺��������0 
	 * 2.2 index = 2, ǰ��ab��û��Ǯ��׺��������0 
	 * 2.3 index = 3, ǰ��aba��ǰ׺a���ں�׺a��������1
	 * 
	 * 3. aaaab�е�b��Ӧ��ȡֵ3����Ϊǰ���ַ�aaaa��ǰ��׺��Ϊ3�� 4 -1 = 3, ǰ��׺��������������������һ���ַ�
	 * 
	 */
	private int[] getBacktrace(char[] chars) {
		int[] backtrace = new int[chars.length];

		// ��һ���ַ��Ļ���ֵΪ-1
		backtrace[0] = -1;
		// ��ʼ����ʱ��iָ��0����ǰ�����������-1, jָ���һ������0
		int i = -1, j = 0;

		while (j < chars.length - 1) {
			// ��i = -1��ʱ���ǳ�ʼ�����߻��ݵ���ʼ����ʱ�򣬻���i��j�����ַ���ȵ�ʱ����ǰ�ƽ����Ұ�i���������Ƹ�j���ڵĻ�������
			if (i == -1 || chars[i] == chars[j]) {
				i++;
				j++;
				backtrace[j] = i;
			} else {
				// ���i��j���ڵ��ַ����ȣ���ôi��Ҫ���ݵ�֮ǰû��ǰ׺��ʱ��
				i = backtrace[i];
			}
		}

		return backtrace;
	}

}
