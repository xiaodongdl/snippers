package com.robert.dsal.string.anagram.finder;

/**
 * 
 * ��һ�����������ҵ�ĳ��Ŀ���ַ�����ͬλ�ʣ�������˳������ͬ�ַ��ĵ��ʳ�Ϊͬλ��, Ҳ���˳�Ϊ�ֵܵ��ʣ�����army��mary��
 * 
 * @author Robert
 *
 */
public interface AnagramsFinder {
    public String[] findAnagrams(String[] src, String target);
}
