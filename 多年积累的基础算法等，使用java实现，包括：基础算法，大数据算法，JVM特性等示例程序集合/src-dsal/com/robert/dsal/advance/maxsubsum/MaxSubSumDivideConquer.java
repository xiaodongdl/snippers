package com.robert.dsal.advance.maxsubsum;

/**
 * 
 * ��һ�α���n���ֳ�2�ݣ� �ڶ��α���n���ֳ�4�ݣ� �����α���n���ֳ�8�ݣ� ���Ĵα���n�� �ֳ�16�ݣ� ����α���n���ֳ�32�ݣ�
 * 
 * ��x�α���n���ֳ�2^x��
 * 
 * һ������x�Σ�x = log2n�� ÿ�α���n��Ԫ�أ����ʱ�临�Ӷ���O(nlog2n)
 * 
 */

public class MaxSubSumDivideConquer implements MaxSubSum {
	public long maxSubSum(int[] seq) {
		return maxSubSum(seq, 0, seq.length);
	}

	private long maxSubSum(int[] seq, int start, int end) {
		// ����������ҿ���ʣ��һ��Ԫ��ʱ�����ٵݹ�
		if (start + 1 == end)
			return seq[start];

		// ����м�Ԫ�أ� ����ҿ�
		int mid = (start + end) / 2;

		// �ֱ�ݹ������������ұ����ĺ�
		long maxLeft = maxSubSum(seq, start, mid);
		long maxRight = maxSubSum(seq, mid, end);

		// �������м�Ԫ�ص����ͣ���ô����м�Ԫ�ص����;���������м�Ԫ�ؿ�ʼ�������ƽ������ͣ�
		// ���ұ����м�Ԫ�ؿ�ʼ�������ƽ������ͣ���������һ��
		long maxLeftPart = maxLeftPart(seq, start, mid);
		long maxRightPart = maxRightPart(seq, mid, end);

		// ���������ͣ��ұ����ͣ��Ϳ���м�Ԫ�ص����ͣ��������Ǹ�
		return max(maxLeft, maxRight, maxLeftPart + maxRightPart);
	}

	private long maxLeftPart(int[] seq, int start, int mid) {
		long maxSum = 0;
		long currSum = 0;

		for (int i = mid - 1; i >= 0; i--) {
			currSum += seq[i];

			if (currSum > maxSum)
				maxSum = currSum;
		}

		return maxSum;
	}

	private long maxRightPart(int[] seq, int mid, int end) {
		long maxSum = 0;
		long currSum = 0;

		for (int i = mid; i < end; i++) {
			currSum += seq[i];

			if (currSum > maxSum)
				maxSum = currSum;
		}

		return maxSum;
	}

	private long max(long m1, long m2, long m3) {
		long max = m1;

		if (m2 > max)
			max = m2;

		if (m3 > max)
			max = m3;

		return max;
	}
}
