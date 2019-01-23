package com.robert.cci.c02.q02;

/**
 * 
 * �ⷨ����һ�α������������m��Ȼ�����ת��Ϊ���Ҵӵ�һ��Ԫ�ؿ�ʼ�ĵ�m - n + 1��Ԫ�ء�
 * 
 * ���ʱ�临�Ӷ�: O(2n)
 * 
 */
public class Nth2LastElementFinderTraverseTwice implements
		Nth2LastElementFinder {

	public LinkedListNode findNth2LastElement(LinkedListNode head, int n) {
		if (head == null || n <= 0)
			return null;

		// ���㳤��
		int m = 0;
		LinkedListNode chead = head;
		while (chead != null) {
			m++;
			chead = chead.next;
		}

		if (n > m)
			return null;

		// �������� m - n + 1
		int k = m - n + 1;
		chead = head;
		while (k-- > 0) {
			chead = chead.next;
		}

		return chead;
	}
}
