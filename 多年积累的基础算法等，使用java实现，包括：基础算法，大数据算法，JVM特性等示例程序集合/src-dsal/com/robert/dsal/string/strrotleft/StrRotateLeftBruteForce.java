package com.robert.dsal.string.strrotleft;

/**
 * 
 * ռ��O(size)�Ŀռ�
 * 
 */
public class StrRotateLeftBruteForce implements StrRotateLeft {
	public void rotateLeft(char[] source, int size) {
		char[] temp = new char[size];

		for (int i = 0; i < size; i++) {
			temp[i] = source[i];
		}

		for (int i = size; i < source.length; i++) {
			source[i - size] = source[i];
		}

		for (int i = 0; i < size; i++) {
			source[source.length - size + i] = temp[i];
		}
	}

}
