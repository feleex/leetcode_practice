package com.felix.leecode;

import java.util.Arrays;

/**
 * @author felix
 * @date 2021-04-09 16:34
 */
public class Lee300 {
    public static void main(String[] args) {
        int[] nums={1,3,6,7,9,4,10,5,6};
        System.out.println(dpfunc(nums));
    }
    public  static int func(int[] nums){
        if (nums.length==1){
            return 1;
        }
        int result=0;
        int now=0;

        for (int i = 0; i <nums.length ; i++) {
            int tmpresult=1;
            now=nums[i];
            for (int j = i+1; j <nums.length ; j++) {
                if (nums[j]>now){
                    tmpresult++;
                    now=nums[j];
                }
            }
            result=Math.max(result,tmpresult);
        }
        return result;
    }
    public static int dpfunc(int[] nums){
        int result=0;
        int[] dp=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i]=1;
        }
        for (int i = 1; i <  nums.length; i++) {

            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
//                dp[i]=Math.max(dp[i],dp[j]);
            }
        }
        System.out.println(Arrays.toString(dp));
        for (int i = 0; i < dp.length; i++) {
            result=Math.max(result,dp[i]);
        }
        return result;

    }
}
