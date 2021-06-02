package com.felix.leecode;

/**
 * @author felix
 * @date 2021-06-02 14:52
 */
public class Lee063 {
    public static void main(String[] args) {
        int[][] obstacle={{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacle));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if (obstacleGrid[m-1][n-1]==1||obstacleGrid[0][0]==1){
            return 0;
        }
        int nums[][]=new int[m][n];
        for (int i = 0; i <m ; i++) {
            if (obstacleGrid[i][0]==1){
                break;
            }
            nums[i][0]=1;
        }
        for (int i = 0; i <n ; i++) {
            if (obstacleGrid[0][i]==1){
                break;
            }
            nums[0][i]=1;
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                nums[i][j]=nums[i-1][j]*(obstacleGrid[i-1][j]-1)*(-1)+nums[i][j-1]*(obstacleGrid[i][j-1]-1)*(-1);
            }
        }
        return nums[m-1][n-1];
    }
}
