package com.felix.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author felix
 * @date 2021-04-25 10:22
 */
public class Lee051 {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        back(0,new ArrayList<String>(),n,result);
        return result;
    }
    public static void back(int begin,List<String> state,int n, List<List<String>> result){
        if (state.size()==n){
            List<String> list=new ArrayList<>();
            for (String s : state) {
                list.add(s);
            }
            result.add(list);
            return;
        }

        for (int i = 0; i <n ; i++) {
            if (isvalidpostion(state,begin,i)){
                String tmp="";
                for (int j = 0; j <i ; j++) {
                    tmp+=".";
                }
                tmp+="Q";
                for (int j = i+1; j <n ; j++) {
                    tmp+=".";
                }
                state.add(tmp);
                back(begin+1,state,n,result);
                state.remove(state.size()-1);
            }
        }
    }
    public static boolean isvalidpostion(List<String> state,int begin,int i){
        int high=state.size();
        for (int j = 0; j < high; j++) {
            int qindex=state.get(j).indexOf("Q");
            int xdistance=Math.abs(i-qindex);
            if (xdistance==0||(begin-j)==xdistance){
                return false;
            }
        }
        return true;
    }
}
