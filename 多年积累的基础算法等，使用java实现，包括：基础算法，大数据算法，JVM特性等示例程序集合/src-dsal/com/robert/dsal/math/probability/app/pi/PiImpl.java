package com.robert.dsal.math.probability.app.pi;

import java.util.Date;
import java.util.Random;

/**
 * 
 * (PI * r * r / 4) / (r * r) = PI / 4, Ҳ����˵�ڵ�һ���ޣ���PI/4�ĵ�����Բ�����档
 * 
 * PI*r^2��Բ�����������4���ǵ�һ����Բ�������r^2�ǵ�һ�������������ε������ PI/4���� 1/4Բ���ڵ������������������ı���ratio
 * 
 * PI = ratio * 4
 * 
 * 
 */
public class PiImpl implements Pi {
	public double calcPi() {
		final int nums = 10000000;

		int numsin = 0;
		Random ran = new Random(new Date().getTime());

		for (int i = 0; i < nums; i++) {
			double x = ran.nextDouble();
			double y = ran.nextDouble();

			// ��Բ����ͳ������
			if (x * x + y * y < 1 * 1)
				numsin++;
		}

		// ratio * 4
		return ((double) numsin / nums) * 4;
	}
}
