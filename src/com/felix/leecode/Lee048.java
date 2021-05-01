package com.felix.leecode;

/**
 * @author felix
 * @date 2021-04-27 16:04
 */
public class Lee048 {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int i = 0; i <matrix.length ; i++) {
            StringBuffer sb=new StringBuffer();
            for (int j = 0; j <matrix[0].length ; j++) {
                sb.append(matrix[i][j]).append(",");
            }
            System.out.println(sb);
        }
    }
    public  static  void rotate(int[][] matrix) {
        int chang=matrix.length;
        int kuan=matrix[0].length;
//            沿/翻转，再沿--翻转，实现右转90度
        for (int i = 0; i <chang ; i++) {
            int x=i;
            int y=chang-i-1;
            for (int j = 0; j <kuan-i ; j++) {
                int k =y-j+x;
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[k][y];
                matrix[k][y]=tmp;
            }
        }


        for (int i = 0; i <chang/2 ; i++) {
            for (int j = 0; j <kuan; j++) {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[chang-i-1][j];
                matrix[chang-i-1][j]=tmp;
            }
        }


    }
}
