package com.robert.dsal.advance.minsumdiff;

// TODO ���֤�� num > 10, ������͵���С����0����1�أ�


/**
 * 
 * ��������������⣺ 2->7 4->30 6->9 8->4 10->19 12->0 14->1 16->0 18->1 20->0 22->1 24->0 26->1 ���Կ�������������������10������ƽ�ֺ������͵���С��ֵ��0����1��
 * ��������������ż�����ܾ��֣������������������������������С���1��
 * 
 * ������������ת��ΪѰ��25�����֣�ʹ���ǵĺ͵���sum(x) / 2��ĳһ����ϼ��ɡ� 
 * 1. �����������ݹ飬���ݣ���֧�綨�ȱ�������� 
 * 2. ������̰����������:
 * 
 * ̰���������Ƚ����鰴��������ż��λ�ֳ�2�飬�������������ż�����飬Ȼ�����������֮�͵�ƽ����(sum/2)�������ƽ������ż�����鵽֮��T(
 * ż�������С��T ����������ʹ���T)���������ҵ���������һ�����֣�ʹ֮����ӽ��ڲ�T��Ȼ�󣬽���������С��ż����͵Ĳֱ��Ϊ0����1��
 * 
 */
public class MinDiffSearch implements MinDiff {

	public Result minDiff(int start, int end, int power) {
		// �����ʼ��
		int[] x = new int[end - start + 1];

		for (int i = 0; i < x.length; i++) {
			x[i] = (int) Math.pow(start + i, power);
		}

		// ������żλ�÷ֳ�2��
		int[] xo = new int[x.length / 2];
		int[] xe = new int[x.length / 2];

		for (int i = 0; i < xe.length; i++) {
			xe[i] = x[i * 2];
			xo[i] = x[i * 2 + 1];
		}

		// ���������
		int sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum += x[i];
		}

		// ����ƽ��ֵ
		int avg = sum / 2;

		// ����ż�������
		int sume = 0;
		for (int i = 0; i < xe.length; i++) {
			sume += xe[i];
		}

		// ����Ҫ������������ͣ���Ϊ��������Ϳ��ܵ���ż������ͻ���ż������ͼ�1

		// ���� ����T�� ���ǲ�����
		int diff = avg - sume;

		// �ҵ�һ�����֣�ʹ֮�������ӽ�diff��
		while (diff > 1) {
			// �ҵ��������ֺ�ż��������ĳһ�����֣��������֮����ӽ���diff
			int min = Integer.MAX_VALUE;
			int xi = 0;
			int xj = 0;
			for (int i = 0; i < xe.length; i++) {
				for (int j = 0; j < xe.length; j++) {
					// ����һ������֮��
					int tmp = xo[i] - xe[j];
					// �������ֵT�Ľ��ƶ�
					int d = diff - tmp;

					// ����������ֵT���ƶ�����0�����ұ�֮ǰ�Ļ�Ҫ���ƣ�Ҳ�����ܹ����ֵT�����ǻ�����ż�������С����������ʹ�
					if (tmp > 0 && d >= 0 && d < diff && d < min) {
						xi = i;
						xj = j;
						min = d;
					}

				}
			}

			
			//TODO ���ﲻ�ԣ�����û������
			// �ҵ��򽻻�
			int tmp = xo[xi];
			xo[xi] = xe[xj];
			xe[xj] = tmp;

			if (xi  == 0 && xj == 0) {
				for (int i = 0; i < xe.length; i++) {
					for (int j = 0; j < xe.length; j++) {
						// ����һ������֮��
						tmp =  xo[i] - xe[j];
						// �������ֵT�Ľ��ƶ�
						int d = tmp - diff;

						// ����������ֵT���ƶ�����0�����ұ�֮ǰ�Ļ�Ҫ���ƣ�Ҳ�����ܹ����ֵT�����ǻ�����ż�������С����������ʹ�
						if (tmp >= 0 && d >= 0 && d < diff && d < min) {
							xi = i;
							xj = j;

							tmp = xo[xi];
							xo[xi] = xe[xj];
							xe[xj] = tmp;
							min = d;
						}

					}
				}		
				
			

				int[] abc = xe;
				xe = xo;
				xo = abc;
			}
			
			// ����ż�������
			sume = 0;
			for (int i = 0; i < xe.length; i++) {
				sume += xe[i];
			}

			// ���� ����T�� ���ǲ�����
			diff = avg - sume;
		}

		// ���ؽ��
		Result result = new Result();
		result.diff = diff;
		for (int i = 0; i < xe.length; i++) {
			result.c1.add(xe[i]);
			result.c2.add(xo[i]);
		}

		return result;
	}

}
