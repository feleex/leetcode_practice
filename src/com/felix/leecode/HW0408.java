package com.felix.leecode;

/**
 * @author felix
 * @date 2021-04-08 20:05
 */
public class HW0408 {
    public static void main(String[] args) {
        System.out.println(new Object().hashCode()&0x0000FFFF);
    }
    public Boolean find(String[][] matrix,String key){
        if (!(matrix == null | matrix.length == 0)) {
            int input = Integer.valueOf(key);
            int gao = matrix.length;
            int chang = matrix[0].length;
            int x = 0;
            int y = 0;

            for (int i = 0; i < gao; i++) {
                if (Integer.valueOf(matrix[i][0]) == input) {
                    return true;
                } else if (Integer.valueOf(matrix[i][0]) < input) {
                    x = i;
                }
            }
            for (int i = 0; i < chang; i++) {
                if (Integer.valueOf(matrix[x][i]) == input) {
                    return true;
                } else if (Integer.valueOf(matrix[x][i]) < input) {
                    y = i;
                }
            }
        }
        return false;


//        for (int i = 0; i <gao ; i++) {
//            for (int j = 0; j <chang ; j++) {
//
//            }
//        }
    }
}
