package com.robert.cci.c05.q07;

// TODO Can't understand the description in cci

/**
 0000
 0001
 0010
 0011
 0100
 0101
 0110
 0111
 1000
 1001
 1010
 1011
 1100
 1101
 1110

 ��һ�ж����ư���010101�ظ�
 ��һ�ж����ư���00110011�ظ�
 ��һ�ж����ư���0000111100001111�ظ�
 ��һ�ж����ư���00000000111111110000000011111111�ظ�

 factor = 2;
 factor *= column_num;

 rep = n / factor;
 remain = n % factor;

 oddNum = evenNum = rep / 2;
 if (remain <= factor/2)
 even += remain;
 if (remain >= factor/2) {
 even += factor/2;
 odd += (remain - factor/2);
 }

 Ȼ��ͳ��ȱ������������ż����ȱ������Ŀ�����ֵĴ�λΪ1��ȱż����Ŀ�����ִ�λΪ0, ����ÿһλȷ��һ�Σ��������ȷ��ȱ�ٵ��Ǹ�ֵ

 */

/**
 * 
 * An array A[1... n] contains all the integers from 0 to n except for one
 * number which is missing. In this problem, we cannot access an entire integer
 * in A with a single operation. The elements of A are represented in binary,
 * and the only operation we can use to access them is ��fetch the jth bit of
 * A[i]��, which takes constant time. Write code to find the missing integer. Can
 * you do it in O(n) time?
 * 
 */
public interface MissingFinder {

}
