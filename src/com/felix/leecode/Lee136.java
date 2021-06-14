package com.felix.leecode;

/**
 * @author felix
 * @date 2021-06-14 16:35
 */
public class Lee136 {
    public static void main(String[] args) {
        int[] nums={4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        int result=0;
        for (int num : nums) {
            result=result^num;
        }
        return result;
    }
}
