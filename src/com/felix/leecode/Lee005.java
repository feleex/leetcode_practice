package com.felix.leecode;
//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。

import java.util.Arrays;

/**
 * @author felix
 * @date 2021-03-27 12:04
 */
public class Lee005 {
    public static void main(String[] args) {
//        System.out.println(longestPalindrome("abcbaaa"));
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {

        String shuzi=String.valueOf(x);
        String jueduizhi="";
        String flag="";
        boolean iszheng=true;
        if (shuzi.contains("-")){
            jueduizhi=shuzi.substring(1);
            iszheng=false;
            flag="-";
        }else {
            jueduizhi=shuzi;
        }

        char[] shuziarray=jueduizhi.toCharArray();
        int length=shuziarray.length;
        char[] reverse_shuziarray=new char[length];
        for (int i = 0; i < length; i++) {
            reverse_shuziarray[length-i-1]=shuziarray[i];
        }
        Long reverse_num=Long.valueOf(flag+ String.valueOf(reverse_shuziarray));
        if (reverse_num>Integer.MAX_VALUE|reverse_num<Integer.MIN_VALUE){
            return 0;

        }else{
            return Integer.valueOf(reverse_num.toString());
        }


    }
    public static String longestPalindrome(String s) {
        int length=s.length();
        char[] schars=s.toCharArray();

        boolean dp[][]=new boolean[length][length];
        String result="";
        for (int p = 0; p <length ; p++) {
            for (int i = 0; i +p<length ; i++) {
                int j=i+p;
                if (p==0){
                    dp[i][j]=true;
                }else if(p==1){
                    dp[i][j]=(schars[i]==schars[j]);
                }else{
                    dp[i][j]=dp[i+1][j-1]&&(schars[i]==schars[j]);
                }
                if (dp[i][j]&&p+1>result.length()){
                    result=s.substring(i,i+p+1);
                }


                }


            }
        return result;
        }


    }

