package com.felix.leecode;

/**
 * @author felix
 * @date 2021-05-20 16:20
 */
public class Lee055 {
    public static void main(String[] args) {
        int [] nums={3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        return jump(nums,0);
//        return false;
    }
    public static boolean jump(int[] nums,int start){
        int length=nums.length;
        if (nums[start]==0&&length!=1){
            return false;
        }
        if (start+nums[start]>=length-1){
            return true;
        }else {
            int max=Integer.MIN_VALUE;
            int newstart=start;
            for (int i = 0; i <nums[start] ; i++) {
                if (max<i+1+nums[i+start+1]){
                    max=i+1+nums[i+start+1];
                    newstart=i+start+1;
                }
            }
            return jump(nums,newstart);
        }
    }
}
