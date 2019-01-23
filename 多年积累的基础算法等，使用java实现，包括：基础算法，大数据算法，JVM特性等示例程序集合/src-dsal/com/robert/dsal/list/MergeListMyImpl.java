package com.robert.dsal.list;

import com.robert.dsal.list.ds.LinkedListNode;

public class MergeListMyImpl implements MergeList {
	public LinkedListNode mergeList(LinkedListNode m, LinkedListNode n) {
		
		// ����m�����n��ĳһ���Ƚ�С������뵽m����
		LinkedListNode p = null, t = null;
		LinkedListNode i = m;
		LinkedListNode j = n;
		while (i != null && j != null) {
			if (j.value > i.value) {
				p = i;
				i = i.next;
			} else {
				t = j.next;
				if (p == null) {
					j.next = i;
					m = j;

					i = j;
				} else {

					j.next = i;
					p.next = j;

					p = j;
				}
				j = t;
			}
		}
		if (j != null)
			p.next = j;
		return m;
	}
}
