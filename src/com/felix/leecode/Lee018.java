package com.felix.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author felix
 * @date 2021-04-19 18:14
 */
public class Lee018 {
    public static void main(String[] args) {
        int[] nums={1,0,-1,0,-2,2};
        System.out.println(fourSum(nums,0));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-3 ; i++) {
            if (i>0){
                if (nums[i-1]==nums[i]){
                    continue;
                }
            }
            if (nums[i]>Math.ceil(target/4.0)){
                break;
            }
            for (int j = i+1; j <nums.length-2 ; j++) {
                if (j>i+1){
                    if (nums[j-1]==nums[j]){
                        continue;
                    }
                }
                if ((nums[i]+nums[j])>Math.ceil(target/2.0)){
                    break;
                }
                int first=nums[i];
                int second=nums[j];
                int low_index=j+1;
                int high_index=nums.length-1;
                while (low_index<high_index){
                    int tmp=first+second+nums[low_index]+nums[high_index];
                    if (tmp==target){
                        List<Integer> elist=new ArrayList<>();
                        elist.add(first);
                        elist.add(second);
                        elist.add(nums[low_index]);
                        elist.add(nums[high_index]);
                        result.add(elist);
                        while (--high_index>low_index&&nums[high_index]==nums[high_index+1]){
                            continue;
                        }
                        while (++low_index<high_index&&nums[low_index]==nums[low_index-1]){
                            continue;
                        }
                    }else if(tmp>target){
                        while (--high_index>low_index&&nums[high_index]==nums[high_index+1]){
                            continue;
                        }
                    }else if (tmp<target){
                        while (++low_index<high_index&&nums[low_index]==nums[low_index-1]){
                            continue;
                        }
                    }
                }
            }
        }
        return result;
    }
}
