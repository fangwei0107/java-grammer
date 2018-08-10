package com.chinawyny.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreak1 {

    public boolean wordBreak(String s, Set<String> dict, HashMap<String, Boolean> map) {

        if (map.containsKey(s)) {
            return map.get(s);
        }

        if (s.length() == 0) {
            return true;
        }

        boolean res = false;
        for (String dictVal : dict) {
            if (s.startsWith(dictVal)) {
                res = wordBreak(s.substring(dictVal.length()), dict, map);
                if (res) {
                    break;
                }
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        WordBreak1 wordBreak1 = new WordBreak1();
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak1.wordBreak("leetcode1", dict, new HashMap<String, Boolean>()));
    }
}
