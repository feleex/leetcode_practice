package com.felix.leecode;

import com.sun.org.apache.xml.internal.utils.StringBufferPool;

import java.util.*;

/**
 * @author felix
 * @date 2021-04-19 16:40
 */
public class Lee017 {
    static Map<Character, char[]> dictmap=new HashMap<>();
    static {
        dictmap.put('2', new char[]{'a', 'b', 'c'});
        dictmap.put('3', new char[]{'d', 'e', 'f'});
        dictmap.put('4', new char[]{'g', 'h', 'i'});
        dictmap.put('5', new char[]{'j', 'k', 'l'});
        dictmap.put('6', new char[]{'m', 'n', 'o'});
        dictmap.put('7', new char[]{'p', 'q', 'r','s'});
        dictmap.put('8', new char[]{'t', 'u', 'v'});
        dictmap.put('9', new char[]{'w', 'x', 'y','z'});
    }

    public static void main(String[] args) {
        String digits = "22";
        System.out.println(digui(digits));
        System.out.println(letterCombinations(digits));
    }
    public static List<String> letterCombinations(String digits){
        List<String> list = digui(digits);
        List<String> result=new ArrayList<>();
        Set<String> input=new HashSet<>();
        for (String s : list) {
            input.add(s);
        }
        for (String s : input) {
            result.add(s);
        }
        return result;

    }
    public static List<String> digui(String digits) {
        List<String> result=new ArrayList<>();
        if (digits.length()==0){
            return result;
        }else if (digits.length()==1){
            char[] chars = digits.toCharArray();
            char[] chars1 = dictmap.get(chars[0]);
            for (char c : chars1) {
                result.add(String.valueOf(c));
            }
            return result;
        }

        char[] chars = digits.toCharArray();
        char[] des_chars=new char[chars.length-1];
        char last_char=chars[chars.length-1];
        System.arraycopy(chars,0,des_chars,0,chars.length-1);
        String des_string = new String(des_chars);
        List<String> stringList = digui(des_string);
        for (int i = 0; i < stringList.size(); i++) {

            char[] chars1 = dictmap.get(last_char);
            for (char c : chars1) {
                StringBuffer sb=new StringBuffer(stringList.get(i));
                sb.append(c);
                result.add(sb.toString());
            }

        }
        return result;
    }
}
