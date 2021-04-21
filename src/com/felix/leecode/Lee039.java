package com.felix.leecode;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author felix
 * @date 2021-04-20 18:59
 */
public class Lee039 {
    public static void main(String[] args) {
        int[] nums={2,3,6,7};
        int a=7;
        System.out.println(combinationSum(nums, a));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        for (int candidate : candidates) {
            hashSet.add(candidate);
        }
        int size=hashSet.size();
        int[] quchong_candidates=new int[size];
        int ele=0;
        for (Integer integer : hashSet) {
            quchong_candidates[ele]=integer;
            ele++;
        }
        Arrays.sort(quchong_candidates);
        lowback(0,0,quchong_candidates,target,new ArrayList<Integer>(),result);


        return result;
    }
    public static void back(int begin,int tmpvalue,int[] quchong_candidates,int target,List<Integer> state,List<List<Integer>> result){
        ArrayList<Integer> integers = new ArrayList<>();
        for (Integer integer : state) {
            integers.add(integer);
        }
        for (int i = begin; i <quchong_candidates.length ; i++) {
            int tmp=tmpvalue+quchong_candidates[i];
            if (tmp==target){
                integers.add(quchong_candidates[i]);
                result.add(integers);
                break;
            }
            if(tmp>target){
                break;
            }
            if (tmp<target){
                integers.add(quchong_candidates[i]);
                back(i,tmp,quchong_candidates,target,integers,result);
                integers.remove(integers.size()-1);
            }
        }
    }
    public static void lowback(int begin,int tmpvalue,int[] quchong_candidates,int target,List<Integer> state,List<List<Integer>> result){
        int sum=0;
        for (Integer integer : state) {
            sum+=integer;
        }
        if (sum==target){
            List<Integer> list=new ArrayList<>();
            for (Integer integer : state) {
                list.add(integer);
            }
            result.add(list);
            return;

        }
        for (int i = begin; i <quchong_candidates.length ; i++) {
            int tmp=tmpvalue+quchong_candidates[i];
            if(tmp>target){
                break;
            }
            if (tmp<=target){
                state.add(quchong_candidates[i]);
                lowback(i,tmp,quchong_candidates,target,state,result);
                state.remove(state.size()-1);

            }
        }
    }

}
