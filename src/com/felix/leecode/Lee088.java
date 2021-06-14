package com.felix.leecode;

/**
 * @author felix
 * @date 2021-06-13 10:09
 */
public class Lee088 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=0;
        int p2=0;
        int [] result=new int[m+n];
        while (p1<m&&p2<n){
            if (nums1[p1]<nums2[p2]){
                result[p1+p2]=nums1[p1];
                p1++;
            }else {
                result[p1+p2]=nums2[p2];
                p2++;
            }
        }
        while (p1<m){
            result[p1+p2]=nums1[p1];
            p1++;
        }
        while (p2<n){
            result[p1+p2]=nums2[p2];
            p2++;
        }
        System.arraycopy(result,0,nums1,0,m+n);
    }

    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        merge(nums1,nums1.length-nums2.length,nums2,nums2.length);
        CommonUtil.printintarray(nums1);
    }
}
