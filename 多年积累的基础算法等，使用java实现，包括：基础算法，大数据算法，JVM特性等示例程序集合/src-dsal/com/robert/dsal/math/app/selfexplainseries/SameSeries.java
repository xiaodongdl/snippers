package com.robert.dsal.math.app.selfexplainseries;

import java.util.List;

/**
 * 
 * ����1 �� 1 1�� 2 1�� 1 2 1 1 ��1 2 3 1��1 2 1 3 2 1��3 1 2 2 1 3��һ����ǰһ�����ͣ��� 1 1 ��ʾǰ����1 ��1�������������У�����ж������Ƿ�����ͬһ��ϵ��?
 *
 */
public interface SameSeries {
	public boolean isSameSeries(List<Element> s1, List<Element> l2);
}
