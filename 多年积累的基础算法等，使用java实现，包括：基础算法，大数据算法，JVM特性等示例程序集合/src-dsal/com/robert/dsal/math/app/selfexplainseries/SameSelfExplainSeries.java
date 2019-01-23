package com.robert.dsal.math.app.selfexplainseries;

import java.util.List;

public class SameSelfExplainSeries implements SameSeries {

	/**
	 * ����1����ǰ������������Ԫ�رߺϲ����ҵ���С�ģ�������С���ܲ��ܵ����С��
	 * ����2������һ�ַ�������Ϊ�������ж�������ģ����Խ���һ�ι鲢��Ȼ������������Ԫ���Ƿ�ǰһ���ܵ����һ��
	 */
	public boolean isSameSeries(List<Element> s1, List<Element> s2) {

		if (s1 == null || s2 == null)
			return true;

		// ����s1, s2���������

		// ����ÿ���������ڸ��Ե�ͬһ������
		if (s1.size() == 0 || s2.size() == 0)
			return true;

		Element e1 = s1.get(0);
		Element e2 = s2.get(0);

		// ������������Ԫ�ز��ظ�������ظ�����ͬһ��������
		if (e1.compareTo(e2) == 0)
			return false;

		// �ҵ�����ͷԪ����С��һ��
		Element ecurr = null;
		int i = 0, j = 0;
		if (e1.compareTo(e2) > 0) {
			ecurr = e2;
			j++;
		} else {
			ecurr = e1;
			i++;
		}

		Element emin = null;
		while (i < s1.size() && j < s2.size()) {
			e1 = s1.get(i);
			e2 = s2.get(j);

			// ������������Ԫ�ز��ظ�������ظ�����ͬһ��������
			if (e1.compareTo(e2) == 0)
				return false;

			// �ҵ�����ͷԪ������С��һ��
			if (e1.compareTo(e2) > 0) {
				emin = e2;
				j++;
			} else {
				emin = e1;
				i++;
			}

			// ��������һ����С���ܲ��ܵ���һ����С��
			if (!reachable(ecurr, emin))
				return false;

			ecurr = emin;

		}

		if (i < s1.size()) {
			if (reachable(ecurr, s1.get(i)))
				return true;
		}

		if (j < s2.size()) {
			if (reachable(ecurr, s2.get(j)))
				return true;
		}

		return false;
	}

	private boolean reachable(Element ecurr, Element emin) {
		while (ecurr.compareTo(emin) < 0) {
			ecurr = ecurr.next();
		}

		if (ecurr.compareTo(emin) == 0)
			return true;

		return false;
	}
}
