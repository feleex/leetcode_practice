package com.felix.leecode;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author felix
 * @date 2021-04-14 22:09
 */
public class Lee004 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        java.lang.Class.forName("java.lang.String",true,contextClassLoader);

//        DriverManager.getConnection("");
//        System.out.println(Thread.currentThread().getContextClassLoader());;
        int[] nums1={1,2};
        int[] nums2={3,4};
        System.out.println(func(nums1, nums2));
    }
    public static double func(int[] nums1, int[] nums2){
        double result=0;
        int x=nums1.length;
        int y=nums2.length;
        int i=0,j=0;
        int[] mergenums=new int[x+y];
        while (i<x&&j<y){
            if (nums1[i]<=nums2[j]){
                mergenums[i+j]=nums1[i];
                i++;
            }else {
                mergenums[i+j]=nums2[j];
                j++;
            }
        }
        while (i<x){
            mergenums[i+j]=nums1[i];
            i++;
        }
        while (j<y){
            mergenums[i+j]=nums2[j];
            j++;
        }
        if (mergenums.length%2==1){
            result=1.0*mergenums[mergenums.length/2];
        }else {
            result=(mergenums[mergenums.length/2]+mergenums[mergenums.length/2-1])*1.0/2;
        }

        return result;

    }
}
