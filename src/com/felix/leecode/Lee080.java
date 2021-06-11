package com.felix.leecode;

import java.util.Iterator;

/**
 * @author felix
 * @date 2021-06-11 22:36
 */
public class Lee080 {
    public static void main(String[] args) {
        int[] nums={0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
        CommonUtil.printintarray(nums);
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int index=1;
        int tmp=nums[0];
        int times=1;
        for (int i = 1; i <nums.length ; i++) {
            if (times==1&&nums[i]==tmp){
                nums[index]=nums[i];
                index++;
                times++;
            }else if (times!=1&&nums[i]==tmp){
                nums[i-1]=nums[i];
            }else if (times!=1&&nums[i]!=tmp){
                tmp=nums[i];
                nums[index]=nums[i];
                index++;
                times=1;
            }else {
                tmp=nums[i];
                nums[index]=nums[i];
                index++;
            }

        }
        return index;
    }
}
