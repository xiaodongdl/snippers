package com.robert.dsal.string.substrmatch;

/*
 * ��Դ���в���Ŀ�괮����������򷵻�Ŀ�괮��Դ���еĿ�ʼ��������������ڷ���null����-1
 */
public interface SubstrMatcher {

	public int[] indexesOf(char[] source, char[] target);

	public int indexOf(char[] source, char[] target);

}
