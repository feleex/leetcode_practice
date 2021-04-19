package com.felix.leecode;

import java.util.Arrays;

/**
 * @author felix
 * @date 2021-04-19 09:34
 */
public class Lee012 {
    /**
     * 罗马数字数组
     */
    public static char[] chars={'I','V','X','L','C','D','M'};
    public static void main(String[] args) {
        int a=1994;
        System.out.println(func(a));
//        StringBuffer sb=new StringBuffer();
//        System.out.println(sb.append('o').append('o'));
    }
    public static String func(int num){
        char[] nchar=String.valueOf(num).toCharArray();
        StringBuffer sb=new StringBuffer();
        int flag=nchar.length-1;
        for (int i = 0; i <nchar.length ; i++) {
            if (nchar[i]<'4'){
                int times=nchar[i]-'0';
                for (int j = 0; j <times ; j++) {
                    sb.append(chars[flag*2]);
                }
            }else if(nchar[i]=='4'){
                sb.append(chars[flag*2]).append(chars[flag*2+1]);
            }else if(nchar[i]=='5'){
                sb.append(chars[flag*2+1]);
            }else if(nchar[i]<'8'){
                sb.append(chars[flag*2+1]);
                int times=nchar[i]-'5';
                for (int j = 0; j <times ; j++) {
                    sb.append(chars[flag*2]);
                }
            }else{
                sb.append(chars[flag*2]).append(chars[flag*2+2]);
            }
            flag--;
        }
        return sb.toString();
    }

}
