package com.robert.dsal.math.comb$perm.permutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * �ݹ������ Ŀ������Ԫ�صĸ���
 * ÿ�ι�������������Ԫ�����ó�����һ��Ԫ�أ���������һ��λ���ϣ��´εݹ��������ʣ�µ�Ԫ�أ�������һ��λ���ϣ���˿��ܲ���ab,
 * �����´β���ba�����������
 * 
 */
public class PermutationByInsert implements Permutation {
	public List<String> permutation(String s, int count) {
		List<String> results = new LinkedList<String>();

		StringBuffer result = new StringBuffer(count);

		permutation(results, result, new StringBuffer(s), count, 0);

		return results;
	}

	private void permutation(List<String> results, StringBuffer buffer,
			StringBuffer currentBuffer, int count, int current) {
		if (current == count) {
			results.add(buffer.toString());
			return;
		}

		for (int i = 0; i < currentBuffer.length(); i++) {
			char c = currentBuffer.charAt(i);

			// ÿ�δ������ַ����ó���һ���ŵ�Ŀ��ĵ�ǰλ���ϣ���ô��һ�εݹ����ȡʣ�µķ�����һ��λ�ã���ô��˳���������õ�
			// ���磬abc����һ��ȡ��a��Ȼ��ȡb����ab�� �´�ȡ��b��Ȼ�󻹿��Ի���ȡa������ba�����������
			// �����ϵ��󷨲�һ������ϵ�����ÿ��ֻ��ȡ�ұߵ�Ԫ�أ���˾�����ϣ�ɸѡ�����ظ�Ԫ�أ���CombinationByRecursive.java
			currentBuffer.deleteCharAt(i);
			buffer.insert(current, c);

			permutation(results, buffer, currentBuffer, count, current + 1);

			buffer.deleteCharAt(current);
			currentBuffer.insert(i, c);
		}

	}

	public List<int[]> permutation(int[] nums, int count) {
		List<int[]> results = new ArrayList<int[]>();
		int[] buffer = new int[count];
		
		boolean[] mask = new boolean[nums.length];
		for (int i = 0; i < mask.length; i++) {
			mask[i] = true;
		}

		permutation(results, buffer, nums, mask, count, 0);

		return results;
	}

	private void permutation(List<int[]> results, int[] buffer, int[] nums,
			boolean[] mask, int count, int current) {
		if (current == count) {
			results.add(buffer.clone());
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!mask[i])
				continue;

			buffer[current] = nums[i];
			mask[i] = false;
			
			permutation(results, buffer, nums, mask, count, current + 1);
			mask[i] = true;
		}
	}

}
