package com.robert.dsal.math.probability.conversion;

import java.util.Date;
import java.util.Random;

/**
 * 
 * ���ⶨ�壺��֪һ���������ȸ��ʲ���0��1,��ʵ��һ�������Ծ��ȸ��ʲ���0,1��2��
 *
 */
class Random01 {
    private Random rndm = new Random(new Date().getTime());

    public int generate01() {
        int r = rndm.nextInt();
        if (r < 0) r = -r;
        return r % 2;
    }
}


public interface ProbConversion {
    public int generate012(Random01 rndm01);
}
