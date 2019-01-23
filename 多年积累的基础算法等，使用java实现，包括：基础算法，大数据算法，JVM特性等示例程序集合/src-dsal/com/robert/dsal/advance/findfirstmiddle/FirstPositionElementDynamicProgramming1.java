package com.robert.dsal.advance.findfirstmiddle;

/**
 * 
 * ���ʵ�ֺ�FirstPositionElementDynamicProgramming��һ���ģ����ǳ��������ĵ��ģ��������
 * 
 */
public class FirstPositionElementDynamicProgramming1 implements
		FirstPositionElementFinder {

	public int findFirstPositionElement(int[] seq) {
		// ��һ��Ԫ�س�ʼ��Ϊ���Ԫ�غ����Ԫ��
		int flag = 0;
		int max = seq[0];

		// ѭ����������Ԫ��
		for (int i = 1; i < seq.length; i++) {
			if (flag != -1) {
				// �б��Ԫ��
				if (seq[i] >= seq[flag])
					// ��ǰԪ�ش��ڵ��ڱ��Ԫ��
					max = seq[i];
				// ����Ҫ�ı���
				else
					// ��ǰԪ��С�ڱ��Ԫ�أ�����������ǰ��Ԫ��
					flag = -1;
				// ����Ҫ�ı����ֵ

			} else {
				// �ޱ��Ԫ�أ����ҳ���һ������ǰ���ֵ�����Ԫ�أ����³�ʼ��Ϊ���Ԫ��
				if (seq[i] >= max) {
					flag = i;
					max = seq[i];
				}
			}
		}

		return flag != -1 ? seq[flag] : -1;

	}
}
