package com.robert.dsal.advance.maxsubsum;

/**
 * 
 * ʱ�临�Ӷ�Ϊ�� n^2
 * 
 * �㷨�������κ�һ��Ԫ�أ�����Դ�Ԫ�ؿ�ʼ���κ������еĺͣ������˫��ѭ��
 * 
 */

public class MaxSubSumImprove implements MaxSubSum {

	public long maxSubSum(int[] seq) {
		long maxSum = 0;

		for (int i = 0; i < seq.length; i++) {
			// ��iԪ�ؿ�ʼ����������������
			long currSum = 0;
			for (int j = i; j < seq.length; j++) {
				currSum += seq[j];

				if (currSum > maxSum)
					maxSum = currSum;
			}
		}

		return maxSum;
	}

}
