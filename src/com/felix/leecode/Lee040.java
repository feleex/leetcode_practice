package com.felix.leecode;

import java.util.*;

/**
 * @author felix
 * @date 2021-04-21 14:24
 */
public class Lee040 {
    public static void main(String[] args) {
//        System.out.println(String.valueOf('0'));
        new ArrayList();
        int[] nums={14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
        System.out.println(combinationSum2(nums, 27));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        back(0,result,new ArrayList<Integer>(),target,candidates,target);
//        Set<String> resultset=new HashSet<>();
//        lowback(0,resultset,"",target,candidates,target);
//        for (String s : resultset) {
//            char[] chars=s.toCharArray();
//            List<Integer> list=new ArrayList<>();
//            for (char aChar : chars) {
//                int num=Integer.valueOf(String.valueOf(aChar));
//                list.add(num);
//            }
//            result.add(list);
//        }
        Set<String> panchong=new HashSet<>();
        List<List<Integer>> lastresult=new ArrayList<>();
        result.iterator();
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list=result.get(i);
            if (!panchong.contains(list.toString())){
                lastresult.add(list);
                panchong.add(list.toString());
            }
        }
        return lastresult;
    }
    public static void back(int begin,List<List<Integer>> res,List<Integer> state,int left,int[]  candidates,int target){
        if (left==0){
            List<Integer> list=new ArrayList<>();
            for (Integer integer : state) {
                list.add(integer);
            }

            res.add(list);
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (left<0){
                break;
            }
            if (left>0){
                if (left<candidates[i]){
                    break;
                }

                if (begin==0&&i>0&&candidates[i]==candidates[i-1]){
                    continue;
                }
//                while (i<candidates.length-1&&candidates[i]==candidates[i+1]){
//                    continue;

                state.add(candidates[i]);
                System.out.println("回溯前："+state);
                back(i+1,res,state,left-candidates[i],candidates,target);
                System.out.println("回溯后："+state);
                state.remove(state.size()-1);
                System.out.println("删除后："+state);
            }
        }


    }
    public static void lowback(int begin, Set<String> res, String state, int left, int[]  candidates, int target){
        if (left==0){
//            List<Integer> list=new ArrayList<>();
            res.add(state);
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (left<0){
                break;
            }
            if (left>0){
                if (left<candidates[i]){
                    break;
                }
                if (begin==0&&i>0&&candidates[i]==candidates[i-1]){
                    continue;
                }
//                while (i<candidates.length-1&&candidates[i]==candidates[i+1]){
//                    continue;

                state+=candidates[i];
                System.out.println("回溯前："+state);
                lowback(i+1,res,state,left-candidates[i],candidates,target);
                System.out.println("回溯后："+state);
                state=state.substring(0,state.length()-1);
                System.out.println("删除后："+state);
            }
        }


    }
}
