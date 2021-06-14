package com.felix.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author felix
 * @date 2021-06-13 10:45
 */
public class Lee5786 {
    public static void main(String[] args) {
       String  s = "abcacb", p = "ab";
        int []removable = {3,1,0};
        System.out.println(maximumRemovals(s, p, removable));
    }
    public static int maximumRemovals(String s, String p, int[] removable) {
        Map<Character,Integer> dictmap=new HashMap<>();
        Map<Character,Integer> destmap=new HashMap<>();
        char[] chars=s.toCharArray();
        for (char aChar : chars) {
            dictmap.put(aChar,dictmap.getOrDefault(aChar,0)+1);
        }
        for (char aChar : p.toCharArray()) {
            destmap.put(aChar,destmap.getOrDefault(aChar,0)+1);
        }
        int result=0;
        char tmp=  s.charAt(removable[result]);
        while (dictmap.get(tmp)>destmap.getOrDefault(tmp,0)){
            dictmap.put(tmp,dictmap.get(tmp)-1);
            result++;
            tmp=s.charAt(removable[result]);
        }
        return result;
    }
}
