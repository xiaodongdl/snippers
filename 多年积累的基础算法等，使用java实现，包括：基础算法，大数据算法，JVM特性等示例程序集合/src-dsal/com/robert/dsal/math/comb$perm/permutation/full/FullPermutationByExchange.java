package com.robert.dsal.math.comb$perm.permutation.full;

import java.util.LinkedList;
import java.util.List;

/**
 * �ַ�������������ÿ��λ�ã��Ѻ��������ַ�������ǰλ�ã�Ȼ��ݹ�������ַ������������ǵݹ鵽�����һ���ַ�
 * 
 */
public class FullPermutationByExchange implements FullPermutation {

	public List<String> fullPermutation(String s) {
		List<String> listResults = new LinkedList<String>();
		StringBuffer sbResult = new StringBuffer(s);

		fullPermutatin(listResults, sbResult, 0);

		return listResults;
	}

	private void fullPermutatin(List<String> listResults,
			StringBuffer sbResult, int current) {
		if (current == sbResult.length()) {
			listResults.add(sbResult.toString());
			return;
		}

		for (int i = current; i < sbResult.length(); i++) {
			swap(sbResult, current, i);

			fullPermutatin(listResults, sbResult, current + 1);

			swap(sbResult, current, i);
		}
	}

	private void swap(StringBuffer sb, int i1, int i2) {
		char c = sb.charAt(i1);
		sb.setCharAt(i1, sb.charAt(i2));
		sb.setCharAt(i2, c);
	}

}
