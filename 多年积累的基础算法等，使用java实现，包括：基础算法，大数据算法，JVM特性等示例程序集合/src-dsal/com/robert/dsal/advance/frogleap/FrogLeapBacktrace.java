package com.robert.dsal.advance.frogleap;

import java.util.Arrays;

/**
 * 
 * l^n, l����Ԫ�ص�ƽ����С��Ҳ��ƽ���������ȣ� �����л��ݣ�Ч�����
 * 
 */

public class FrogLeapBacktrace implements FrogLeap {

	public int[] fropLeap(int[] arrays) {
		int[] result = new int[arrays.length + 1];
		result[result.length - 1] = arrays.length;

		int[] buffer = new int[arrays.length + 1];
		buffer[buffer.length - 1] = 0;

		fropLeap(result, buffer, arrays, 0);

		return Arrays.copyOf(result, result[result.length - 1]);
	}

	private void fropLeap(int[] result, int[] buffer, int[] arrays, int index) {
		if (index >= arrays.length - 1) {
			if (buffer[buffer.length - 1] < result[result.length - 1]) {
				copyResult(result, buffer);
				result[result[result.length - 1]++] = arrays.length - 1;
			}
			return;
		}

		// ����Ѿ��߹��Ĳ���ȵ�ǰ��û������Ǿͻ���
		if (buffer[buffer.length - 1] > result[result.length - 1])
			return;

		// ��ĿҪ��Ļ���
		if (arrays[index] == 0)
			return;

		buffer[buffer[buffer.length - 1]++] = index;

		// �ݹ��ѭ����ʵ��һ��nԪ��������ÿ����Ҷ�ӽڵ㶼��һ��״̬��ÿ��Ҷ�ӽڵ㶼��һ������յ�״̬����������жϴӸ���Ҷ�ӽڵ�ĸ���״̬�Ƿ��������Լ������
		for (int i = 1; i <= arrays[index]; i++) {
			fropLeap(result, buffer, arrays, index + i);
		}

		buffer[buffer.length - 1]--;
	}

	private void copyResult(int[] result, int[] buffer) {
		for (int i = 0; i < buffer[buffer.length - 1]; i++)
			result[i] = buffer[i];

		result[result.length - 1] = buffer[buffer.length - 1];
	}

}
