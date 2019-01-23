package com.robert.dsal.math.probability.conversion;

import com.robert.design.looputil.LoopNumFactory;
import com.robert.design.looputil.LoopNumFactory.LoopNum;


/**
 * ˼·��
 * 
 * 1. ��֪�������ȸ��ʲ���0��1 2. ͨ������֪������1���Ծ��Ȳ���1��2 3. ͨ������֪��������2���Ծ��Ȳ���0��2
 * 
 * �ɵã�ͨ����3�����������������ʾ��ȵ�0,1,2
 *
 */
public class ProbConversionByOper1 implements ProbConversion {
    private LoopNum ln = LoopNumFactory.newSafeInst(0, 3);

    public int generate012(Random01 rndm01) {

        switch ((int) ln.next()) {
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
