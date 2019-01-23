package com.robert.dsal.advance.bag01;

/**
 * 
 * O(n * v), n����Ʒ�������� v�Ǳ�����������������Ϊ��Ҫ���ά��
 * 
 * �����
		ID W V
		0  3  8
		1 10  5
		2  2  3
		3  8 20

      ���������ǣ� 13
      ��̬�滮��
 *  0  0  8  8  8  8  8  8  8  8  8  8  8 
 *  5  5  8  8  8  8  8  8  8  8  8  8 13 
 *  5  5  8  8 11 11 11 11 11 11 11 11 13 
 *  20 20 20 20 20 20 20 20 25 25 28 28 31 
 * 
 */
public class BagProblemDynamicProgramming implements BagProblem {
	public BagSolution bestSolution(Object[] objects, int volume) {
		int[][] matrix = new int[objects.length][volume];

		// ��ʼ����һ��
		for (int i = 0; i < matrix[0].length; i++) {
			// i��ʾ����i + 1
			if (i + 1 < objects[0].weight)
				matrix[0][i] = 0;
			else
				matrix[0][i] = objects[0].value;
		}

		// ���㶯̬�滮��
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				// ��̬�滮����
				// matrix[i][j]= max(matrix[i-1][j-objects[i].weight] +
				// objects[i].value, matrix[i-1][j])
				matrix[i][j] = Math.max(includeCurrent(matrix, objects, i, j),
						excludeCurrent(matrix, i, j));
			}
		}

		// �������
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.format("%2d ", matrix[i][j]);
			}
			System.out.println();
		}

		// �����½ǿ�ʼ�����ϽǼ���ṹ�����ĳ��ֵ��ǰһ��Ԫ���Ǹ�ֵ��ȣ��򲻰���
		// �������
		int i = matrix.length - 1;
		int j = matrix[0].length - 1;

		boolean[] vector = new boolean[matrix.length];
		while (i - 1 >= 0) {
			if (matrix[i][j] != matrix[i - 1][j]) {
				// ���������ǰԪ�أ���ô��һ��Ԫ��ѡȡҪ��Ծ��ǰԪ�ص�����
				vector[i] = true;
				j -= objects[i].weight;
			}
			i--;
		}

		// �����һ����Ԫ��
		if (matrix[i][j] > 0)
			vector[0] = true;

		return new BagSolution(objects, vector, volume,
				matrix[matrix.length - 1][matrix[0].length - 1]);
	}

	private int includeCurrent(int[][] matrix, Object[] objects, int i, int j) {
		// Խ��ͷ��ص�ǰֵ
		if (i - 1 < 0 || j - objects[i].weight < 0)
			return objects[i].value;

		// ��Խ��ͷ��ش�ǰi-1����������ѡ����������ǰ����ļ�ֵ�����ϵ�ǰ����ļ�ֵ��Ҳ���Ǽ����������ǰ����ļ�ֵ
		return matrix[i - 1][j - objects[i].weight] + objects[i].value;
	}

	private int excludeCurrent(int[][] matrix, int i, int j) {
		// Խ�緵��0
		if (i - 1 < 0 || j < 0)
			return 0;

		// ����ǰi-1�������ܹ����������ֵ��Ҳ���ǲ�������ǰ����
		return matrix[i - 1][j];
	}
}
