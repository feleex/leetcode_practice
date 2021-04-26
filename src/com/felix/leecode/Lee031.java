package com.felix.leecode;

import java.util.Arrays;

/**
 * @author felix
 * @date 2021-04-25 17:17
 */
public class Lee031 {
    public static void main(String[] args) {
//        int[] nums={1,3,2};
        int[] nums={1,4,8,7,6,3,2};
        int[] result=nums;
        permutation(nums);
        String s="";
        for (int i : nums) {
            s+=i;
        }
        System.out.println(s);
    }
    public static void nextPermutation(int[] nums) {
        int length=nums.length;
        int[] resultnums=new int[length];
        System.arraycopy(nums,0,resultnums,0,length);
        boolean isxunhuan=true;
        for (int i = length-1; i >0&&isxunhuan ; i--) {
            for (int j = i-1; j >=0 &&isxunhuan; j--) {
                if (nums[i]>nums[j]){
                    int tmp= nums[j];
//                    resultnums[i]=resultnums[j];
                    resultnums[j]=nums[i];
                    resultnums[j+1]=tmp;
                    int flag=1;
                    for (int k = j+2; k <=i ; k++,flag++) {
                        resultnums[k]=nums[i-flag];
                    }
                    isxunhuan=false;

                }
            }
        }
        if (isxunhuan){
            for (int i = 0; i <length ; i++) {
                resultnums[i]=nums[length-1-i];
            }
        }
        System.arraycopy(resultnums,0,nums,0,length);
//        nums=resultnums;

    }
    public static void permutation(int[] nums) {
        int length=nums.length;
        int[] resultnums=new int[length];
        System.arraycopy(nums,0,resultnums,0,length);
        boolean isxunhuan=true;
        for (int i = length-2; i >=0&&isxunhuan ; i--) {
            for (int j = length - 1; j > i && isxunhuan; j--) {
                if (nums[j] > nums[i]) {
                    int tmp = nums[i];
//                    resultnums[i]=resultnums[j];
                    resultnums[i] = nums[j];
                    int index=i+1;
                    for (int k = length-1; k >j&&index<length ; k--) {
                        resultnums[index]=nums[k];
                        index++;
                    }
                    resultnums[index]=nums[i];
                    index++;
                    for (int k = j-1; k >i&&index<length ; k--) {
                        resultnums[index]=nums[k];
                        index++;
                    }
//                    int flag = 1;
//                    for (int k = j + 2; k < length; k++, flag++) {
//                        resultnums[k] = nums[length - flag - 1];
//                    }
                    isxunhuan = false;

                }
            }
        }

        if (isxunhuan){
            for (int i = 0; i <length ; i++) {
                resultnums[i]=nums[length-1-i];
            }
        }
        System.arraycopy(resultnums,0,nums,0,length);
//        nums=resultnums;

    }
}
