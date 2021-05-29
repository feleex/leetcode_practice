package com.felix.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author felix
 * @date 2021-05-29 22:06
 */
public class Lee033 {
    public static void main(String[] args) {
        int [] nums={4,5,6,7,0,1,2};
        System.out.println(search(nums, 3));
    }
    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i]==target){
                return i;
            }
        }

        return  -1;
    }
}
