package com.robert.cci.c02.q02;

/**
 * 
 * �򵥽ⷨ�����ڵ�������ÿ��Ԫ�أ�����ӵ�ǰԪ������β�ߣ��߹�n-1��Ԫ�ص����β���򷵻ص�ǰԪ�ء�
 * 
 * ���ʱ�临�Ӷ�: O(n^2)
 * 
 */
public class Nth2LastElementFinderDualLoop implements Nth2LastElementFinder {

	public LinkedListNode findNth2LastElement(LinkedListNode head, int n) {
		if (head == null || n <= 0)
			return null;

		while (head != null) {
			LinkedListNode ihead = head;

			int count = 0;
			while (ihead.next != null) {
				ihead = ihead.next;
				count++;
			}
			if (count == n - 1)
				return head;

			head = head.next;
		}

		return null;
	}
}
