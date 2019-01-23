package com.robert.dsal.math.matrix.multiple;

/**
 * <b>�㷨����:</b><br>
 * 1. a[x][y] * b[y][z] = r[x][z], ����a������������ھ���b��������<br>
 * 2. ĳһ��Ԫ��r[i][j]���ھ���a����i�е�Ԫ�س��Ծ���b����j�е�����Ԫ�س˻�֮�͡�
 * <p>
 * <b>�㷨ʱ�临�Ӷ�:</b><br>
 * O(N^3)
 * 
 */
public class MatrixMultiplyImpl implements MatrixMultiply {
	public int[][] multiply(int[][] a, int[][] b) {
		int arow = a.length, acol = a[0].length;
		int brow = b.length, bcol = b[0].length;
		if (acol != brow)
			return null;
		int rrow = arow, rcol = bcol;

		int[][] r = new int[rrow][rcol];
		for (int i = 0; i < rrow; i++)
			for (int j = 0; j < rcol; j++) {
				r[i][j] = 0;
				for (int k = 0; k < acol; k++)
					r[i][j] += a[i][k] * b[k][j];
			}

		return r;
	}

}
