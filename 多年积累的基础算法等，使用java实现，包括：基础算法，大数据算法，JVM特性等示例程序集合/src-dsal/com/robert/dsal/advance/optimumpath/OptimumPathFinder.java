package com.robert.dsal.advance.optimumpath;

/**
 * 
 * �Ӿ�������Ͻ������½��ߣ�ÿ��ֻ�����»���������һ����û�߹�һ��������һ��Ȩֵ����ô������Ȩֵ���
 * 
 * 1.������ 2.�ۼӺͷ�
 * 
 */

public interface OptimumPathFinder {
	public static class OptimumPath {
		public Point[] points;
		public int pathValue;
	}

	public OptimumPath findOptimumPath(int[][] matrix);
}
