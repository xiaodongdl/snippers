package com.robert.dsal.math.comb$perm.permutation.full;

import java.util.LinkedList;
import java.util.List;

/**
 * ���ַ���ÿ�εݹ鶼����n-1�����У��ݹ����������Ȼ��ʣ��һ���ַ������о������Լ���
 * Ȼ��ѵ�ǰ�ַ�������n-1�����е�ǰ�棬��Ҫ̫��Ŀռ䣬���Ƽ�ʹ�ã��뿴FullPermutationByExchange.java�� ��ʵ�ֲ����Ƽ�
 * 
 * 
 * 
 * �ڶ���˼·�����ַ���a{n}��ȫ���У����Ƚ�a[0]��a[n]������Ȼ����ǰ�泤��Ϊn -
 * 1���ַ�����ȫ���У���ɺ󣬽�a{n}���лָ�ԭ�����ٽ�a[1]��a[n]�������Դ����ƣ�ֱ��a[n]��a[n]������ȥ��ǰ�泤��Ϊn -
 * 1���ַ�����ȫ����
 * ���������еĽ�����ѵõ������磺��abc��ȫ���У������Ƚ�a��c�������̶�a����cba����ʱ��cb��ȫ���У���c��b�������̶�c����bca
 * ������b��һ���������ַ���
 * ���˴εݹ鵽�ײ㣬���һ�����bca�����أ��ع�ԭ��Ϊcba����ʱ��һ����Ҫ�����ֵ��b����b��b��������a[i]��a[n]������
 * ����ʱiǡ�õ���n�����õ�cba
 * ������c�ǵ������ַ������ݹ鵽�ײ㣬���һ�����cba�����أ��ع�ԭ��Ϊcba����Ϊi�Ѿ�����n����������أ��ع�ԭ��abc
 * ����ʱa�Ѿ�������ϣ��ٽ�b������ĩβ�̶�
 * �����д����Դ����ƣ��õ�����ȫ���н�������˼·��һ���ô��������������Ŀռ���ۼ��ɴﵽȥ�ش����Ҫ�󣬶����ظ����ַ�
 * ������ֻҪ��������ַ�������iλ�ù̶���
 * ���Ͳ��ٽ��д��ִ�����Ϊ���������ַ�m����iλ�ù̶��������֪m��iλ�õ�ǰ���������ַ�����ȫ���н���Ѿ��õ�����ô��ͬ���ַ���һ�ι̶�����ͬ��λ��
 * �������ȫ���б�Ȼ���½���ظ����ܽ᣺���ǻ��ڵ����������㷨��
 * 
 */
public class FullPermutationByExchange1 implements FullPermutation {

	public List<String> fullPermutation(String s) {
		// ����ҿ�
		return fullPermutation(new StringBuffer(s), 0, s.length());
	}

	public List<String> fullPermutation(StringBuffer sb, int start, int end) {
		List<String> results = new LinkedList<String>();

		if (start + 1 == end) {
			results.add(sb.substring(start, end));
			return results;
		}

		for (int i = start; i < end; i++) {
			swap(sb, start, i);

			List<String> resultsSub = fullPermutation(sb, start + 1, end);

			for (String sSub : resultsSub) {
				results.add(sb.charAt(start) + sSub);
			}

			swap(sb, start, i);
		}

		return results;
	}

	private void swap(StringBuffer sb, int i1, int i2) {
		char c = sb.charAt(i1);
		sb.setCharAt(i1, sb.charAt(i2));
		sb.setCharAt(i2, c);
	}

}
