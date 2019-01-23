package com.robert.dsal.recursion.condiv;

public class ContineousDivRecursion implements ContineousDiv {

	public double divContineously(double[] operants) {
		return divContineously(operants, operants.length - 1);
	}

	/**
	 * �����0 - i����λ��������ֵ
	 */
	private double divContineously(double[] operants, int i) {
		if (i == 1)
			return operants[0] / operants[1];

		// �����0 - i-1����λ��������ֵ��Ȼ���ٳ���i����λ�õ�ֵ
		return divContineously(operants, i - 1) / operants[i];
	}

}
