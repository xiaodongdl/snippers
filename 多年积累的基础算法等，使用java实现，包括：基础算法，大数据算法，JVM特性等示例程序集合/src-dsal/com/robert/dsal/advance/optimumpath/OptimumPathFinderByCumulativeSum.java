package com.robert.dsal.advance.optimumpath;

import java.util.ArrayList;
import java.util.List;

// TODO ͬ���ö�̬�滮����������½������Ͻ��ƣ�һ��ѡ����߻����������ģ���ôֻ��ҪO(n)�ռ临�Ӷ�

/**
 * 
 * O(n^2), ���ھ����е�����Ԫ�أ�����������, �ռ临�Ӷ�O(n^2)
 * 
 */
public class OptimumPathFinderByCumulativeSum implements OptimumPathFinder {
	public OptimumPath findOptimumPath(int[][] matrix) {
		OptimumPath solution = new OptimumPath();
		int[][] sum = matrix.clone();

		// ���������ĳһ�������ֿ��ܣ�һ�־��Ǵ���߹�����һ���Ǵ��ϱ߹�������ߺ��ϱ�ȡ���ļӵ���ǰԪ�أ����һ��Ԫ�ص��ۼӺ;�������·����Ȩֵ֮��
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < sum.length; j++) {
				int max = 0;
				if (i - 1 >= 0 && sum[i - 1][j] > max)
					max = sum[i - 1][j];

				if (j - 1 >= 0 && sum[i][j - 1] > max)
					max = sum[i][j - 1];

				sum[i][j] += max;
			}
		}

		// ���һ��Ԫ�ص��ۼӺ;�������·����Ȩֵ֮��
		List<Point> points = new ArrayList<Point>();
		int x = sum.length - 1;
		int y = sum[0].length - 1;
		solution.pathValue = sum[x][y];

		// �����һ��Ԫ�ؿ�ʼ���ˣ����Ԫ�غ��ϱ�Ԫ���ĸ�����Ƶ���ȥ
		while (x >= 0 && y >= 0) {
			Point p = new Point();
			p.x = x;
			p.y = y;
			points.add(p);

			if (x == 0)
				y--;
			else if (y == 0)
				x--;
			else if (sum[x - 1][y] > sum[x][y - 1])
				x--;
			else {
				y--;
			}
		}

		solution.points = points.toArray(new Point[0]);

		return solution;
	}
}
