package com.robert.dsal.math.matrix.rotate.byfold;

public class MatrixRotateByFold implements MatrixRotate {

	public int[][] rotateLeft(int[][] m) {
		int d = m.length;

		int[][] result = new int[d][];
		for (int i = 0; i < d; i++) {
			result[i] = new int[d];
		}

		// �����Խ��ߣ������Ͻǵ����½Ƕ��ۣ�Ȼ�����¶���
		for (int i = 0; i < d; i++)
			for (int j = 0; j < d; j++)
				result[j][i] = m[i][j];

		for (int i = 0; i < d / 2; i++)
			for (int j = 0; j < d; j++) {
				int tmp = result[i][j];
				result[i][j] = result[d - 1 - i][j];
				result[d - 1 - i][j] = tmp;
			}

		return result;
	}

	public int[][] rotateRight(int[][] m) {
		int d = m.length;

		int[][] result = new int[d][];
		for (int i = 0; i < d; i++) {
			result[i] = new int[d];
		}

		// ��б�Խ��ߣ������Ͻǵ����½Ƕ��ۣ�Ȼ�����¶���
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {
				result[i][j] = m[d - 1 - j][d - 1 - i];
			}
		}

		for (int i = 0; i < d / 2; i++)
			for (int j = 0; j < d; j++) {
				int tmp = result[i][j];
				result[i][j] = result[d - 1 - i][j];
				result[d - 1 - i][j] = tmp;
			}

		return result;
	}
}
