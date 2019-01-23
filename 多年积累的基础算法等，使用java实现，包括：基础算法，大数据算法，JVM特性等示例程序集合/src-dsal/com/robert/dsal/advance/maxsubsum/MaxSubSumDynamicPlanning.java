package com.robert.dsal.advance.maxsubsum;

/**
 * 
 * ��˵�еĶ�̬�滮�����Ӷ���O(n)
 * 
 * ����һ������
 * 
 * �ٱ���һ����ǰԪ��֮ǰ�����ͣ�����������Ǹ��������ʹ����ĺͼ��٣��������������Ϊ0����Ҳ���Ƕ�̬�滮����˼
 * 
 */
public class MaxSubSumDynamicPlanning implements MaxSubSum {
	public long maxSubSum(int[] seq) {
		// ���ֵ�ǰ�����������
		long maxSum = seq[0];

		// ���ֵ���ǰԪ��Ϊֹ������
		long currSum = seq[0];

		for (int i = 1; i < seq.length; i++) {
			// �����ǰ�����Ǹ�������ֻ�ܸ�����ĺͼ�ȥֵ���������������ǰ�������Ҳ�������������ģ������Ѿ�������maxSum�ˣ������أ�Ҳû��ʧ
			// ������滹�и���ģ��������masXum
			if (currSum < 0)
				currSum = 0;

			currSum += seq[i];

			if (currSum > maxSum)
				maxSum = currSum;
		}

		return maxSum;
	}
}
