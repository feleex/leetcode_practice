package com.felix.leecode;

/**
 * @author felix
 * @date 2021-04-17 09:37
 */
public class Lee122 {
    public static void main(String[] args) {
        int[] ints={7,1,5,3,6,4};
        System.out.println(func(ints));

    }
    public  static int func(int[] prices){
        if (prices==null||prices.length==0){
            return 0;
        }
        int sumnum=0;
        int low=prices[0];
        int onesum=0;
        int tmphigh=prices[0];
        for (int i = 1; i <prices.length ; i++) {
            if (prices[i]>tmphigh){
                tmphigh=prices[i];
                onesum=prices[i]-low;
//开始走下坡路就截住卖出,更新新的最低值
            }else {
                sumnum+=onesum;
                onesum=0;
                low=prices[i];
                tmphigh=prices[i];
            }
        }
        sumnum+=tmphigh-low;
        return sumnum;
    }
}
