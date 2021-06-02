package com.felix.leecode;

/**
 * @author felix
 * @date 2021-06-02 10:02
 */
public class Lee045 {
    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public static  int jump(int[] nums) {
        if (nums.length==1){
            return 0;
        }
        return  jumpfrom(nums,0);
    }
    public  static int jumpfrom(int[] nums , int index){
        int value=nums[index];
        if (value>=nums.length-index-1){
            return 1;
        }else {
            int nextindex=index;
            int tmp_longest=nums[index]+index+1;
            int end=tmp_longest;
            for (int i = index+1; i <end ; i++) {
                if (nums[i]+i+1>tmp_longest){
                    nextindex=i;
                    tmp_longest=nums[i]+i+1;
                }
            }
            return jumpfrom(nums,nextindex)+1;
        }

    }
}
