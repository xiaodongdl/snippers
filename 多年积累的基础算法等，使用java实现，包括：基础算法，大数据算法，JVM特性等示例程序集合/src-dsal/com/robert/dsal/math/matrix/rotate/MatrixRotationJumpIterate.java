package com.robert.dsal.math.matrix.rotate;

public class MatrixRotationJumpIterate implements MatrixRotation {
	public void rotateMatrix(int[][] a) {
		int s = a.length;
		int times = s / 2;

		// ÿ�㿪ʼԪ�ص�x,y����x�� ��(0,0)(1,1)(2,2)
		// x��ʾ������
		for (int x = 0; x < times; x++) {
			// ����ÿ��ÿ�μ�������Ԫ�أ�����ÿ����ж��Ǵ�x��ʼ��
			// y��ʾ��������
			for (int y = x; y < s - 1 * (x + 1); y++) {
				System.out.println(x + ":" + y);
				int t = a[s - 1 - y][x];
				a[s - 1 - y][x] = a[s - 1 - x][s - 1 - y];
				a[s - 1 - x][s - 1 - y] = a[y][s - 1 - x];
				a[y][s - 1 - x] = a[x][y];
				a[x][y] = t;
			}
		}
	}
}