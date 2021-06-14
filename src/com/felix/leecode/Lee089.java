package com.felix.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author felix
 * @date 2021-06-13 10:17
 */
public class Lee089 {
    public static void main(String[] args) {
        System.out.println(quickgrayCode(2));
    }
    public static List<Integer> grayCode(int n) {
        List<Integer> result=new ArrayList<>();
        if (n==0){
            result.add(0);
            return result;
        }
         result=grayCode(n-1);
        int extendssize=(int)Math.pow(2,n-1);
        for (int i = 0; i <extendssize ; i++) {
            result.add(result.get(extendssize-i-1)+(1<<n-1));
        }
        return result;
    }
    public static List<Integer> quickgrayCode(int n) {
        List<List<Integer>> sumlist=new ArrayList<>();
        List<Integer> zerolist=new ArrayList<>();
        zerolist.add(0);
        sumlist.add(zerolist);
        for (int i = 1; i <=n ; i++) {
            List<Integer> tmplist=new ArrayList<>();
            tmplist.addAll(sumlist.get(i-1));
            int extendssize=(int)Math.pow(2,i-1);
            for (int j = 0; j <extendssize ; j++) {
                tmplist.add(tmplist.get(extendssize-j-1)+(1<<i-1));
            }
            sumlist.add(tmplist);
        }

        return sumlist.get(n);
    }
}
