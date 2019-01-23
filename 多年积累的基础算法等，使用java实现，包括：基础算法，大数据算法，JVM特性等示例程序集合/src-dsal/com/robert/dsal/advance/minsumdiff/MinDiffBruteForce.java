package com.robert.dsal.advance.minsumdiff;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 *  ��������ָ������ֳ�2�飬����������⣬����ó����������ϵ���С��ֵ�����Ƿ��ֵ�num > 10�Ժ󣬲�ֵ��010101��ѭ����
 *  ����ϸ�㣬���ܹ����ֳ���10��������������������ż�����ܾ��֣�����������������������С���1��
 *  
 *  2->7   4->30   6->9   8->4   10->19   12->0   14->1   16->0   18->1   20->0   22->1   24->0   26->1
 *
 * 
 */
public class MinDiffBruteForce implements MinDiff {
	public Result minDiff(int start, int end, int power) {
		// ��ʼ��
		int[] x = new int[end - start + 1];

		for (int i = 0; i < x.length; i++) {
			x[i] = (int) Math.pow(start + i, power);
		}

		// ���
		long sum = sum(x);

		List<Integer> c1 = new ArrayList<Integer>();
		List<Integer> c2 = new ArrayList<Integer>();

		// �ݹ����
		Result result = new Result();
		minDiff(x, c1, c2, 0, 0, result, 0, (int) sum / 2);

		return result;

	}

	private void minDiff(int[] x, List<Integer> c1, List<Integer> c2, int s1,
			int s2, Result result, int pos, int avg) {

		// �ݹ�����У����ĳ������֮���Ѿ�����ƽ��������ô��ֵ����2������������֮���������Ѿ�����ĺ�֮����Сֵ����������ǰ·��������
		if (s1 > avg && (s1 - avg) * 2 > result.diff)
			return;
		if (s2 > avg && (s2 - avg) * 2 > result.diff)
			return;

		// �������Ԫ���ѷ���
		if (c1.size() + c2.size() == x.length) {
			// �������ƽ�֣����˳�
			if (c1.size() != c2.size())
				return;

			// ���ֵ
			int diff = Math.abs(s1 - s2);

			// �����ֵ�����н⻹С���򱣴浱ǰ���Ž�
			if (diff < result.diff) {

				result.diff = diff;
				result.c1 = new ArrayList<Integer>(c1);
				result.c2 = new ArrayList<Integer>(c2);
			}

			return;
		}

		// ��ǰԪ�ط��ڵ�һ���ϵݹ�
		c1.add(x[pos]);
		minDiff(x, c1, c2, s1 + x[pos], s2, result, pos + 1, avg);
		c1.remove((Integer) x[pos]);

		// ��ǰԪ�ط��ڵڶ����ϵݹ�
		c2.add(x[pos]);
		minDiff(x, c1, c2, s1, s2 + x[pos], result, pos + 1, avg);
		c2.remove((Integer) x[pos]);

	}

	private long sum(int[] x) {
		int sum = 0;

		for (int i = 0; i < x.length; i++) {
			sum += x[i];
		}

		return sum;
	}
}
