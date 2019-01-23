package com.robert.dsal.math.probability.conversion;


/**
 * ˼·��
 * 
 * 1. ��֪�������ȸ��ʲ���0��1 2. ͨ������֪������1���Ծ��Ȳ���1��2 3. ͨ������֪��������2���Ծ��Ȳ���0��2
 * 
 * �ɵã�ͨ����3�����������������ʾ��ȵ�0,1,2
 *
 */
public class ProbConversionByOper implements ProbConversion {
    private int i = 0;

    public int generate012(Random01 rndm01) {
        if (i == 3) i = 0;

        switch (i++) {
            case 0:
                return rndm01.generate01();
            case 1:
                return rndm01.generate01() + 1;
            case 2:
                return rndm01.generate01() * 2;
        }

        return -1;
    }

}
