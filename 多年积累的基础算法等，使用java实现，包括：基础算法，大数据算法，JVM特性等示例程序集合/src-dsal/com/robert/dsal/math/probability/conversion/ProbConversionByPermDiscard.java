package com.robert.dsal.math.probability.conversion;

/**
 * 
 * ˼·��
 * 
 * ��֪���������Լ����õ�1/4��0, 1/4��2, ����2/4��1,��1����һ��0/1���ʣ�����ȥ��һ��ĸ��ʣ����1Ҳ��ʣ����1/4
 * 
 * �ɵã� ȥ����1/4��Ҫ�ٴν��еݹ����
 *
 */

public class ProbConversionByPermDiscard implements ProbConversion {
    public int generate012(Random01 rndm01) {
        // ��ӵõ�1/4��0, 1/4��2, ��2/4��1
        int r = rndm01.generate01() + rndm01.generate01();

        // 2/4��1
        if (r == 1) {
            int r1 = rndm01.generate01();
            // 1/4��1�������ҵݹ����
            if (r1 == 0) return generate012(rndm01);

            // 1/4��1����
            return r1;
        }

        // 1/4��0��1/4��2����
        return r;
    }
}
