package com.robert.dsal.advance.findfirstmiddle;

/**
 * 
 * ����һ������A,���ĳ���ΪL�� �ҳ�һ������������Ԫ�أ����������±���P�� ����0<=P<=L�� ���������T��R�±���˵�� 0<=T<=p<=R<=L,
 * A[T] < A[p] ���� A[P] <= A[R]
 * 
 */

public interface FirstPositionElementFinder {
	public int findFirstPositionElement(int[] seq);
}
