package com.robert.dsal.math.comb$perm.combination;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * �ݹ������Ŀ�꼯�ϵ�Ԫ������ÿ��ȷ��һ��Ԫ�� 
 * �ݹ���Ϊ��ÿ��ȷ��һ��Ԫ�أ����Ԫ��ȡ�Ե�ǰ��ʼ�ַ���s.length - count + �ݹ������ÿ��Ԫ������һ�Σ�Ȼ��ݹ���һ�Σ��ݹ���һ���Ǵ��ϴ�ѡ��Ԫ�ؿ�ʼ��s.length - count + �ݹ���������ݣ��´εݹ�Ŀ�ʼ�����ǵ�ǰ�ݹ���ұ߿�ʼ�ģ���˳���ϵ��
 * ���磺abc, ѡ����aֻ����ѡb��c��ѡ����bֻ����ѡc���������bc����Զ������cb�������ϾͲ����ظ�������Ǻ����е�����
 * 
 */
public class CombinationByInsert implements Combination {

	public List<String> combination(String s, int count) {
		List<String> results = new LinkedList<String>();
		StringBuffer result = new StringBuffer();

		combination(results, result, s, count, 0, 0);

		return results;
	}

	private void combination(List<String> results, StringBuffer buffer,
			String s, int count, int current, int start) {
		// ��N��Ԫ��count��Ԫ�ص���ϣ�ÿ�εݹ�ȷ��һ��Ԫ�أ�һ���ݹ�count�Σ����current = count���ǽ�������
		if (current == count) {
			results.add(buffer.toString());
			return;
		}

		// ��ÿ�εݹ鿪ʼԪ������ֱ��s.lengh - count + �ݹ�����ǵ�ǰ��������Χ��һ�γ���֮������֮��͹̶���һ��Ԫ��
		for (int i = start; i <= s.length() - count + current; i++) {
			char c = s.charAt(i);
			buffer.insert(0, c);

			// ����current��count�ļ�����������countΪֹ��Ҳ����Ŀ������ж���Ԫ�ؾ��ж��ٴεݹ�
			// i + 1��ζ���´�ֻȡ��ǰԪ���ұߵ�Ԫ�أ��������ظ������磺abc������ȡ��a��ֻ����ȡb��c��ȡ��b��ֻ��ȡc�����ab��ba�ظ�����Ϊ����������ϵ�
			combination(results, buffer, s, count, current + 1, i + 1);

			buffer.deleteCharAt(0);
		}
	}

}
