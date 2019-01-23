package com.robert.dsal.lookup.classic;

/**
 * �㷨���ƣ�
 * 
 * ˳�����
 * 
 * �㷨������
 * 
 * ���������е�Ԫ�ش�ǰ����������Աȣ�ֱ���ҵ����Ԫ�أ����ߵ�������β����
 * 
 * ʱ�临�Ӷȣ�
 * 
 * O(N)
 */
public class SequenceLookup extends AbstractLookup {

	@Override
	public int lookup(int t) {
		for (int i = 0; i < seq.length; i++)
			if (seq[i] == t)
				return i;
		return -1;
	}

}
