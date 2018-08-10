package com.chinawyny.algorithm;

import org.apache.commons.lang.ArrayUtils;

import java.util.*;

public class DynamicProgram {

    private ArrayList<String> workBreak(String s, Set<String> workDict) {
        return DFS(s, workDict, new HashMap<String, ArrayList<String>>());
    }

    private ArrayList<String> DFS(String s, Set<String> workDict, HashMap<String, ArrayList<String>> map) {

        if (map.containsKey(s)) {
            return map.get(s);
        }

        ArrayList<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }

        for (String subStr : workDict) {
            if (s.startsWith(subStr)) {
                for (String str : DFS(s.substring(subStr.length()), workDict, map)) {
                    res.add(subStr + (str.equals("") ? "" : " ") + str);
                }
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        DynamicProgram dynamicProgram = new DynamicProgram();
        Set<String> dict = new HashSet<>();
        String[] arr = new String[] {"cat", "cats", "and", "sand", "dog"};
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        System.out.println(dynamicProgram.workBreak("catsanddog", dict));
    }
}
