package com.robert.dsal.lookup.classic;

/**
 * �㷨���ƣ�
 * 
 * �ֿ���һ�������˳������
 * 
 * �㷨������
 * 
 * �ֿ�����ֳ�����˳����ң�����˳����ҵ�һ�ָĽ���������n������Ԫ�ء��������򡱻���Ϊm�飨m<=n���� ÿһ���е�����Ԫ�ز�������
 * ���������֮����롰�������򡱣�����1���е���һԪ�صĹؼ��ֶ�����С�ڵ�2������һԪ�صĹؼ��֣�����2������һԪ���ֶ�С�ڵ�3���е���һԪ�أ�����
 * 
 * ʱ�临�Ӷȣ�
 * 
 * �㷨���ӶȽ���˳����ҺͶ��ֲ���֮��
 */
public class IndexSequenceTableLookup extends AbstractLookup {
	private IndexTableItem[] items;
			
	class IndexTableItem {
		int maxValue;
		int firstIndex;
	}
	
	public IndexSequenceTableLookup(int shardNum) {
		int ceilShardNum = (int)Math.pow(2, Math.floor(Math.log10(15) / Math.log10(2)) + 1);
		this.items = new IndexTableItem[ceilShardNum];   
	}
	
	public static void main(String[] args) {
		System.out.println();
		
		System.out.println(Math.log1p(0.1));
		System.out.println(Math.log(0.1 + 1));
	}
	
	public void setup(int[] seq) {
		super.setup(seq);
		
		constructIndexTable(seq);
	}
	
	private void constructIndexTable(int[] seq) {
		
	}

	@Override
	public int lookup(int t) {
		for (int i = 0; i < seq.length; i++)
			if (seq[i] == t)
				return i;
		
		return -1;
	}
}
