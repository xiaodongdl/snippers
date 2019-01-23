package com.robert.dsal.advance.sumcoll;

import java.util.ArrayList;
import java.util.List;

import com.robert.dsal.util.CollectionUtil;

// TODO ����ö�̬�滮��

/* ����˼·�� 
 * 
 * ������˼·�ο�0-1���������庯��F(n,m)�����������⣬��ôF(n,m)���Էֽ�Ϊ����������F(n-1,m)��F(n-1,m-n).
 * ������ĿҪ���г����е���ϣ�ʹ�����ƶ�̬�滮�ķ����Ƚϸ��ӣ���������ֱ��ʹ�õݹ������������⡣
 * ��ȻЧ�ʿ��ܲ��Ǻܺã����Ǵ���Ŀɶ��Ի��ǱȽϺõġ�
 * 
 */

public class SumProblemBruteForce implements SumProblem {

	private static void printSolution(int[] flags, List<List<Integer>> result) {
		List<Integer> solution = new ArrayList<Integer>();

		for (int i = 0; i < flags.length; i++) {
			if (flags[i] == 1)
				solution.add(i + 1);
		}

		result.add(solution);
	}

	private static void solveBagProblem(int n, int m, int[] flags,
			List<List<Integer>> result) {
		if (n < 1 || m < 1)
			return;

		if (m < n)
			n = m;

		if (m == n) {
			flags[n - 1] = 1;
			printSolution(flags, result);

			flags[n - 1] = 0;
			solveBagProblem(n - 1, m, flags, result);
			return;
		}

		flags[n - 1] = 1;
		solveBagProblem(n - 1, m - n, flags, result);

		flags[n - 1] = 0;
		solveBagProblem(n - 1, m, flags, result);
	}

	public int[][] solveSumProblem(int n, int m) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int[] flags = new int[n];

		solveBagProblem(n, m, flags, result);

		return CollectionUtil.convertArray(result);
	}
}
