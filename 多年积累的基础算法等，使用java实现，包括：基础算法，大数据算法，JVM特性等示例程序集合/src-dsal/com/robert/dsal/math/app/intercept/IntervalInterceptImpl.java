package com.robert.dsal.math.app.intercept;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ʱ�临�Ӷȣ�O(n) �ռ临�Ӷ�: O(n), n�����䷶Χ�Ĵ�С���ʺ�����Ƚ϶࣬���Ƿ�Χ�Ƚ�С��
 * 
 * �Ե�һ��������λͼ���ڶ������������֮�н��������λͼ��ֵ������ӡ���е����䡣
 * 
 */
public class IntervalInterceptImpl implements IntervalIntercept {
	public List<Interval> intercept(Interval i1, List<Interval> c2) {
		if (i1 == null || c2 == null || c2.isEmpty())
			return null;

		return doIntercept(i1, c2);
	}

	private List<Interval> doIntercept(Interval i1, List<Interval> c2) {
		// ���յ�һ��������г�ʼ����־����
		int rleft = i1.x;
		int rsize = i1.y - i1.x + 1;

		// ��־����ȫ���Զ���ʼ��Ϊfalse
		boolean[] frange = new boolean[rsize];

		// ���ڵڶ������ϵ�ÿһ�����䣬����͵�һ�������غϣ�������Ϊtrue
		for (Interval interval : c2) {
			mark(interval, i1, frange);
		}

		// �������е�true���ɵ����伯��
		return calcIntervals(rleft, frange);

	}

	private void mark(Interval interval, Interval range, boolean[] frange) {
		// �ҵ��غϣ�Ȼ������Ϊtrue
		for (int i = (interval.x > range.x ? interval.x : range.x); i <= (interval.y < range.y ? interval.y
				: range.y); i++) {
			int diff = i - range.x;
			frange[diff] = true;
		}
	}

	private List<Interval> calcIntervals(int left, boolean[] frange) {
		List<Interval> result = new ArrayList<Interval>();

		// �����־
		int start = -1;
		for (int i = 0; i < frange.length; i++) {
			// ���俪ʼ
			if (start == -1 && frange[i]) {
				start = i;
			}

			// �������
			if (start != -1 && !frange[i]) {
				result.add(new Interval(start + left, i - 1 + left));
				start = -1;
			}
		}

		// ���һ������
		if (start != -1)
			result.add(new Interval(start + left, frange.length - 1 + left));

		return result;
	}
}
