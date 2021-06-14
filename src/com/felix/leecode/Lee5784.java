package com.felix.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author felix
 * @date 2021-06-13 10:36
 */
public class Lee5784 {
    public static boolean makeEqual(String[] words) {
        int times=words.length;
        Map<Character,Integer> timesmap=new HashMap<>();
        for (String word : words) {
            char[] chars=word.toCharArray();
            for (char aChar : chars) {
                timesmap.put(aChar,timesmap.getOrDefault(aChar,0)+1);
            }
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : timesmap.entrySet()) {
            if (characterIntegerEntry.getValue()%times!=0){
                return false;
            }
        }
        return true;
    }
}
