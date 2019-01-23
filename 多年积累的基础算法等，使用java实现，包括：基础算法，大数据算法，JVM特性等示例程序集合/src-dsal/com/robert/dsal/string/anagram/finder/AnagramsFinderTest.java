package com.robert.dsal.string.anagram.finder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramsFinderTest {
    public String[] findAnagrams(String[] src, String target) {
        HashMap<String, List<String>> hm = constructHash(src);
        
        char[]  targetWord = target.toCharArray();
        Arrays.sort(targetWord);
        String sTargetWord = new String(targetWord);

        if (hm.containsKey(sTargetWord)) {
            // ���������ͬλ�ʣ��򷵻�ͬλ���б�
            return hm.get(sTargetWord).toArray(new String[0]);
        }

        // ������������򷵻ؿ�
        return null;
    }

    private HashMap<String, List<String>> constructHash(String[] src) {
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>();

        // ����ͬλ��hash��
        for (int i = 0; i < src.length; i++) {
            char[] word = src[i].toCharArray();
            Arrays.sort(word);
            String sWord = new String(word);

            if (hm.containsKey(sWord)) {
                List<String> anagrams = hm.get(sWord);
                anagrams.add(src[i]);
            } else {
                List<String> anagrams = new ArrayList<String>();
                hm.put(sWord, anagrams);
            }
        }

        return hm;
    }
}
