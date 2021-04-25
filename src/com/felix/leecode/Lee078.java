package com.felix.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author felix
 * @date 2021-04-22 15:04
 */
public class Lee078 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        for (int i = 0; i <=nums.length ; i++) {
            back(result,new ArrayList<Integer>(),nums,i,0);
        }
        return result;
    }
    public static void back(List<List<Integer>> result,List<Integer> state,int[] nums,int k,int begin){
        if (state.size()==k){
            List<Integer> list=new ArrayList<>();
            for (Integer integer : state) {
                list.add(integer);
            }
            result.add(list);
            return;
        }
        for (int i = begin; i <nums.length; i++) {
            state.add(nums[i]);
            back(result,state,nums,k,i+1);
            state.remove(state.size()-1);
        }
    }
}
