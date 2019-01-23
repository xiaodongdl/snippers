package com.robert.dsal.advance.frogleap;

import java.util.Arrays;

/**
 * 
 * l^n, l����Ԫ�ص�ƽ����С��Ҳ��ƽ����������
 * 
 */
public class FrogLeapBruteForce implements FrogLeap {

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

		// ��ĿҪ��Ļ��ݣ����ǻ��ݷ�����Ļ���
		if (arrays[index] == 0)
			return;

		buffer[buffer[buffer.length - 1]++] = index;

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
