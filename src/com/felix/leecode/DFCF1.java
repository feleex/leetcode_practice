package com.felix.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author felix
 * @date 2021-04-21 20:45
 */
public class DFCF1 {
    public static void main(String[] args) {
        String s="1737";
        System.out.println(numberOfArrays(s, 1, 100));
    }
    public static int numberOfArrays (String s, int k, int m) {
        // write code here
        int result=0;
        List<List<String>> res=new ArrayList<>();
        char[] chars = s.toCharArray();
        List<Integer> list=new ArrayList<>();
        for (char aChar : chars) {
            list.add(Integer.valueOf(String.valueOf(aChar)));
        }
//        back(k,m,chars,new ArrayList<String>(),res);
        lowback(k,m,s,new ArrayList<String>(),res);

        return res.size();
    }
    public static  void back(int k,int m,char[] leftchars,List<String> state,List<List<String>> res){
        if (leftchars.length==0){
            res.add(state);
            return;
        }
        for (int i = 0; i <leftchars.length ; i++) {
            char[] newchars=new char[i+1];
            System.arraycopy(leftchars,0,newchars,0,i+1);
            String s = new String(newchars);
            if (Integer.valueOf(s)>m){
                break;
            }else if (Integer.valueOf(s)>=k){
                state.add(s);
                char[] newleftchars=new char[leftchars.length-1-i];
                System.arraycopy(leftchars,i+1,newleftchars,0,i+1);
                back(k,m,newleftchars,state,res);
            }

        }
    }
    public static  void lowback(int k,int m,String leftString,List<String> state,List<List<String>> res){
        if (leftString.length()==0){
            res.add(state);
            return;
        }
        int length=leftString.length();
        for (int i = 0; i <length ; i++) {

            String s = leftString.substring(0,i+1);
            if (Integer.valueOf(s)>m){
                break;
            }else if (Integer.valueOf(s)>=k){
                state.add(s);
                String newleftString=leftString.substring(i+1);
                lowback(k,m,newleftString,state,res);
            }

        }
    }
}
