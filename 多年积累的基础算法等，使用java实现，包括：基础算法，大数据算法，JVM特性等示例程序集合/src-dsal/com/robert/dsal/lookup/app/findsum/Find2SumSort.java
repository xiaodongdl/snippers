package com.robert.dsal.lookup.app.findsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * �����ǰ��˫ָ���ƽ���ʱ�临�Ӷ�O(nlog2n), ��Ҫ��������
 * 
 */
public class Find2SumSort implements Find2Sum {
	public List<int[]> find2Sum(int[] nums, int sum) {
		Arrays.sort(nums);

		int i = 0;
		int j = nums.length - 1;

		List<int[]> result = new ArrayList<int[]>();
		while (i < j) {
			if (nums[i] + nums[j] == sum)
				result.add(new int[] { nums[i++], nums[j++] });
			else if (nums[i] + nums[j] > sum)
				j--;
			else
				i++;
		}

		return result;
	}
}
