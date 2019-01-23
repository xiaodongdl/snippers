package com.robert.dsal.math.comb$perm.combination;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * ����ÿ���ַ�����ǰ�ַ�������ݹ飬�������ٵݹ�, ���������ǵ����һ���ַ����߻����������ڴ�����
 * 
 * ���ڼ����е�ÿ���ַ�ֻ��2����������ڻ��߲����ڣ��ݹ����Ϊ�ַ�������
 * 
 * �㷨���Ӷ�Ϊָ������O(2^n)��Ч�ʺܲ�
 * 
 */
public class CombinationBruteForce implements Combination {
	public List<String> combination(String s, int count) {
		List<String> results = new LinkedList<String>();
		StringBuffer result = new StringBuffer();

		combination(results, result, s, 0, count);

		return results;
	}

	private void combination(List<String> results, StringBuffer result,
			String s, int current, int count) {
		if (result.length() == count) {
			results.add(result.toString());
			return;
		}

		if (current == s.length())
			return;

		char c = s.charAt(current);

		// ��ǰ�ַ�����
		result.insert(0, c);
		combination(results, result, s, current + 1, count);

		// ��ǰ�ַ�������
		result.deleteCharAt(0);
		combination(results, result, s, current + 1, count);
	}
}
