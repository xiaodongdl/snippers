package com.robert.dsal.string.anagram;

public class AnagramBitOper implements Anagram {
	public boolean isAnagramPalindrome(char[] str) {
		int bits = 0;

		for (int i = 0; i < str.length; i++) {
			int cha = str[i];
			int index = cha - 'a';

			// �����õ���0���߲�����0�жϣ������õ���1�Ͳ�����1�ж�
			if ((bits & (1 << index)) == 0) {
				bits |= 1 << index;
			} else {
				bits &= ~(1 << index);
			}
		}

		int count = 0;
		for (int i = 0; i < 26; i++) {
			if ((bits & (1 << i)) != 0)
				count++;
		}

		if (count == 0 || count == 1)
			return true;

		return false;
	}
}
