package com.robert.cci.c02.q05;

/*
 k: ���ӱ�ͷ
 n: ����
 x: �����㵽��ͷ

 ��������ָ������k + (n - x)������ָ������k + (2n -x)������ָ��������ָ���2���Ĳ�����

 �����Ƶ���֪��x = n

 2(k + n - x) = k + 2n - x 

 2k + 2n - 2x = k + 2n - x

 k  = x

 */

public class SpotRingGapPointer implements SpotRing {

	public int spotRing(LinkedListNode head) {
		// ��������ߵ�Ԫ��������-1
		if (head == null || head.next == null)
			return -1;

		// ��Ԫ��ѭ��������0
		if (head == head.next)
			return 0;

		// ��ָ����һ������ָ����������ע���ʼ�����Ҳ�����������
		LinkedListNode slow = head.next;
		LinkedListNode fast = head.next.next;

		// slow != null������ģ���Ϊ��ָ��ʼ����ǰ��
		while (slow != null && fast != null && fast.next != null
				&& slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// ���жϲ��ȣ���������������β�ˣ������������Ƚ�����
		if (slow != fast)
			return -1;

		// ���㳤�ȣ��������㵽��ͷ��������ͷ����ͷ�ľ������
		int count = 0;
		while (head != slow) {
			count++;

			head = head.next;
			slow = slow.next;
		}

		return count;
	}

}
