package com.robert.dsal.lookup.app.minn;

/**
 * 
 * ������N+M������, ���ֵķ�ΧΪ1 ... N, ��ӡ�ظ���Ԫ��, Ҫ��O(M + N), �������ö���Ŀռ�
 * 
 */

public interface FindMInN {
	// �ӿڶ����У�����N+M��������ĳ��ȣ�����N��M����δ֪�����Բ����������
	int[] findMInN(int[] x);
}
