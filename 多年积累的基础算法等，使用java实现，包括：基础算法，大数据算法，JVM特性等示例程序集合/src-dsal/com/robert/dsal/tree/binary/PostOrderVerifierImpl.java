package com.robert.dsal.tree.binary;

// TODO Still can't understand 
/**
 * 
 * ��Ŀ������һ���������飬�жϸ������ǲ���ĳ��Ԫ�������ĺ�������Ľ��������Ƿ���true�����򷵻�false��
 * ��������5��7��6��9��11��10��8��������һ�����������������ĺ�����������
 * 
 * 8 / \ 6 10 / \ / \ 5 7 9 11
 * 
 * ��˷���true��
 * 
 * �������7��4��6��5��û���Ŀ����ĺ�������Ľ����������У���˷���false��
 * 
 * ����������һ��trilogy�ı����⣬��Ҫ����Զ�Ԫ����������⡣
 * 
 * �ں��������õ��������У����һ��Ԫ��Ϊ���ĸ���㡣��ͷ��ʼɨ��������У��ȸ����С��Ԫ�ض�Ӧ��λ�����е���벿�֣�
 * �ӵ�һ�����ڸ���㿪ʼ�������ǰ���һ��Ԫ��Ϊֹ
 * ������Ԫ�ض�Ӧ�ô��ڸ���㣬��Ϊ�ⲿ��Ԫ�ض�Ӧ�������������������������Ļ��֣������л���Ϊ���������֣����ǵݹ��ȷ�����е���
 * �����������ǲ��Ƕ��Ƕ�Ԫ��������
 * 
 * N +2 * N/2 + 4*N/4 ... һ��LGN�� = O(nlogn)
 * 
 */

public class PostOrderVerifierImpl implements PostOrderVerifier {
	public boolean verifyPostOrder(int[] data, int start, int end) {
		int root = data[end];

		int i = start;
		while (data[i] < root)
			i++;

		for (int j = i; j < end; j++) {
			if (data[j] < root)
				return false;
		}

		if (start < i - 1) {
			boolean isLeft = verifyPostOrder(data, start, i - 1);
			if (!isLeft)
				return false;
		}

		if (i < end - 1) {
			boolean isRight = verifyPostOrder(data, i, end - 1);
			if (!isRight)
				return false;
		}

		return true;
	}

	public boolean verifyPostOrder(int[] data) {
		return verifyPostOrder(data, 0, data.length - 1);
	}
}
