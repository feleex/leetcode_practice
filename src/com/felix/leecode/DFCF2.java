package com.felix.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author felix
 * @date 2021-04-21 20:48
 */
public class DFCF2 {
//    public  static int minsize=Integer.MAX_VALUE;
//    public  static String result="";
    public static void main(String[] args) {
        String a="ADOBECODEBANC",b="ABC";
        System.out.println(minWindow(a, b));
    }
    public static  String minWindow (String a, String b) {
        // write code here
        int minsize=Integer.MAX_VALUE;
        String result="";

        char[] bchars = b.toCharArray();
        char[] achars = a.toCharArray();

        for (int i = 0; i <achars.length ; i++) {

            String tmp="";
            int times=0;
            List<Character> left=new ArrayList<>();
            for (int k = 0; k <bchars.length ; k++) {
                left.add(bchars[k]);
            }
            if (!left.contains(achars[i])){
                continue;
            }
            for (int j = i; j <achars.length ; j++) {
                if (left.size()==0){
                    break;
                }
                times++;
                tmp+=achars[j];
                if (left.contains(achars[j])){
                    left.remove((Character)achars[j]);
                }
            }
            if (times<minsize&&left.size()==0){
                minsize=times;
                result=tmp;
            }
        }

        return result;
    }
//    public static  String minWindow1 (String a, String b) {
//        // write code here
//        int minsize=Integer.MAX_VALUE;
//        char[] bchars = b.toCharArray();
//        char[] achars = a.toCharArray();
//        List<Character> left=new ArrayList<>();
//        for (int i = 0; i <bchars.length ; i++) {
//            left.add(bchars[i]);
//        }
//        back(0,new ArrayList<Character>(),left,achars,bchars);
//
//        return result;
//    }
//    public  static void back(int begin,List<Character> state,List<Character> left,char[] achars,char[] bchars){
//
//        for (int i = begin; i <achars.length ; i++) {
//
//            if (left.size()==0){
//                if (minsize>state.size()){
//                    result="";
//                    for (Character character : state) {
//                        result+=character;
//                    }
//                }
//                break;
//            }
//            state.add(achars[i]);
//            if (left.contains(achars[i])){
//                left.remove((Character) achars[i]);
//            }
//            List<Character> newleft=new ArrayList<>();
//            for (Character character : left) {
//                newleft.add(character);
//            }
//            back(i+1,state,newleft,achars,bchars);
//            state.remove((Character)achars[i]);
//
//        }
//
//    }
}
