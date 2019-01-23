package com.robert.dsal.math.probability.randomnlines;

import java.util.Date;
import java.util.Iterator;
import java.util.Random;

public class SampleNImpl implements SampleN {

	/*
	 * ���ظ�Ԫ�أ�����ȡ2n����Ȼ��������ȡn��
	 */

	public int[] sample(Iterator<Integer> x, int n) {
		Random random = new Random(new Date().getTime());

		int[] results = new int[n];

		int count = 1;
		while (x.hasNext()) {
			for (int i = 0; i < n; i++) {
				int rand = random.nextInt();

				if (rand % count == 0) {
					results[i] = x.next().intValue();
				}
			}
			count++;
		}

		return results;
	}

}
