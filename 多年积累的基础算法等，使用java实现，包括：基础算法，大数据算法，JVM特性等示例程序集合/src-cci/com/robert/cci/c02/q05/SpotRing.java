package com.robert.cci.c02.q05;

/**
 * 
 * �ж�һ���������Ƿ����һ������������ڷ��ر�ͷ����ͷ�ĳ��ȡ�
 * 
 */
class LinkedListNode {
	int value;
	LinkedListNode next;

	LinkedListNode(int value, LinkedListNode next) {
		this.value = value;
		this.next = next;
	}
}

public interface SpotRing {
	int spotRing(LinkedListNode head);
}
