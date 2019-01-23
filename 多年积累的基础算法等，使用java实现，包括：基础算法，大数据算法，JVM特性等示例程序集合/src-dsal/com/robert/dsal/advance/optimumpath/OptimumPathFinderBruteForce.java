package com.robert.dsal.advance.optimumpath;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * O(2^(n*n)), ָ����
 * 
 */
public class OptimumPathFinderBruteForce implements OptimumPathFinder {

	private void checkSolution(int[][] matrix, List<Point> solutionPool,
			OptimumPath solution) {
		int sum = 0;
		for (Point point : solutionPool) {
			sum += matrix[point.x][point.y];
		}

		if (sum > solution.pathValue) {
			solution.pathValue = sum;
			solution.points = solutionPool.toArray(new Point[0]);
		}
	}

	private void findOptimumPath(int[][] matrix, int x, int y,
			List<Point> solutionPool, OptimumPath solution) {
		// 1.�Ȱѵ�ǰ״̬��� 2.��������� 3.�ݹ���һ�� 4.�����ǰ״̬���˻���һ��

		Point self = new Point();
		self.x = x;
		self.y = y;
		solutionPool.add(self);

		// ����ĵ㵽�������һ���㣬���ǽ������
		if (x == matrix.length - 1 && y == matrix[0].length - 1) {
			checkSolution(matrix, solutionPool, solution);
			solutionPool.remove(self);
			return;
		}

		// ������
		if (x != matrix.length - 1) {
			findOptimumPath(matrix, x + 1, y, solutionPool, solution);
		}

		// ������
		if (y != matrix[0].length - 1) {
			findOptimumPath(matrix, x, y + 1, solutionPool, solution);
		}

		// һ��Ҫ�����ǰ״̬���˻ص���һ��
		solutionPool.remove(self);
	}

	public OptimumPath findOptimumPath(int[][] matrix) {
		OptimumPath solution = new OptimumPath();
		List<Point> solutionPool = new ArrayList<Point>();

		findOptimumPath(matrix, 0, 0, solutionPool, solution);

		return solution;
	}

}
