package com.robert.dsal.math.app.findprime;

import java.util.ArrayList;
import java.util.List;

import com.robert.dsal.util.CollectionUtil;

/**
 * 
 * <b>ʱ�临�Ӷȣ�</b><br>
 * O(n^2)<br>
 * <p>
 * ��1��ִ��0��<br>
 * ��2��ִ��1��<br>
 * ��3��ִ��3��<br>
 * ........<br>
 * ��n��ִ��n - 1��<br>
 * 0 + 1 + 2 + 3 + ��n - 1�� = n*(n-1)/2
 * 
 */
public class PrimeFinderImpl implements PrimeFinder {
	public int[] findPrime(int n) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++)
				if (i % j == 0)
					isPrime = false;
			if (isPrime)
				result.add(i);
		}

		return CollectionUtil.convert(result);
	}

}
