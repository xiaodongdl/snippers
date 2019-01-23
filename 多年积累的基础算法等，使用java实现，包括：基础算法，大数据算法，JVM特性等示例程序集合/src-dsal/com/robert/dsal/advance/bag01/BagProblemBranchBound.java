package com.robert.dsal.advance.bag01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * 2^n, ��������ͨ�Ļ����⣬���з�֧�綨�ļ�֦����֧�綨ͨ��������ȱ����������ҵ�һ�����п��ܵĽ⣬Ȼ�������п��ܵĽ���м�֦��Ч�ʸ������
 * 
 * ��֧�綨�ǹ�����ȱ���
 */

public class BagProblemBranchBound implements BagProblem {
	public BagSolution bestSolution(Object[] bags, int volumn) {
		// ���ռ�ֵ�����Ƚ������У����ڼ�֦
		Arrays.sort(bags, new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				return o1.getRatio() - o2.getRatio() > 0 ? -1 : 1;
			}
		});

		// ��ռ�ļ��ϣ�ÿ��������ǲ��ֽ⣬����ȫ
		List<BagSolution> solutions = new ArrayList<BagSolution>();

		// ��ʼ����һ��Ԫ�ؽ����ռ�
		BagSolution seed = new BagSolution(bags, new boolean[bags.length],
				volumn);
		solutions.add(seed.nextStep(false));
		solutions.add(seed.nextStep(true));

		// ��֧�綨���
		return bestSolution(solutions, bags, volumn);
	}

	private BagSolution bestSolution(List<BagSolution> solutions,
			Object[] bags, int volumn) {
		// ���浱ǰ��ѷ���
		BagSolution best = new BagSolution(bags, new boolean[bags.length],
				volumn);

		BagSolution active = null;

		// ȡ�û�ڵ㣬�Ҽ�ֵ������Ϊ��ڵ�
		while ((active = loadCurrentBest(solutions)) != null) {
			// ��ͨ���ݣ��ͻ��ݷ�����һ���ģ��޶�����
			if (active.weightSum > volumn)
				continue;

			// ��֧�綨�Ļ��ݣ�ͨ����ֵ�����������ݣ���Ϊ�ǹ�����ȱ����������ҵ�һ�����п��ܵĽ⣬Ȼ��ͨ�����п��ܵĽ���м�֦
			// �����ǰ��ļ�ֵ�ܺͱȵ�ǰ���Ҫ����100%��ϣ����Ϊ��ѽ⣬���ԣ������ݹ�
			// �����ǰ��ļ�ֵ�ܺͱȵ�ǰ���ҪС������ϣ��ͨ����֦��ȥ��
			// �������Ҫ�ļ�ֵ�����ȱ����ṩ�����Ļ��󣬾Ͳ�������һ���⣬Ҳ���Ǽ�ʹ���������ṩ�����������ʣ��������ռ䣬����û�е�ǰ����
			if (active.valueSum < best.valueSum
					&& active.missRatio(best.valueSum) > active.nextMaxRatio())
				continue;

			// ���������ȡ
			if (active.curr == bags.length - 1
					&& active.valueSum > best.valueSum) {
				best.copyFrom(active);
				//break;
				continue;
			}

			// ͨ����ǰ��ڵ�������һ����������չ�ڵ�
			solutions.add(active.nextStep(false));
			solutions.add(active.nextStep(true));
		}

		return best;

	}

	private BagSolution loadCurrentBest(List<BagSolution> solutions) {
	    if (solutions.size() == 0)
	        return null;
	    
		int max = 0;

		// �ҵ���ǰ��ֵ���ķ���
		for (int i = 1; i < solutions.size(); i++) {
			BagSolution bs = solutions.get(i);

			if (bs.valueSum > max)
				max = i;
		}

		// �Ƴ���ǰ��ֵ���ķ���
		BagSolution currentBest = solutions.get(max);
		solutions.remove(max);

		return currentBest;
	}
}
