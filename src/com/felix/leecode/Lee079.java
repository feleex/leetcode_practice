package com.felix.leecode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author felix
 * @date 2021-04-22 15:16
 */
public class Lee079 {
    static class Result{
        boolean flag=false;
        public Result(boolean flag){
            this.flag=flag;
        }
        public boolean getflag(){
            return flag;
        }
    }
    public static void main(String[] args) {
//        System.out.println("123"+'g');
//        String s="1234";
//        System.out.println(s.substring(0,s.length()));
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        char[][] board={{'a','b'},{'c','d'}};
        System.out.println(exist_new(board, "SEE"));
    }
    public static boolean exist(char[][] board, String word) {
        Result result=new Result(false);
        back(result,board,"",new HashSet<String >(),word,0,0);
        return result.getflag();
    }
    public static void back(Result result, char[][] board,String state, Set<String> filter, String word, int x, int y){
        if (word.length()==state.length()){
            result.flag=true;
            return ;
        }
        if (x>board.length-1||y>board[0].length-1||x<0||y<0){
            return;
        }
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                String position=i+","+j;
                char[] chars=word.toCharArray();
                char tmp=chars[state.length()];
                if (board[i][j]==tmp&&!filter.contains(position)){
                    state+=tmp;
                    if (word.length()==state.length()){
                        result.flag=true;
                        break ;
                    }
                    filter.add(position);
                    System.out.println("回溯前1："+state+position);
                    back(result,board,state,filter,word,i-1,j);
                    System.out.println("回溯后1："+state+position);
                    System.out.println("回溯前2："+state+position);
                    back(result,board,state,filter,word,i,j-1);
                    System.out.println("回溯后2："+state+position);
                    System.out.println("回溯前3："+state+position);
                    back(result,board,state,filter,word,i+1,j);
                    System.out.println("回溯后3："+state+position);
                    System.out.println("回溯前4："+state+position);
                    back(result,board,state,filter,word,i,j+1);
                    System.out.println("回溯后4："+state+position);
                    state=state.substring(0,state.length()-1);
                    filter.remove(position);
                }else {
                    continue;
                }
            }
            if (word.length()==state.length()){
                result.flag=true;
                break ;
            }
        }

    }
    public static boolean exist_new(char[][] board, String word) {
        Result result=new Result(false);
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                back_new(result,board,"",new HashSet<String >(),word,i,j);
                if (result.getflag()){
                    break;
                }
            }
            if (result.getflag()){
                break;
            }
        }
//        back(result,board,"",new HashSet<String >(),word,0,0);
        return result.getflag();
    }
    public static void back_new(Result result, char[][] board,String state, Set<String> filter, String word, int i, int j) {
        if (word.length() == state.length()) {
            result.flag = true;
            return;
        }
        if (i > board.length - 1 || j > board[0].length - 1 || i < 0 || j < 0) {
            return;
        }

        String position = i + "," + j;
        char[] chars = word.toCharArray();
        char tmp = chars[state.length()];
        if (board[i][j] == tmp && !filter.contains(position)) {
            state += tmp;
            if (word.length() == state.length()) {
                result.flag = true;
            }
            filter.add(position);
            System.out.println("回溯前1：" + state + position);
            back_new(result, board, state, filter, word, i - 1, j);
            System.out.println("回溯后1：" + state + position);
            System.out.println("回溯前2：" + state + position);
            back_new(result, board, state, filter, word, i, j - 1);
            System.out.println("回溯后2：" + state + position);
            System.out.println("回溯前3：" + state + position);
            back_new(result, board, state, filter, word, i + 1, j);
            System.out.println("回溯后3：" + state + position);
            System.out.println("回溯前4：" + state + position);
            back_new(result, board, state, filter, word, i, j + 1);
            System.out.println("回溯后4：" + state + position);
            state = state.substring(0, state.length() - 1);
            filter.remove(position);
        }
    }
}
