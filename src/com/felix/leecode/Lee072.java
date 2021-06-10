package com.felix.leecode;

/**
 * @author felix
 * @date 2021-06-04 14:25
 */
public class Lee072 {
    public static void main(String[] args) {
    String word1 = "intention", word2 = "execution";
        System.out.println(minDistance(word1, word2));

    }
    public static int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        char[] chars1=word1.toCharArray();
        char[] chars2=word2.toCharArray();

        for (int i = 1; i <m+1 ; i++) {
            dp[i][0]=i;
        }
        for (int i = 1; i <n+1 ; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <m+1 ; i++) {
            for (int j = 1; j <n+1 ; j++) {
                if (chars1[i-1]==chars2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[m][n];
    }
}
