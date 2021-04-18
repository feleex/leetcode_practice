package com.felix.leecode;

import java.util.Arrays;

/**
 * @author felix
 * @date 2021-04-13 20:08
 */
public class HW0413 {
//    第二种方法，先全排序，然后二分法找到target最近的数组位置，对比上下各三个值与target的差值。
    public int threenum(int[] nums,int target){
        int result=0;
        int len=nums.length;
//        考虑数组长度小于3的情况
        if (len<3){
           for(int num:nums){
               result+=num;
           }
        }
        Arrays.sort(nums);
        int low=0;
        int high=len-1;
        int mid=low+(high-low)>>>1;
        while(low<high){
            if(nums[mid]==target){
                low=mid;
                high=mid;
                break;
            }
            else if (nums[mid]>target){
                high=mid;
            }else {
                low=mid+1;
            }
        }

        int[] tmpnums=new int[len];
        for (int i = 0; i < len; i++) {
            tmpnums[i]=Math.abs(nums[i]-target);
        }
//      第一种方法，全排序取前三
//       第二种方法，使用堆排序，堆大小为3
        Arrays.sort(tmpnums);

        for (int i = 0; i <3 ; i++) {
            result+=tmpnums[i];
        }

        return result;

    }
//    李佳洺
//    遍历3个最接近target的值
    public int new_threenum(int[] nums,int target){
        int result=0;
        int len=nums.length;
//        考虑数组长度小于3的情况
        if (len<3){
            for(int num:nums){
                result+=num;
            }
        }
        for (int i = 0; i <3 ; i++) {
            int tmp=Integer.MAX_VALUE;
            int num=0;
            int index=0;
            for (int j = 0; j < len; j++) {
                if (Math.abs(nums[j]-target)<tmp){
                    tmp=Math.abs(nums[j]-target);
                    num=nums[j];
                    index=j;
                }
            }
            nums[index]=Integer.MAX_VALUE;
            result+=num;
        }
        return result;

    }

    public static int getmaxheap(int[] nums){
        int result=Integer.MAX_VALUE;
        for (int num:nums){
            result=Math.min(num,result);
        }
        return result;
    }

}
