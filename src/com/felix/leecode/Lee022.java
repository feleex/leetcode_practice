package com.felix.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author felix
 * @date 2021-04-19 22:32
 */
public class Lee022 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        backtrack("",n,n,result);

        return result;
    }
    public  static  void backtrack(String str,int left,int right,List<String> res){
        if (left==0&&right==0){
            res.add(str);
            return;
        }
        if (left>right){
            return;
        }
//        if (left==right){
//            str+="(";
//            left--;
//            backtrack(str,left,right,res);
//        }

        if (left>0){
            backtrack(str+"(",left-1,right,res);

        }
        if (right>0){
            backtrack(str+")",left,right-1,res);
        }
    }
    private static void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }

}
