package com.robert.dsal.math.app.seqsum;

// ʵ�ֺ�Ҫ����΢��Щ��ͬ���ܽᣬ����ÿ����Ŀ�ÿ���Ҫ����д�������Լ��ļ����ΪҪ��

/*
 Calculate the sum of N+NN+NNN+NNNN ... and there are total M N-sequence.
 Input is :N[SPACE]M
 Both M, N are positive integer. please output the sum

 Example1

 Input: 1 2
 then the sequence will be 1+11,
 Your output :12

 Example2

 Input: 2 3
 then the sequence will be 2+22+222,
 Your output :246
 */
public interface SeqSum {
	public int sumSeq(int num, int times);
}
