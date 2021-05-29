package com.felix.leecode;

/**
 * @author felix
 * @date 2021-05-29 22:18
 */
public class CommonUtil {
    class objectarray<T extends Object>{

    }
    public static void printintarray(int [] intarray){
        StringBuffer sb=new StringBuffer();
        for (int i : intarray) {
            sb.append(i).append(",");
        }
        if (sb.length()!=0){
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.println(sb);
    }
    public static void printarray(Object[] array){
        StringBuffer sb=new StringBuffer();
        for (Object o : array) {
            sb.append(o.toString()).append(",");
        }
        System.out.println(sb);
    }
}
