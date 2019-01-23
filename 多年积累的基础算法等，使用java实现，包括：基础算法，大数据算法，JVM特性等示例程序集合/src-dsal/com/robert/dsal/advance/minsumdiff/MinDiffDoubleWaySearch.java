package com.robert.dsal.advance.minsumdiff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/**
 * ˫������:
 * 
 * ��50�����ȷֳ�����A��B��ÿ��25����������A���B���Ӽ�����Ϊ1-25���Ӽ��ĺͣ�������hash��Ȼ���ö���A�ĳ���i�ļ��ϵ�Ԫ��֮��k��sum/2
 * -k���Ƿ���B����Ϊ25-i���Ӽ��С�
 * 
 * ���裺�����Ѿ�֤��1-50�����ֵ�������ƽ�ֺ�����0����1
 * 
 */
public class MinDiffDoubleWaySearch implements MinDiff {

	public Result minDiff(int start, int end, int power) {
		// �����ʼ��
		int[] x = new int[end - start + 1];

		for (int i = 0; i < x.length; i++) {
			x[i] = (int) Math.pow(start + i, power);
		}

		// ������żλ�÷ֳ�2��
		int[] xe = new int[x.length / 2];
		int[] xo = new int[x.length / 2];

		for (int i = 0; i < xe.length; i++) {
			xe[i] = x[i * 2];
			xo[i] = x[i * 2 + 1];
		}

		// ���������
		int sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum += x[i];
		}

		// ����hash�ͣ�������25��Ԫ�أ���ʾ��1������25�����ĺ͵ļ��ϣ������е�key�Ǻͣ�value�ǹ�������͵���Щ�����б�
		HashMap<Integer, List<Integer>>[] hos = map(xo);
		HashMap<Integer, List<Integer>>[] hes = map(xe);

		// ����1������25�����ļ���
		for (int i = 0; i < hos.length; i++) {
			HashMap<Integer, List<Integer>> ho = hos[i];
			Iterator<Entry<Integer, List<Integer>>> iter = ho.entrySet()
					.iterator();

			// ���ھ���i�����ֵļ���
			while (iter.hasNext()) {
				Entry<Integer, List<Integer>> entryo = iter.next();
				// ȡ�ô˼��ϵĺͺͼ���Ԫ�ظ���
				int sumo = entryo.getKey();
				int numo = i + 1;

				// �ҵ�����һ��25������������ĺ���Щ����ϲ��ܹ�25���ļ���
				int nume = 25 - numo;
				HashMap<Integer, List<Integer>> he = hes[nume - 1];
				Iterator<Entry<Integer, List<Integer>>> iter1 = he.entrySet()
						.iterator();
				while (iter1.hasNext()) {
					Entry<Integer, List<Integer>> entrye = iter1.next();

					int sume = entrye.getKey();

					if (sumo + sume == sum / 2) {
						// ����������Ϻϲ����õ����ܺ͵�һ�㣬���Ǵ�
						Result result = new Result();
						result.diff = ((sum % 2 == 0) ? 0 : 1);
						result.c1.addAll(entryo.getValue());
						result.c1.addAll(entrye.getValue());

						for (int j = 0; j < x.length; j++) {
							if (!result.c1.contains(x[j]))
								result.c2.add(x[j]);
						}
						return result;
					}

				}
			}

		}

		return null;
	}

	private HashMap<Integer, List<Integer>>[] map(int[] xo) {
		HashMap<Integer, List<Integer>>[] results = new HashMap[xo.length];

		// 1 - 25��
		for (int i = 0; i < results.length; i++) {
			results[i] = doMap(xo, i + 1);
		}

		return results;
	}

	private HashMap<Integer, List<Integer>> doMap(int[] xo, int count) {
		HashMap<Integer, List<Integer>> results = new HashMap<Integer, List<Integer>>();
		List<Integer> buffer = new ArrayList<Integer>();

		// ���뷨�����
		doMap(xo, count, results, buffer, 0, 0);

		return results;
	}

	private void doMap(int[] xo, int count,
			HashMap<Integer, List<Integer>> result, List<Integer> buffer,
			int current, int start) {
		if (current == count) {
			// �ҵ�һ����
			int sum = sum(buffer);

			List<Integer> coll = new ArrayList<Integer>();
			coll.addAll(buffer);

			result.put(sum, coll);
			return;
		}

		// ѭ���ӵݹ�
		for (int i = start; i < xo.length - count + current; i++) {
			buffer.add(xo[i]);

			doMap(xo, count, result, buffer, current + 1, i + 1);

			buffer.remove(new Integer(xo[i]));
		}

	}

	private int sum(List<Integer> buffer) {
		int sum = 0;
		for (int i = 0; i < buffer.size(); i++) {
			sum += buffer.get(i);
		}
		return sum;
	}

}
