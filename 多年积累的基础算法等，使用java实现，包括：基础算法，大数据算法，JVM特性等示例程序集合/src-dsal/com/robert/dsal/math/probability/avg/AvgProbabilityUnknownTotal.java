package com.robert.dsal.math.probability.avg;

import java.util.Random;

/**
 * 
 * ��δ֪��������ʱ�򣬻�Ҫȷ������ÿ��Ԫ�ص�ѡ���������ͬ��
 * 
 */
public class AvgProbabilityUnknownTotal {

	public int getProbability(int max) {
		int probablity = -1;

		Random random = new Random();
		for (int i = 0; i < max; i++) {
			int rand = random.nextInt();
			if (rand < 0)
				rand = -rand;

			if (rand % (i + 1) == 0) {
				probablity = i;
			}
		}

		return probablity;
	}
}
