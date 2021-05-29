package com.felix.leecode;

/**
 * @author felix
 * @date 2021-05-29 22:52
 */
public class Lee038 {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
    public static String sayint(String nstring) {
        StringBuffer sb=new StringBuffer();
        char[] nchars=nstring.toCharArray();
        char tmp=nchars[0];
        int tmpsize=1;
        for (int i = 1; i <nchars.length ; i++) {
           if (tmp==nchars[i]){
               tmpsize++;
           }else {
               sb.append(tmpsize).append(tmp);
               tmp=nchars[i];
               tmpsize=1;
           }
        }
        sb.append(tmpsize).append(tmp);
    return sb.toString();
    }
    public static String countAndSay(int n) {
        String result="1";

        for (int i = 1; i <n ; i++) {
            result=sayint(result);
        }
        return result;
    }
}
