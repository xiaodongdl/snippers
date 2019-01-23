package com.robert.dsal.math.comb$perm.permutation.full;

import java.util.LinkedList;
import java.util.List;

/**
 * ���뷨 - �ݹ����������ʣ��һ���ַ������о������Լ���ֻ��һ����Ȼ��ѵڶ����ַ����뵽����ַ������ң����ֽⷨ��ÿ�εݹ鶼�д�������ʱ�ռ䣬���Ƽ�ʹ�ã�
 * �뿴FullPermutationByInsert.java�� ��ʵ�ֲ����Ƽ�
 * 
 * ��һ��˼·�����ַ���a{n}��ȫ���У����Էֽ�Ϊ��a{n - 1}��ȫ���У�����a{n - 1}��ÿһ��ȫ���н����ֻҪ��a[n]���뵽a{n -
 * 1}���е�n��λ����
 * �����ɵõ�a{n}��ȫ���н�������磺��abc��ȫ���У���������ab��ȫ���У��ٽ�c���뵽��0,1,2λ���ɵõ�abc��ȫ���У�������ab��ȫ����
 * ����������a��ȫ����
 * ���ٽ�b���뵽��0,1λ���ɵõ�abȫ���н������Ϊa�ǵ����ַ�������ȫ���н��ֻ��һ����a�����Եݹ鿪ʼ���أ�������ϣ��õ�abc��ȫ���еĽ�
 * ���ܽ᣺���ǻ��ڲ���������㷨��
 * 
 */
public class FullPermutationByInsert1 implements FullPermutation {

	public List<String> fullPermutation(String s) {
		return fullPermutation(s, 0, s.length());
	}

	public List<String> fullPermutation(String s, int start, int end) {
		List<String> results = new LinkedList<String>();

		// �����ʣ��һ���ַ��ˣ���ȫ���о�ֻ��һ����
		if (start == end - 1) {
			results.add(s.substring(start, end).toString());
			return results;
		}

		// ���¿�ʼ�ַ������ں���������ַ���ȫ���У�����ÿ�����е�ÿ��λ�ò��뵱ǰ�ַ���Ϊ�µ�����
		List<String> resultsSub = fullPermutation(s, start + 1, end);

		for (String sSub : resultsSub) {
			StringBuffer sbSub = new StringBuffer(sSub);
			for (int i = 0; i <= sbSub.length(); i++) {
				sbSub.insert(i, s.charAt(start));
				results.add(sbSub.toString());
				sbSub.deleteCharAt(i);
			}
		}

		// ȱ����û��ȥ��

		return results;
	}

}
