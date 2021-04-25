package com.felix.leecode;

import java.util.*;

/**
 * @author felix
 * @date 2021-04-22 14:05
 */
public class Lee047 {
    public static void main(String[] args) {
            int[] nums={2,2,1,1};
        System.out.println(permuteUnique(nums));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer,Integer> allmap=new HashMap<>();
        for (int num : nums) {
            allmap.put(num,allmap.getOrDefault(num,0)+1);
        }
        List<Integer> state=new ArrayList<>();
        Map<Integer,Integer> statemap=new HashMap<>();

        back(result,state,statemap,allmap,nums);
//        lowback(result,state,statemap,allmap,nums,nums);
        return result;
    }
    public static void back(List<List<Integer>> result, List<Integer> state, Map<Integer,Integer> statemap,Map<Integer,Integer> allmap ,int[] nums){
        if (state.size()==nums.length){
            List<Integer> list=new ArrayList<>();
            for (Integer integer : state) {
                list.add(integer);
            }
            result.add(list);
            return;
        }
        for (int i = 0; i <nums.length ; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if (statemap.getOrDefault(nums[i],0)<allmap.get(nums[i])){
                state.add(nums[i]);
                statemap.put(nums[i],statemap.getOrDefault(nums[i],0)+1);
                System.out.println("回溯前："+state);
                back(result,state,statemap,allmap,nums);
                System.out.println("回溯后："+state);
                statemap.put(nums[i],statemap.get(nums[i])-1);
                state.remove(state.size()-1);
                System.out.println("删除后："+state);
            }

        }
    }
    public static void lowback(List<List<Integer>> result, List<Integer> state, Map<Integer,Integer> statemap,Map<Integer,Integer> allmap ,int[] nums,int[] originnums){
        if (state.size()==originnums.length){
            List<Integer> list=new ArrayList<>();
            for (Integer integer : state) {
                list.add(integer);
            }
            result.add(list);
            return;
        }
        for (int i = 0; i <nums.length ; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            state.add(nums[i]);
//            statemap.put(nums[i],statemap.getOrDefault(nums[i],0)+1);
            System.out.println("回溯前："+state);
            int[] nextnums=new int[nums.length-1];
            int flag=0;
            for (int j = 0; j <nums.length ; j++) {
                if (j!=i){
                    nextnums[flag]=nums[j];
                    flag++;
                }
            }
            lowback(result,state,statemap,allmap,nextnums,originnums);
            System.out.println("回溯后："+state);
//            statemap.put(nums[i],statemap.get(nums[i])-1);
            state.remove(state.size()-1);
            System.out.println("删除后："+state);


        }
    }
}
