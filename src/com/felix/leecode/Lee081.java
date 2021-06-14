package com.felix.leecode;

/**
 * @author felix
 * @date 2021-06-12 23:05
 */
public class Lee081 {
    public static void main(String[] args) {

    }
    public static boolean search(int[] nums, int target) {
//        for (int num : nums) {
//            if (num==target){
//                return true;
//            }
//        }
//        return false;
        int start=0;
        int end=nums.length-1;
        int mid=(end-start)/2+start;
//
        if (nums[mid]>=nums[start]){
            binarysearch(nums,target,start,mid);
        }else {
            binarysearch(nums,target,mid+1,end);
        }
        return false;
    }
    public static boolean binarysearch(int[] nums,int target,int start,int end){
        if (end-start<=1){
            return nums[end]==target||nums[start]==target;
        }
        int mid=(end-start)/2+start;
        if (nums[mid]==target){
            return true;
        }else if (nums[mid]>target){
            return binarysearch(nums,target,start,mid);
        }else {
            return binarysearch(nums,target,mid+1,end);
        }
    }
    public static boolean twostepbinarysearch(int[] nums,int target,int start,int end){
        if (end-start<=1){
            return nums[end]==target||nums[start]==target;
        }
        int mid=(end-start)/2+start;
        if (nums[mid]>nums[start]&&nums[mid]>target&&target>nums[start]){
            return binarysearch(nums,target,start,end);
        }
        if (nums[mid]==target){
            return true;
        }else if (nums[mid]>target){
            return binarysearch(nums,target,start,mid);
        }else {
            return binarysearch(nums,target,mid+1,end);
        }
    }

}
