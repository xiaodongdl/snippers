package com.robert.cci.c19.q06;

import java.util.Arrays;

/**
 * 
 * ���ֲ���Ӣ���ʵ�Ƚ����룬���˸�λ��������ʮ��ǧ��Ȼ����һ����ξ��������
 * 
 * 1. ͨ������ڰ���4λ�ֳ�һ�� 
 * 2. ����ÿһ����и���ʮǧ���촮 
 * 3. Ȼ�󽫲�ͬ�ķ��������������ʾ
 * 
 */
public class Num2StringChinese implements Num2String {
	static final String zero = "��";

	static final String[] lighter = { "", "һ", "��", "��", "��", "��", "��", "��",
			"��", "��" };

	static final String[] weighter = { "", "ʮ", "��", "ǧ" };

	static final String[] more = { "", "��", "��" };

	public String convert(int num) {
		int[] wans = spit(num);

		StringBuilder sb = new StringBuilder();
		for (int i = wans.length - 1; i >= 0; i--) {
			sb.append(convertWan(wans[i]) + more[i]);
		}

		return trim(sb.toString());
	}

	private int[] spit(int num) {
		int[] results = new int[Integer.MAX_VALUE / 10000];
		int index = 0;

		while (num > 0) {
			results[index++] = num % 10000;

			num = num / 10000;
		}

		return Arrays.copyOf(results, index);
	}

	private String trim(String src) {
		StringBuilder sb = new StringBuilder(src);
		while (sb.charAt(0) == '��')
			sb.delete(0, 1);

		while (sb.charAt(sb.length() - 1) == '��')
			sb.delete(sb.length() - 1, sb.length());

		for (int i = 0; i < sb.length() - 1; i++) {
			if (sb.charAt(i) == sb.charAt(i + 1) && sb.charAt(i) == '��') {
				sb.delete(i, i + 1);
				i--;
			}

		}
		return sb.toString();
	}

	private String convertWan(int num) {
		StringBuilder sb = new StringBuilder();

		sb.append(convertWeighter(num / 1000, 3)); // ǧ
		sb.append(convertWeighter(num / 100 % 10, 2)); // ��
		sb.append(convertWeighter(num / 10 % 10, 1)); // ʮ
		sb.append(convertLighter(num % 10)); // ��

		return sb.toString();
	}

	public String convertLighter(int num) {
		return lighter[num];
	}

	public String convertWeighter(int num, int weight) {
		if (num == 0)
			return "��";

		return lighter[num] + weighter[weight];
	}
}
