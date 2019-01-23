package com.robert.dsal.list.app.delrange;

import com.robert.dsal.list.ds.LinkedListNode;

/**
 * 
 * O(n)
 * 
 */
public class DeleteRangeImpl implements DeleteRange {
	public LinkedListNode deleteRange(LinkedListNode head, int start, int end) {
		if (start > end)
			return head;

		if (head == null)
			return null;

		// ֻ��һ��Ԫ������Ҫɾ��
		if (head.next == null && start < head.value && end > head.value) {
			return null;
		}

		LinkedListNode left = null;
		LinkedListNode right = null;

		LinkedListNode prev = null;
		LinkedListNode t = head;
		while (t != null) {
			// �ҵ���Ԫ�ص�ǰһ��Ԫ��
			if (start <= t.value)
				left = prev;

			// �ҵ���Ԫ�ص���һ��Ԫ��
			if (end < t.value)
				right = t;
			else if (end == t.value)
				right = t.next;

			// ˫ָ����ǰ�ƶ�
			prev = t;
			t = t.next;
		}

		// ���Ҷ�Ϊ�գ�������������Ҫɾ��
		if (left == null && right == null)
			return null;

		// �����Ԫ���ǿգ���Ԫ�ز�Ϊ��
		if (left == null)
			head = right;

		// �����Ԫ���ǿգ���Ԫ�ز��ǿ�
		if (right == null)
			left.next = null;

		// �������Ԫ�ض���Ϊ��
		left.next = right;

		return head;
	}
}
