package com.robert.dsal.math.comb$perm.combination;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

public class CombinationByArray implements Combination {
	public List<String> combination(String s, int count) {
		List<String> results = new LinkedList<String>();

		BitSet bitSet = new BitSet();

		combination(results, s, bitSet, count);

		return results;
	}

	private void combination(List<String> results, String s, BitSet bitSet,
			int count) {
		// ��ʼ��ǰk��Ԫ��
		for (int i = 0; i < s.length(); i++) {
			if (i < count)
				bitSet.set(i, true);
			else
				bitSet.set(i, false);
		}

		getOneCombination(results, s, bitSet);

		while (true) {

			// �ҵ���һ��10��Ȼ��10������ֱ����ǰ��Ԫ��0
			int index = findFirst10(bitSet, s.length());
			if (index == -1)
				break;

			for (int i = index; i >= 0; i--) {
				swap(bitSet, i, i + 1);
				getOneCombination(results, s, bitSet);
			}

			// �ҵ���һ��10����ǰ���1������ǰ�棬��ǰ���0����1���棬���10����
			int index1 = findFirst10(bitSet, s.length());
			if (index1 == -1)
				break;

			int k = -1;
			for (int i = 0; i < index1; i++) {
				if (bitSet.get(i)) {
					swap(bitSet, ++k, i);
				}
			}
			swap(bitSet, index1, index1 + 1);
			getOneCombination(results, s, bitSet);

			// ֱ�����е�1���ܵ������ȥ�ˣ������Ҳ���10��
		}
	}

	private int findFirst10(BitSet bitSet, int count) {
		for (int i = 0; i < count - 1; i++) {
			if (bitSet.get(i) && !bitSet.get(i + 1))
				return i;
		}
		return -1;
	}

	private void swap(BitSet bitSet, int i, int j) {
		boolean b = bitSet.get(i);
		bitSet.set(i, bitSet.get(j));
		bitSet.set(j, b);
	}

	private void getOneCombination(List<String> results, String s, BitSet bitSet) {
		StringBuffer sbResult = new StringBuffer();

		for (int i = 0; i < s.length(); i++) {
			if (bitSet.get(i)) {
				sbResult.append(s.charAt(i));
			}
		}
		results.add(sbResult.toString());
	}

}
