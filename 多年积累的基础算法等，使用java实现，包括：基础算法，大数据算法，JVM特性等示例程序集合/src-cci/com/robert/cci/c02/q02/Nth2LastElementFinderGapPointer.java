package com.robert.cci.c02.q02;

/**
 * 
 * ��ѽⷨ��ȡ����ָ�룬һ��ָ���ͷ������һ������n-1�ľ��룬Ȼ��ͬʱ����β�ߣ�ǰ��ָ�뵽���β�������ָ����ǵ�����n��Ԫ�ء�
 * 
 * �ʱ�临�Ӷȣ�O(n)
 * 
 */
public class Nth2LastElementFinderGapPointer implements Nth2LastElementFinder {

	public LinkedListNode findNth2LastElement(LinkedListNode head, int n) {
		if (head == null || n <= 0)
			return null;

		// ������һ����������n��Ԫ��֮�������n-1,���ԣ���fast��head���n-1�ľ���
		LinkedListNode fast = head;
		for (int i = 0; i < n - 1; i++) {
			fast = fast.next;
			if (fast == null)
				return null;
		}

		// һֱ�ߵ���β
		while (fast.next != null) {
			head = head.next;
			fast = fast.next;
		}

		return head;
	}

}
