package com.felix.leecode;

/**
 * @author felix
 * @date 2021-04-12 11:19
 */
public class Lee287 {
    public static void main(String[] args) {
        System.out.println((5-1)>>>1);
        System.out.println((5-1)/2);
        int[] nums={4,3,1,4,2,4,4};
        System.out.println(func(nums));;
    }
    public static int func(int[] nums){

        int low=1;
        int size=nums.length;
        int high=size-1;
        int mid=low+((high-low)>>>1);
        while (low<high){
            if (countfromto(nums,low,mid)>mid-low+1){
                high=mid;
                mid=low+((high-low)>>>1);
            }else if(countfromto(nums,mid+1,high)>high-mid){
                low=mid+1;
                mid=low+((high-low)>>>1);
            }
        }
        System.out.println("low="+low);
        System.out.println("high="+high);
        return high;
    }
    public static int countfromto(int[] nums,int low,int high){
        int count=0;
        for(int num:nums){
            if (num>=low&&num<=high){
                count++;
            }
        }
        return count;
    }
}
