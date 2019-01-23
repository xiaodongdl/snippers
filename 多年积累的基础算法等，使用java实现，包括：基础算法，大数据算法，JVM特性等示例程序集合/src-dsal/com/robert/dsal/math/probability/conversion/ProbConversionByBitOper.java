package com.robert.dsal.math.probability.conversion;

/**
 * 
 * ˼·��
 * 
 * 1. ��֪���ȸ��ʲ���0��1,�����뵽λ���� 
 * 2. ͨ��λ�������Բ���0-15��16�����֣����Ҹ������ 
 * 3. 3�ı�����15, ���ԣ�Ӧ���������е�һ������15��ʣ��һ��0-14��15������
 * 
 * �ɵã��ٳ�3ȡģ�ɵþ��ȵ�0,1,2
 *
 */

public class ProbConversionByBitOper implements ProbConversion {
    public int generate012(Random01 rndm01) {
        int i = 0;

        // ����0-F 16�����֣�ȥ��15, ����0-14��15�����֣�ÿ�����ֵļ����Ǿ��ȵģ���Ϊÿ��λ����0��1�ĸ��ʶ���50%
        while ((i = ((rndm01.generate01() << 3) + (rndm01.generate01() << 2) + (rndm01.generate01() << 1) + rndm01.generate01())) == 15);

        // Ȼ�����3�Ͳ������ȵ�0,1,2
        return i % 3;
    }
}
