package com.felix.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author felix
 * @date 2021-04-17 08:33
 */
public class Lee36 {
    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}}
                ;
        System.out.println(func(board));;

    }
    public static boolean func(char[][] board){
//        遍历三次，横，纵，九宫格

        for (int i = 0; i < board.length; i++) {
            Set<Character> set=new HashSet<>();
            int num=0;
            for (int j = 0; j <board[0].length ; j++) {
                if (board[i][j]!='.'){
                    set.add(board[i][j]);
                    num++;
                }

            }
           if (set.size()<num){
               return false;
           }
        }
        for (int i = 0; i < board[0].length; i++) {
            Set<Character> set=new HashSet<>();
            int num=0;
            for (int j = 0; j <board.length ; j++) {
                if (board[i][j]!='.'){
                    set.add(board[i][j]);
                    num++;
                }
            }
            if (set.size()<num){
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3 ; j++) {
                Set<Character> set=new HashSet<>();
                int num=0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i*3+k][j*3+l]!='.'){
                            set.add(board[i*3+k][j*3+l]);
                            num++;
                        }

                    }
                }
                if (set.size()<num){
                    return false;
                }
            }
        }
        return true;
    }
}
