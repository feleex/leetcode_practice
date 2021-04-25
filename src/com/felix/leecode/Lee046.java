package com.felix.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author felix
 * @date 2021-04-22 13:52
 */
public class Lee046 {
    public static void main(String[] args) {
    int[] nums={1,2,3};
        System.out.println(permute(nums));

    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        back(result,new ArrayList<Integer>(),nums);
        return result;
    }
    public static void back(List<List<Integer>> result,List<Integer> state,int[] nums){
        if (state.size()==nums.length){
            List<Integer> list=new ArrayList<>();
            for (Integer integer : state) {
                list.add(integer);
            }
            result.add(list);
            return;
        }
        for (int i = 0; i <nums.length ; i++) {
            if (state.contains(nums[i])){
                continue;
            }
            if (state.size()<nums.length){
                state.add(nums[i]);
                back(result,state,nums);
                state.remove((Integer) nums[i]);
            }
        }


    }
}
