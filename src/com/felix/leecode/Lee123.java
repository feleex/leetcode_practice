package com.felix.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author felix
 * @date 2021-04-17 10:05
 */
public class Lee123 {
    public static void main(String[] args) {
        int[] prices={3,3,5,0,0,3,1,4};
        System.out.println(func(prices));
    }
    public static int func(int[] prices){
        if (prices==null||prices.length==0)
        {
            return 0;
        }
        int result=0;
        List<Integer> startlist=new ArrayList<>();
        List<Integer> endlist=new ArrayList<>();
        int start=0,end=prices.length;
        startlist.add(start);
        int tmphigh=prices[0];
        int tmplow=prices[0];
        boolean flag=true;
        for (int i = 1; i < prices.length-1; i++) {
//            探查所有的v型位置
            if (prices[i-1]>prices[i]&&prices[i]<=prices[i+1]||prices[i-1]>=prices[i]&&prices[i]<prices[i+1]){
//                处理第一个数开始递减的情况,避免两个连续的起始点
                if (!flag){
                    startlist.add(start);
                    start=i;
                    flag=true;
                }

            }else if(prices[i-1]<prices[i]&&prices[i]>=prices[i+1]||prices[i-1]<=prices[i]&&prices[i]>prices[i+1]){
                if (flag){
                    end=i;
                    endlist.add(end);
                    flag=false;
                }
            }
        }
        if (flag){
            endlist.add(prices.length-1);
        }
        int lentgh=endlist.size();
        for (int i = 0; i < lentgh; i++) {
            int first=func(prices,0,endlist.get(i)+1);
            int second=func(prices,endlist.get(i),prices.length);
            result=Math.max(result,first+second);
        }
        return result;
    }
    public static int func(int[] prices,int start,int end ) {
        if (prices==null||prices.length==0||start>=end||start>=prices.length)
        {
            return 0;
        }
        int low=prices[start];
        int result=0;
        for (int i = start; i <end ; i++) {
            if (prices[i]>low){
                result=Math.max(result,prices[i]-low);
            }else {
                low=prices[i];
            }
        }
        return result;
    }
}
