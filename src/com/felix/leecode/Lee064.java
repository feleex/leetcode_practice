package com.felix.leecode;

/**
 * @author felix
 * @date 2021-06-02 15:38
 */
public class Lee064 {
    public static void main(String[] args) {
       int[][] nums= {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(nums));
    }
    public static int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] nums=new int[m][n];
        nums[0][0]=grid[0][0];
        for (int i = 1; i <m ; i++) {
            nums[i][0]=nums[i-1][0]+grid[i][0];
        }
        for (int i = 1; i <n ; i++) {
            nums[0][i]=nums[0][i-1]+grid[0][i];
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                nums[i][j]=grid[i][j]+Math.min(nums[i-1][j],nums[i][j-1]);
            }
        }

    return nums[m-1][n-1];
    }
}
