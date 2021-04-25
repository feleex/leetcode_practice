package com.felix.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author felix
 * @date 2021-04-22 14:50
 */
public class Lee077 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        back(result,new ArrayList<Integer>(),n,k,1);
        return result;
    }
    public static void back(List<List<Integer>> result,List<Integer> state,int n,int k,int begin){
        if (state.size()==k){
            List<Integer> list=new ArrayList<>();
            for (Integer integer : state) {
                list.add(integer);
            }
            result.add(list);
            return;
        }
        for (int i = begin; i < n+1; i++) {
            if (state.contains(i)){
             continue;
            }
            state.add(i);
            back(result,state,n,k,i+1);
            state.remove(state.size()-1);
        }
    }
}
