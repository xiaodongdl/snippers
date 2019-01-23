package com.robert.dsal.math.comb$perm.permutation.full;

import java.util.LinkedList;
import java.util.List;

/**
 * ���뷨
 * 
 * 1. ѭ��0-n-1, ��ǰ�ַ����뻺����
 * 2. �����������k���ַ�����ô��Ҫ���Բ���k+1��λ�ã�Ȼ������ݹ�ʣ�µ��ַ���ֱ�����һ���ַ�n-1�����ˣ���ӡ���еĻ���������
 * 3. ���ǵݹ��ѭ�������������ǵݹ鵽�����һ���ַ�
 * 
 * 
 */
public class FullPermutationByInsert implements FullPermutation {

	public List<String> fullPermutation(String s) {
		List<String> listResults = new LinkedList<String>();
		StringBuffer sbResult = new StringBuffer();

		fullPermutation(listResults, sbResult, s, 0);

		return listResults;

	}

	private void fullPermutation(List<String> listResults,
			StringBuffer sbResult, String s, int current) {
		if (current == s.length()) {
			listResults.add(sbResult.toString());
			return;
		}

		char c = s.charAt(current);
		for (int i = 0; i <= current; i++) {
			sbResult.insert(i, c);

			fullPermutation(listResults, sbResult, s, current + 1);

			sbResult.deleteCharAt(i);
		}

	}

}
