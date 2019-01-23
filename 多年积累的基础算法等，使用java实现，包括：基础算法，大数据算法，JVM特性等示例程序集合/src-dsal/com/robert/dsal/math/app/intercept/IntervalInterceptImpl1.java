package com.robert.dsal.math.app.intercept;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * O(n^2), n������ĸ������ʺ�����Ƚ��ٵģ��������䷶Χ�Ƚϴ��
 * 
 * �Ȱѵ�һ������ͺ����������佻����Ȼ��ȥ����Ч���䣬Ȼ���ά�������ҵ��ܹ���ǰ�ϲ�������Ԫ�أ����Ҽ�¼��ǰ�ϲ���������Ȼ�����κϲ������ȡ�ò�����
 * 
 */
public class IntervalInterceptImpl1 implements IntervalIntercept {

	public List<Interval> intercept(Interval i1, List<Interval> c2) {
		// �ϲ���־��ʼ��
		int[] flag = new int[c2.size()];

		for (int i = 0; i < c2.size(); i++) {
			// �õ�һ������͵ڶ��������е�ÿһ��������������
			Interval it = c2.get(i);
			// ȡ����
			it.x = Math.max(i1.x, it.x);
			it.y = Math.min(i1.y, it.y);

			// ���������������ЧԪ�أ�������Ϊ-2�����������ЧԪ��������-1
			if (it.x > it.y)
				flag[i] = -2;
			else
				flag[i] = -1;
		}

		// ��ȡ�����еĽ������ȡ����
		return merge(c2, flag);
	}

	private List<Interval> merge(List<Interval> c2, int[] flag) {
		for (int i = 0; i < c2.size() - 1; i++) {
			Interval it = c2.get(i);

			// ����Ч����
			if (flag[i] == -2)
				continue;

			for (int j = i + 1; j < c2.size(); j++) {
				Interval it1 = c2.get(j);

				// ����Ч����
				if (flag[j] == -2)
					continue;

				// ��������н��������¼Ҫ�ϲ���Ŀ��Ԫ�أ��Ӻ���ǰ�����flag>=0, ���ʾ��ǰԪ��Ҫ�ϲ���flag[i]���ڵ�����
				if ((it.x >= it1.x && it.x <= it1.y)
						|| (it.y >= it1.x && it.y <= it1.y))
					flag[j] = i;
			}
		}

		// �����һ��Ԫ�ص���һ��Ԫ�ؽ��кϲ�
		for (int i = flag.length - 1; i > 0; i--) {
			if (flag[i] != -2 && flag[i] != -1) {
				Interval c = c2.get(i);
				Interval t = c2.get(flag[i]);

				// ǰ��һ����֤�н���������ȡ����
				t.x = Math.min(c.x, t.x);
				t.y = Math.max(c.y, t.y);

				// �ϲ���ǰ�漯�Ϻ󣬾ͱ�־-2���Ǹ���Ч������
				flag[i] = -2;
			}

		}

		List<Interval> result = new ArrayList<Interval>();

		for (int i = 0; i < flag.length; i++) {
			// ��ӡ������Ч����
			if (flag[i] != -2)
				result.add(c2.get(i));
		}

		return result;
	}

}
