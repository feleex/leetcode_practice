package com.felix.leecode;

/**
 * @author felix
 * @date 2021-06-02 10:30
 */
public class Lee062 {
    public static void main(String[] args) {
        int m=10;
        int n=10;
        int [][] timematrix=new int[m][n];
        for (int i = 0; i <m ; i++) {
            timematrix[i][0]=1;
        }
        for (int i = 0; i <n ; i++) {
            timematrix[0][i]=1;
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                timematrix[i][j]=timematrix[i-1][j]+timematrix[i][j-1];
            }
        }
        System.out.println(timematrix[6][2]);
        System.out.println(timematrix[m-1][n-1]);
    }
    public static int uniquePaths(int m, int n) {

        int [][] timematrix=new int[m][n];
        for (int i = 0; i <m ; i++) {
            timematrix[i][0]=1;
        }
        for (int i = 0; i <n ; i++) {
            timematrix[0][i]=1;
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                timematrix[i][j]=timematrix[i-1][j]+timematrix[i][j-1];
            }
        }
        return timematrix[m-1][n-1];
    }
}
