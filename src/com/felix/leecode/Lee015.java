package com.felix.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author felix
 * @date 2021-04-19 15:20
 */
public class Lee015 {
    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
//        int[] nums={0,0,0};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        if (nums==null||nums.length<3){
            return result;
        }
//先排序，第一个数采用遍历的方式，剩下两个数采用双指针，调整大小
//如果第一个数大于0，结束遍历，同理，如果最后一个数小于0也是一样
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-2 ; i++) {
            if (i>0){
                if (nums[i]==nums[i-1]){
                    continue;
                }
            }
            int first=nums[i];
            int low_index=i+1;
            int high_index=nums.length-1;
            while (first<=0&&nums[high_index]>=0&&low_index<high_index){
                int tmp=first+nums[low_index]+nums[high_index];
                if (tmp==0){
                    List<Integer> integers = new ArrayList<>();
                    integers.add(first);
                    integers.add(nums[low_index]);
                    integers.add(nums[high_index]);
                    result.add(integers);
                    while (++low_index<high_index&&nums[low_index-1]==nums[low_index]){
                        continue;
                    }
                    while (low_index<--high_index&&nums[high_index+1]==nums[high_index]){
                        continue;
                    }
                }else if(tmp>0){
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
