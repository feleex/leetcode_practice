package com.felix.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author felix
 * @date 2021-04-08 15:23
 */
public class Lee006 {
    public static void main(String[] args) {
        System.out.println(function("PAYPALISHIRING", 3));
    }
    public static String function(String s,int numRows){
        List<List<Character>> list=new ArrayList<>();
        for (int i = 0; i <numRows ; i++) {
            list.add(new ArrayList<>());
        }
        char[] chars = s.toCharArray();
        int size=numRows*2-2;
        if (size==0){
            return s;
        }
        for (int i = 0; i < chars.length; i++) {
            int mod=i%size;
            if (mod<numRows){
                list.get(mod).add(chars[i]);
            }else {
                list.get(size-mod).add(chars[i]);
            }
        }
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i <list.size() ; i++) {
            for (int j = 0; j <list.get(i).size() ; j++) {
                sb.append(list.get(i).get(j));
            }
        }
        return sb.toString();

    }
}
