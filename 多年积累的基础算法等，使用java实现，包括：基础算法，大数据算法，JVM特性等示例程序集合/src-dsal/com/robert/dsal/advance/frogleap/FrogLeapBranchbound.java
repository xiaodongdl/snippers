package com.robert.dsal.advance.frogleap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * l^n, l����Ԫ�ص�ƽ����С��Ҳ��ƽ���������ȣ��������з�֧�綨�Ļ��ݣ��ܹ���֦�����ԣ�Ч�ʴ����ߣ����������������н⣬Ȼ�����ڼ�֦
 * 
 */

public class FrogLeapBranchbound implements FrogLeap {

	public int[] fropLeap(int[] arrays) {
		int[] optimum = new int[arrays.length + 1];
		optimum[optimum.length - 1] = arrays.length;

		List<int[]> possibles = new ArrayList<int[]>();

		int[] current = new int[arrays.length + 1];
		current[current.length - 1] = 0;
		current[current[current.length - 1]++] = 0;

		possibles.add(current);

		while ((current = mostPossible(possibles, optimum[optimum.length - 1])) != null) {
			// ÿ��ȡ��һ����㣬Ȼ��������֮���û�ڵ������չ�ڵ㣬��ʱ���Զ���չ�ڵ���˼�֦
			if (isOneSolution(current)) {
				if (current[current.length - 1] < optimum[optimum.length - 1]) {
					copySolution(optimum, current);
				}
				continue;
			}

			int csize = current[current.length - 1];
			int cindex = current[csize - 1];
			int cvalue = arrays[cindex];

			// ������չ�ڵ㣬�����ڲ��������н��м�֦���������ﶼ�����ռ䣬Ȼ���ó���ڵ��ʱ���ټ�֦
			for (int i = 1; i <= cvalue; i++) {
				int nindex = cindex + i;

				int[] next = current.clone();
				next[next[next.length - 1]++] = nindex;
				possibles.add(next);
			}
		}

		return Arrays.copyOf(optimum, optimum[optimum.length - 1]);
	}

	private int[] mostPossible(List<int[]> possibles, int osize) {
		int[] mostPossible = null;

		for (int i = possibles.size() - 1; i >= 0; i--) {
			int[] p = possibles.get(i);

			int psize = p[p.length - 1];
			if (psize > osize)
				// �������Ƿ�֧�綨����Ļ��ݣ�Ҳ���Ǽ�֦
				// ��Ҫ�Ľ�����ṹ���������ṹ���ӣ�������������һ��Ԫ����Ϊ���ȱȽ��鷳
				possibles.remove(p);
			else if (mostPossible == null
					|| p[psize - 1] > mostPossible[mostPossible.length - 1])
				mostPossible = p;
		}

		if (mostPossible != null) {
			possibles.remove(mostPossible);
		}

		return mostPossible;
	}

	private boolean isOneSolution(int[] current) {
		int size = current[current.length - 1];
		int index = current[size - 1];
		return index >= current.length - 2;
	}

	private void copySolution(int[] optimum, int[] current) {
		for (int i = 0; i < current[current.length - 1]; i++)
			optimum[i] = current[i];

		optimum[optimum.length - 1] = current[current.length - 1];
	}

}
