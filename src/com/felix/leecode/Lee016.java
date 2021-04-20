package com.felix.leecode;

import java.util.Arrays;

/**
 * @author felix
 * @date 2021-04-19 16:19
 */
public class Lee016 {
    public static void main(String[] args) {
        int[] nums={-1,2,1,-4};
        int target=1;
        System.out.println(threeSumClosest(nums, target));
    }
   public static int threeSumClosest(int[] nums, int target){
        if (nums==null||nums.length<3){
            return 0;
        }
       Arrays.sort(nums);
       int distance=Integer.MAX_VALUE;
       int result=Integer.MAX_VALUE;
       for (int i = 0; i < nums.length-2; i++) {
           if (i>0){
               if (nums[i]==nums[i-1]){
                   continue;
               }
           }
           int low_index=i+1;
           int high_index=nums.length-1;
           while (low_index<high_index){
               int tmp=nums[i]+nums[low_index]+nums[high_index]-target;
               if (Math.abs(tmp)<distance){
                   distance=Math.abs(tmp);
                   result=target+tmp;
               }
               if (tmp==0){
                   return target;
               }else if (tmp>0){
                   while (low_index<--high_index&&nums[high_index+1]==nums[high_index]){
                       continue;
                   }
               }else {
                   while (++low_index<high_index&&nums[low_index-1]==nums[low_index]){
                       continue;
                   }
               }
           }

       }
       return result;
   }
}
