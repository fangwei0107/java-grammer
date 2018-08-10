package com.chinawyny.algorithm;

import java.util.*;

public class Temp {

    public ArrayList<String> run(String s, Set<String> dict, HashMap<String, ArrayList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        ArrayList<String> res = new ArrayList<>();
        if (s.length() <= 0) {
            res.add("");
            return res;
        }
        for (String dicVal : dict) {
            if (s.startsWith(dicVal)) {
                for (String str : run(s.substring(dicVal.length()), dict, map)) {
                    res.add(dicVal + ("".equals(str) ? "" : " ") + str);
                }
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        Temp dynamicProgram = new Temp();
        Set<String> dict = new HashSet<>();
        String[] arr = new String[] {"cat", "cats", "and", "sand", "dog"};
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        System.out.println(dynamicProgram.run("catsanddog", dict, new HashMap<>()));
    }

}
