package com.robert.dsal.list.app.delrange;

import com.robert.dsal.list.ds.LinkedListNode;

/**
 * 
 * ��֪���Ա��е�Ԫ����ֵ�����������У����Ե��������洢�ṹ����дһ��Ч���㷨��ɾ����������ֵ����mink��С��maxk��Ԫ�أ������д���������Ԫ�أ���
 * ͬʱ�ͷű�ɾ���ռ䣬����������㷨��ʱ�临�Ӷȣ�ע�⣬mink��maxk�Ǹ����������α��������ǵ�ֵ���Ժͱ��е�Ԫ����ͬ��Ҳ���Բ�ͬ����
 * 
 */
public interface DeleteRange {
	LinkedListNode deleteRange(LinkedListNode head, int start, int end);
}
